package projects.countriesapi.response;

public class RiskResponseRest extends ResponseRest {
    private RiskResponse riskResponse = new RiskResponse();

    public RiskResponse getRiskResponse() {
        return riskResponse;
    }

    public void setRiskResponse(RiskResponse riskResponse) {
        this.riskResponse = riskResponse;
    }
}
