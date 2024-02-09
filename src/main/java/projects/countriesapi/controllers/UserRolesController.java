package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.countriesapi.response.ProvidersCountryResponseRest;
import projects.countriesapi.response.UserRolesResponseRest;
import projects.countriesapi.services.UserRolesService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user-roles")
public class UserRolesController {

    @Autowired
    public UserRolesService userRolesService;

    @GetMapping("")
    public ResponseEntity<UserRolesResponseRest> consultarUserRoles() {
        ResponseEntity<UserRolesResponseRest> response = userRolesService.buscarUserRoles();
        return response;
    }
}
