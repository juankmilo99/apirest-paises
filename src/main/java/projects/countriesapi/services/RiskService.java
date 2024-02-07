package projects.countriesapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.response.RiskResponseRest;

public interface RiskService {



    public ResponseEntity<RiskResponseRest> buscarRisk();
}
