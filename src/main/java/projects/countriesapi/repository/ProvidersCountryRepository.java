package projects.countriesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projects.countriesapi.entities.ProvidersCountry;

import java.util.List;

public interface ProvidersCountryRepository extends JpaRepository<ProvidersCountry, Long> {
    @Query("SELECT pc FROM ProvidersCountry pc JOIN pc.country c WHERE c.code LIKE %:countryCode%")
    List<ProvidersCountry> findByCountryCode(@Param("countryCode") String countryCode);
}

