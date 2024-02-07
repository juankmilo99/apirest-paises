package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.ProvidersCountry;
import projects.countriesapi.response.ProvidersCountryResponseRest;

public interface ProvidersCountryService {

    public ResponseEntity<ProvidersCountryResponseRest> buscarProvidersCountry();


    public ResponseEntity<ProvidersCountryResponseRest> crearProvidersCountry(ProvidersCountry providersCountry);


    public ResponseEntity<ProvidersCountryResponseRest> buscarProvidersCountryPorCode(String countryCode);
}
