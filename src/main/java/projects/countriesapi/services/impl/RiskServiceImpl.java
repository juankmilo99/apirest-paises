package projects.countriesapi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Risk;
import projects.countriesapi.repository.RiskRepository;
import projects.countriesapi.response.RiskResponseRest;
import projects.countriesapi.services.RiskService;

import java.util.List;

@Service
public class RiskServiceImpl implements RiskService {

    private static final Logger log = LoggerFactory.getLogger(RiskServiceImpl.class);

    @Autowired
    private RiskRepository riskRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<RiskResponseRest> buscarRisk() {

        RiskResponseRest response = new RiskResponseRest();

        try {

            List<Risk> risks = riskRepository.findAll();

            response.getRiskResponse().setRisks(risks);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar usuarios");
            log.error("error al consultar usuarios: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<RiskResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<RiskResponseRest>(response, HttpStatus.OK); //devuelve 200
    }
}
