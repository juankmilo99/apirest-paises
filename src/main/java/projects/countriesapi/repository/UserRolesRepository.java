package projects.countriesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projects.countriesapi.entities.UserRoles;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long>{
    @Query("SELECT ur FROM UserRoles ur WHERE ur.user.id = :userId")
    List<UserRoles> findByUserId(@Param("userId") Long userId);

    @Query("SELECT ur FROM UserRoles ur WHERE ur.role.id = :roleId")
    List<UserRoles> findByRoleId(@Param("roleId") Long roleId);



}
