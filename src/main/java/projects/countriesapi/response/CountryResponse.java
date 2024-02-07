package projects.countriesapi.response;

import projects.countriesapi.entities.Country;
import java.util.List;

public class CountryResponse {
    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> country) {
        this.countries = country;
    }
}
