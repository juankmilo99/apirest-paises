package projects.countriesapi.services.impl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import projects.countriesapi.entities.Country;
import projects.countriesapi.repository.CountryRepository;
import projects.countriesapi.response.CountryResponseRest;
import projects.countriesapi.services.CountryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    //logger para las excepciones
    private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);


    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CountryResponseRest> buscarPaises() {

        CountryResponseRest response = new CountryResponseRest();

        try {
            List<Country> countries = countryRepository.findAll();
            response.getCountryResponse().setCountries(countries);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar paises");
            log.error("error al consultar paises: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<CountryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<CountryResponseRest>(response, HttpStatus.OK); //devuelve 200
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CountryResponseRest> buscarPorId(long id){
        CountryResponseRest response = new CountryResponseRest();
        List<Country> list = new ArrayList<>();

        try {
            Optional<Country> countries = countryRepository.findById(id);

            if (countries.isPresent()) {
                list.add(countries.get());
                response.getCountryResponse().setCountries(list);
            } else {
                log.error("Error en consultar pais");
                response.setMetadata("Respuesta nok", "-1", "pais no encontrada");
                return new ResponseEntity<CountryResponseRest>(response, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            log.error("Error en consultar pais");
            response.setMetadata("Respuesta nok", "-1", "Error al consultar pais");
            return new ResponseEntity<CountryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        return new ResponseEntity<CountryResponseRest>(response, HttpStatus.OK); //devuelve 200

    }

    @Override
    @Transactional
    public ResponseEntity<CountryResponseRest> crear(Country country) {
        log.info("Inicio metodo crear Country");

        CountryResponseRest response = new CountryResponseRest();
        List<Country> list = new ArrayList<>();

        try {

            Country countryGuardado = countryRepository.save(country);

            if( countryGuardado != null) {
                list.add(countryGuardado);
                response.getCountryResponse().setCountries(list);
            } else {
                log.error("Error en grabar Country");
                response.setMetadata("Respuesta nok", "-1", "Country no guardada");
                return new ResponseEntity<CountryResponseRest>(response, HttpStatus.BAD_REQUEST);
            }

        } catch( Exception e) {
            log.error("Error en grabar Country");
            response.setMetadata("Respuesta nok", "-1", "Error al grabar Country");
            return new ResponseEntity<CountryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.setMetadata("Respuesta ok", "00", "Country creada");
        return new ResponseEntity<CountryResponseRest>(response, HttpStatus.OK); //devuelve 200
    }

    @Override
    @Transactional
    public ResponseEntity<CountryResponseRest> actualizar(Country country, Long id) {

        log.info("Inicio metodo actualizar");

        CountryResponseRest response = new CountryResponseRest();
        List<Country> list = new ArrayList<>();

        try {

            Optional<Country> CountryBuscada = countryRepository.findById(id);

            if (CountryBuscada.isPresent()) {
                CountryBuscada.get().setName(country.getName());
                CountryBuscada.get().setCode(country.getCode());
                CountryBuscada.get().setFlag(country.getFlag());

                Country CountryActualizar = countryRepository.save(CountryBuscada.get()); //actualizando

                if( CountryActualizar != null ) {
                    response.setMetadata("Respuesta ok", "00", "Country actualizada");
                    list.add(CountryActualizar);
                    response.getCountryResponse().setCountries(list);
                } else {
                    log.error("error en actualizar Country");
                    response.setMetadata("Respuesta nok", "-1", "Country no actualizada");
                    return new ResponseEntity<CountryResponseRest>(response, HttpStatus.BAD_REQUEST);
                }


            } else {
                log.error("error en actualizar Country");
                response.setMetadata("Respuesta nok", "-1", "Country no actualizada");
                return new ResponseEntity<CountryResponseRest>(response, HttpStatus.NOT_FOUND);
            }

        } catch ( Exception e) {
            log.error("error en actualizar Country", e.getMessage());
            e.getStackTrace();
            response.setMetadata("Respuesta nok", "-1", "Country no actualizada");
            return new ResponseEntity<CountryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CountryResponseRest>(response, HttpStatus.OK);

    }

    @Override
    @Transactional
    public ResponseEntity<CountryResponseRest> eliminar(Long id) {

        log.info("Inicio metodo eliminar country");

        CountryResponseRest response = new CountryResponseRest();

        try {

            //eliminamos el registro
            countryRepository.deleteById(id);
            response.setMetadata("Respuesta ok", "00", "country eliminada");

        } catch (Exception e) {
            log.error("error en eliminar categoria", e.getMessage());
            e.getStackTrace();
            response.setMetadata("Respuesta nok", "-1", "country no eliminada");
            return new ResponseEntity<CountryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CountryResponseRest>(response, HttpStatus.OK);

    }


}
