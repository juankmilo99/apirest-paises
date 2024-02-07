package projects.countriesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projects.countriesapi.entities.Country;
import projects.countriesapi.entities.Providers;

import java.util.List;

public interface ProvidersRepository extends JpaRepository<Providers, Long> {

        @Query(value = "SELECT * FROM providers WHERE name LIKE %:name%", nativeQuery = true)
        Providers findByName(@Param("name") String name);

        @Query(value = "SELECT * FROM providers WHERE code LIKE %:code%", nativeQuery = true)
        List<Providers> findByCode(@Param("code") String code);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        List<Providers> findByCountryId(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        Providers findByCountryIds(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        List<Providers> findByCountryIdsList(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        Providers findByCountryIdss(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        List<Providers> findByCountryIdsss(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        Providers findByCountryIdssss(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        List<Providers> findByCountryIdsssss(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        Providers findByCountryIdssssss(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        List<Providers> findByCountryIdsssssss(@Param("country_id") String country_id);

        @Query(value = "SELECT * FROM providers WHERE country_id LIKE %:country_id%", nativeQuery = true)
        Providers findByCountryIdssssssss(@Param("country_id") String country_id);


}
