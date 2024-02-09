package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.countriesapi.entities.Country;
import projects.countriesapi.entities.Providers;
import projects.countriesapi.response.ProvidersResponseRest;
import projects.countriesapi.services.ProvidersService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/providers")
public class ProvidersController {
    @Autowired
    private ProvidersService providersService;

    @GetMapping("")
    public ResponseEntity<ProvidersResponseRest> consultarProviders() {
        ResponseEntity<ProvidersResponseRest> response = providersService.buscarProviders();
        return response;
    }

    @PostMapping("")
    public ResponseEntity<ProvidersResponseRest> crear(@RequestBody Providers request) {
        ResponseEntity<ProvidersResponseRest> response = providersService.crear(request);
        return response;
    }
}
