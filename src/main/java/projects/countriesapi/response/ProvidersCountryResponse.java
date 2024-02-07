package projects.countriesapi.response;

import projects.countriesapi.entities.ProvidersCountry;

import java.util.List;

public class ProvidersCountryResponse {

   private List<ProvidersCountry> providersCountries;

    public List<ProvidersCountry> getProvidersCountries() {
         return providersCountries;
    }

    public void setProvidersCountries(List<ProvidersCountry> providersCountries) {
         this.providersCountries = providersCountries;
    }
}
