package projects.countriesapi.response;

import projects.countriesapi.entities.Risk;

import java.util.List;

public class RiskResponse {

    private List<Risk> risks;

    public List<Risk> getRisks() {
        return risks;
    }

    public void setRisks(List<Risk> risks) {
        this.risks = risks;
    }
}
