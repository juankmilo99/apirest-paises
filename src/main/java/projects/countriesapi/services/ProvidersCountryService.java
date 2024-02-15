package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.ProvidersCountry;
import projects.countriesapi.response.ProvidersCountryResponseRest;

public interface ProvidersCountryService {

    public ResponseEntity<ProvidersCountryResponseRest> buscarProvidersCountry();





     public ResponseEntity<ProvidersCountryResponseRest> buscarSortProvidersCountry(String field);


   public ResponseEntity<ProvidersCountryResponseRest> paginationProvidersCountry(int offset, int pageSize);


    public ResponseEntity<ProvidersCountryResponseRest> paginationAndSortingProvidersCountry(int offset, int pageSize, String field);

    public ResponseEntity<ProvidersCountryResponseRest> crearProvidersCountry(ProvidersCountry providersCountry);


    public ResponseEntity<ProvidersCountryResponseRest> buscarProvidersCountryPorCode(String countryCode);


}
