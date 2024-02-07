package projects.countriesapi.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Providers;
import projects.countriesapi.repository.ProvidersRepository;
import projects.countriesapi.response.ProvidersResponseRest;
import projects.countriesapi.services.ProvidersService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvidersServiceImpl implements ProvidersService {

    private static final Logger log = LoggerFactory.getLogger(ProvidersServiceImpl.class);
    
    @Autowired
    private ProvidersRepository providersRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProvidersResponseRest> buscarProviders() {

        ProvidersResponseRest response = new ProvidersResponseRest();

        try {
            List<Providers> providers = providersRepository.findAll();
            response.getProvidersResponse().setProviders(providers);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("error al consultar providers: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<ProvidersResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<ProvidersResponseRest>(response, HttpStatus.OK); //devuelve 200
    }

    @Override
    @Transactional
    public ResponseEntity<ProvidersResponseRest> crear(Providers providers) {
        log.info("Inicio metodo crear");

        ProvidersResponseRest response = new ProvidersResponseRest();
        List<Providers> list = new ArrayList<>();

        try {

            Providers ProvidersGuardado = providersRepository.save(providers);

            if( ProvidersGuardado != null) {
                list.add(ProvidersGuardado);
                response.getProvidersResponse().setProviders(list);
            } else {
                log.error("Error en grabar Providers");
                response.setMetadata("Respuesta nok", "-1", "Providers no guardada");
                return new ResponseEntity<ProvidersResponseRest>(response, HttpStatus.BAD_REQUEST);
            }

        } catch( Exception e) {
            log.error("Error en grabar Providers");
            response.setMetadata("Respuesta nok", "-1", "Error al grabar Providers");
            return new ResponseEntity<ProvidersResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.setMetadata("Respuesta ok", "00", "Providers creada");
        return new ResponseEntity<ProvidersResponseRest>(response, HttpStatus.OK); //devuelve 200
    }
    
    
}
