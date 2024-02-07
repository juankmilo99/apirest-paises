package projects.countriesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projects.countriesapi.entities.Risk;

import java.util.List;

public interface RiskRepository extends JpaRepository<Risk, Integer>{
    @Query(value = "SELECT * FROM risk WHERE name LIKE %:name%", nativeQuery = true)
    Risk findByName(@Param("name") String name);
}
