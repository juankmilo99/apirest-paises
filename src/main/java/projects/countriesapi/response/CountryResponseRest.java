package projects.countriesapi.response;

public class CountryResponseRest extends ResponseRest {
    private CountryResponse countryResponse = new CountryResponse();

    public CountryResponse getCountryResponse() {
        return countryResponse;
    }
    public void setCountryResponse(CountryResponse countryResponse) {
        this.countryResponse = countryResponse;
    }
}
