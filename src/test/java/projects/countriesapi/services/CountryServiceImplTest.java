package projects.countriesapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import projects.countriesapi.entities.Country;
import projects.countriesapi.repository.CountryRepository;
import projects.countriesapi.response.CountryResponseRest;
import projects.countriesapi.services.impl.CountryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class CountryServiceImplTest {
    @InjectMocks
    CountryServiceImpl service;

    @Mock
    CountryRepository countryRepository;
    List<Country> list = new ArrayList<Country>();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.cargarCountries();
    }

    @Test
    public void buscarCountryTest() {

        Mockito.when(countryRepository.findAll()).thenReturn(list);

        ResponseEntity<CountryResponseRest> response = service.buscarPaises();

        Assertions.assertEquals(2, response.getBody().getCountryResponse().getCountries().size());

        Mockito.verify(countryRepository, Mockito.times(1)).findAll();


    }

    public void cargarCountries()
    {
        Country catUno = new Country(Long.valueOf(1),"DEU", "Germany", "DE");
        Country catdos = new Country(Long.valueOf(1),"FRA", "France", "FR");


        list.add(catUno);
        list.add(catdos);


    }


}
