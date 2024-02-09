package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.countriesapi.response.RolesResponseRest;
import projects.countriesapi.response.UserResponseRest;
import projects.countriesapi.services.UserService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("")
    public ResponseEntity<UserResponseRest> consultarRoles() {
        ResponseEntity<UserResponseRest> response = userService.buscarUsers();
        return response;
    }
}
