package projects.countriesapi.response;

public class ProvidersResponseRest extends ResponseRest {
    private ProvidersResponse providersResponse = new ProvidersResponse();

    public ProvidersResponse getProvidersResponse() {
        return providersResponse;
    }

    public void setProvidersResponse(ProvidersResponse providersResponse) {
        this.providersResponse = providersResponse;
    }
}
