package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import projects.countriesapi.entities.Country;
import projects.countriesapi.response.CountryResponseRest;
import projects.countriesapi.services.CountryService;

import java.util.Collection;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/countries")
public class Countrycontroller {

    @Autowired
    private CountryService countryService;

    @GetMapping("")

    public ResponseEntity<CountryResponseRest> consultarPaises() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        authorities.forEach(authority -> {
            System.out.println("Rol: " + authority.getAuthority());
        });
        ResponseEntity<CountryResponseRest> response = countryService.buscarPaises();
        return response;

    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponseRest> buscarPorId(@PathVariable Long id){
        ResponseEntity<CountryResponseRest> response = countryService.buscarPorId(id);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<CountryResponseRest> crear(@RequestBody Country request) {
        ResponseEntity<CountryResponseRest> response = countryService.crear(request);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponseRest> actualizar (@RequestBody Country request, @PathVariable Long id) {
        ResponseEntity<CountryResponseRest> response = countryService.actualizar(request, id);
        return response;
    }
@DeleteMapping("/{id}")
    public ResponseEntity<CountryResponseRest> eliminar (@PathVariable Long id) {
        ResponseEntity<CountryResponseRest> response = countryService.eliminar(id);
        return response;
    }
}
