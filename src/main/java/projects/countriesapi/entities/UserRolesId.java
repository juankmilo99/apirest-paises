package projects.countriesapi.entities;

import java.io.Serializable;

public class UserRolesId implements Serializable {

    private Long userId;
    private Long roleId;



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
