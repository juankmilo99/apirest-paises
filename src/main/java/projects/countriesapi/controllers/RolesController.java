package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.countriesapi.response.RolesResponseRest;
import projects.countriesapi.response.UserRolesResponseRest;
import projects.countriesapi.services.RolesService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    public RolesService rolesService;

    @GetMapping("")
    public ResponseEntity<RolesResponseRest> consultarRoles() {
        ResponseEntity<RolesResponseRest> response = rolesService.buscarRoles();
        return response;
    }
}
