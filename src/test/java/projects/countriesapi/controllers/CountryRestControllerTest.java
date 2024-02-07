package projects.countriesapi.controllers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import projects.countriesapi.entities.Country;
import projects.countriesapi.response.CountryResponseRest;
import projects.countriesapi.services.CountryService;

public class CountryRestControllerTest {
    @InjectMocks
    Countrycontroller countryController;

    @Mock
    private CountryService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void crearTest() {


        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Country country = new Country( Long.valueOf(1),"DEU", "Germany", "DE");

        Mockito.when(service.crear(Mockito.any(Country.class))).thenReturn(new ResponseEntity<CountryResponseRest>(HttpStatus.OK));

        ResponseEntity<CountryResponseRest> respuesta = countryController.crear(country);

        Assertions.assertThat(respuesta.getStatusCodeValue()).isEqualTo(200);

    }
}
