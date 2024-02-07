package projects.countriesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.countriesapi.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
