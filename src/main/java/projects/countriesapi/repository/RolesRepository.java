package projects.countriesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.countriesapi.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
