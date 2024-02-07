package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Country;
import projects.countriesapi.response.CountryResponseRest;

public interface CountryService {


    public ResponseEntity<CountryResponseRest> buscarPaises();
    public ResponseEntity<CountryResponseRest> buscarPorId(long id);
    public ResponseEntity<CountryResponseRest> crear(Country country);
    public ResponseEntity<CountryResponseRest> actualizar(Country country, Long id);
    public ResponseEntity<CountryResponseRest> eliminar(Long id);
}
