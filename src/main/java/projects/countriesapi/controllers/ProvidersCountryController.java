package projects.countriesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.countriesapi.entities.Providers;
import projects.countriesapi.entities.ProvidersCountry;
import projects.countriesapi.response.CountryResponseRest;
import projects.countriesapi.response.ProvidersCountryResponseRest;
import projects.countriesapi.response.ProvidersResponseRest;
import projects.countriesapi.services.ProvidersCountryService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/providers-country")
public class ProvidersCountryController {
    @Autowired
    public ProvidersCountryService providersCountryService;

    @GetMapping("")
    public ResponseEntity<ProvidersCountryResponseRest> consultarProvidersc() {
        ResponseEntity<ProvidersCountryResponseRest> response = providersCountryService.buscarProvidersCountry();
        return response;
    }


    @PostMapping("")
    public ResponseEntity<ProvidersCountryResponseRest> crear(@RequestBody ProvidersCountry request) {
        ResponseEntity<ProvidersCountryResponseRest> response = providersCountryService.crearProvidersCountry(request);
        return response;
    }

    @GetMapping("/{field}")
    public ResponseEntity<ProvidersCountryResponseRest> buscarSort(@PathVariable String field){
        ResponseEntity<ProvidersCountryResponseRest> response = providersCountryService.buscarSortProvidersCountry(field);
        return response;
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<ProvidersCountryResponseRest> pagination(@PathVariable int offset, @PathVariable int pageSize){
        ResponseEntity<ProvidersCountryResponseRest> response = providersCountryService.paginationProvidersCountry(offset, pageSize);
        return response;
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public ResponseEntity<ProvidersCountryResponseRest> paginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        ResponseEntity<ProvidersCountryResponseRest> response = providersCountryService.paginationAndSortingProvidersCountry(offset, pageSize, field);
        return response;
    }
}
