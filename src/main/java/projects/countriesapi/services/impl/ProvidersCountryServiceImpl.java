package projects.countriesapi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Country;
import projects.countriesapi.entities.Providers;
import projects.countriesapi.entities.ProvidersCountry;
import projects.countriesapi.repository.CountryRepository;
import projects.countriesapi.repository.ProvidersCountryRepository;
import projects.countriesapi.repository.ProvidersRepository;
import projects.countriesapi.response.ProvidersCountryResponseRest;

import projects.countriesapi.services.ProvidersCountryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvidersCountryServiceImpl implements ProvidersCountryService {
    private static final Logger log = LoggerFactory.getLogger(ProvidersCountryServiceImpl.class);

    @Autowired
    private ProvidersCountryRepository providersCountryRepository;

    @Autowired
    private ProvidersRepository providersRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProvidersCountryResponseRest> buscarProvidersCountry() {

        ProvidersCountryResponseRest response = new ProvidersCountryResponseRest();

        try {
            List<ProvidersCountry> providers = providersCountryRepository.findAll();
            response.getProvidersCountryResponse().setProvidersCountries(providers);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("error al consultar providers: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<ProvidersCountryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<ProvidersCountryResponseRest>(response, HttpStatus.OK); //devuelve 200
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProvidersCountryResponseRest> buscarSortProvidersCountry(String field) {

        ProvidersCountryResponseRest response = new ProvidersCountryResponseRest();

        try {
            log.info("field: " + field);
            List<ProvidersCountry> providers = providersCountryRepository.findAll(Sort.by(Sort.Direction.ASC,field));
            response.getProvidersCountryResponse().setProvidersCountries(providers);

            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("error al consultar providers: ", e.getMessage());
            e.getStackTrace();
            throw e;

        }
        return new ResponseEntity<ProvidersCountryResponseRest>(response, HttpStatus.OK); //devuelve 200
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProvidersCountryResponseRest> paginationProvidersCountry(int offset, int pageSize) {

        ProvidersCountryResponseRest response = new ProvidersCountryResponseRest();

        try {

            List<ProvidersCountry> providers = providersCountryRepository.findAll(PageRequest.of(offset, pageSize)).getContent();
            response.getProvidersCountryResponse().setProvidersCountries(providers);

            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("error al consultar providers: ", e.getMessage());
            e.getStackTrace();
            throw e;

        }
        return new ResponseEntity<ProvidersCountryResponseRest>(response, HttpStatus.OK); //devuelve 200
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProvidersCountryResponseRest> paginationAndSortingProvidersCountry(int offset, int pageSize, String field) {

        ProvidersCountryResponseRest response = new ProvidersCountryResponseRest();

        try {

            List<ProvidersCountry> providers = providersCountryRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field))).getContent();
            response.getProvidersCountryResponse().setProvidersCountries(providers);

            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("error al consultar providers: ", e.getMessage());
            e.getStackTrace();
            throw e;

        }
        return new ResponseEntity<ProvidersCountryResponseRest>(response, HttpStatus.OK); //devuelve 200
    }





    @Override
    @Transactional
    public ResponseEntity<ProvidersCountryResponseRest> crearProvidersCountry(ProvidersCountry providersCountry) {
        ProvidersCountryResponseRest response = new ProvidersCountryResponseRest();
        List<ProvidersCountry> list = new ArrayList<>();

        try {
            // Obtén el nombre del proveedor y el código del país desde el objeto ProvidersCountry
            String nombreProvider = providersCountry.getProvider().getName();
            String codigoCountry = providersCountry.getCountry().getCode();

            // Busca el proveedor por nombre
            Providers provider = providersRepository.findByName(nombreProvider);

            // Busca el país por código
            Country country = countryRepository.findByCodes(codigoCountry);

            // Verifica si el proveedor y el país existen
            if (provider != null && country != null) {
                // Asigna los proveedores y el país al objeto ProvidersCountry
                providersCountry.setProvider(provider);
                providersCountry.setCountry(country);

                // Guarda la relación ProvidersCountry en la base de datos
                ProvidersCountry providerGuardado = providersCountryRepository.save(providersCountry);
                list.add(providerGuardado);
                response.getProvidersCountryResponse().setProvidersCountries(list);



                response.setMetadata("Respuesta ok", "200", "Relación creada exitosamente");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMetadata("Respuesta nok", "-1", "Proveedor o país no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Respuesta nok", "-1", "Error al crear la relación ProvidersCountry");
            log.error("Error al crear la relación ProvidersCountry: ", e);
            e.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ProvidersCountryResponseRest> buscarProvidersCountryPorCode(String countryCode) {

        ProvidersCountryResponseRest response = new ProvidersCountryResponseRest();

        try {
            List<ProvidersCountry> providers;

            if (countryCode != null && !countryCode.isEmpty()) {
                // Si se proporciona el countryCode, realiza una búsqueda filtrada
                providers = providersCountryRepository.findByCountryCode(countryCode);
            } else {
                // Si no se proporciona el countryCode, obtén todos los proveedores
                providers = providersCountryRepository.findAll();
            }

            response.getProvidersCountryResponse().setProvidersCountries(providers);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("Error al consultar providers: ", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK); // devuelve 200
    }

}
