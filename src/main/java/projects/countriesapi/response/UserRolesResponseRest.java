package projects.countriesapi.response;

public class UserRolesResponseRest extends ResponseRest {
    private UserRolesResponse userRolesResponse = new UserRolesResponse();

    public UserRolesResponse getUserRolesResponse() {
        return userRolesResponse;
    }

    public void setUserRolesResponse(UserRolesResponse userRolesResponse) {
        this.userRolesResponse = userRolesResponse;
    }
}
