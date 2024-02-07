package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import projects.countriesapi.request.AuthRequest;
import projects.countriesapi.response.TokenResponse;
import projects.countriesapi.services.impl.JwtService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/authenticate")
public class TokenController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContrasenia()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsuario());

        final String jwt = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new TokenResponse(jwt));
    }

}
