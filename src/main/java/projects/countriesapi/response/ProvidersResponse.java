package projects.countriesapi.response;
import projects.countriesapi.entities.Country;
import projects.countriesapi.entities.Providers;

import java.util.List;
public class ProvidersResponse {

    private List<Providers> providers;

    public List<Providers> getProviders() {
        return providers;
    }

    public void setProviders(List<Providers> provider) {
        this.providers = provider;
    }
}
