package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.countriesapi.response.RiskResponseRest;
import projects.countriesapi.response.UserRolesResponseRest;
import projects.countriesapi.services.RiskService;
import projects.countriesapi.services.UserRolesService;

@RestController
@RequestMapping("/risks")
public class RiskController {
    @Autowired
    public RiskService riskService;

    @GetMapping("")
    public ResponseEntity<RiskResponseRest> consultarRisk() {
        ResponseEntity<RiskResponseRest> response = riskService.buscarRisk();
        return response;
    }
}
