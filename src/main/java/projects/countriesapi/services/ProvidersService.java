package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Providers;
import projects.countriesapi.response.ProvidersResponseRest;

public interface ProvidersService {


    public ResponseEntity<ProvidersResponseRest> buscarProviders();


    public ResponseEntity<ProvidersResponseRest> crear(Providers providers);
}
