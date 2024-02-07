package projects.countriesapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projects.countriesapi.entities.Country;


import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

        @Query(value = "SELECT * FROM countries WHERE name LIKE %:name%", nativeQuery = true)
        List<Country> findByName(@Param("name") String name);

        @Query(value = "SELECT * FROM countries WHERE code LIKE %:code%", nativeQuery = true)
        List<Country> findByCode(@Param("code") String code);

    @Query(value = "SELECT * FROM countries WHERE code LIKE %:code% LIMIT 1" , nativeQuery = true)
    Country findByCodes(@Param("code") String code);

        @Query(value = "SELECT * FROM countries WHERE continent LIKE %:continent%", nativeQuery = true)
        List<Country> findByContinent(@Param("continent") String continent);

        @Query(value = "SELECT * FROM countries WHERE region LIKE %:region%", nativeQuery = true)
        List<Country> findByRegion(@Param("region") String region);

        @Query(value = "SELECT * FROM countries WHERE capital LIKE %:capital%", nativeQuery = true)
        List<Country> findByCapital(@Param("capital") String capital);

        @Query(value = "SELECT * FROM countries WHERE population LIKE %:population%", nativeQuery = true)
        List<Country> findByPopulation(@Param("population") String population);

        @Query(value = "SELECT * FROM countries WHERE latitude LIKE %:latitude%", nativeQuery = true)
        List<Country> findByLatitude(@Param("latitude") String latitude);

        @Query(value = "SELECT * FROM countries WHERE longitude LIKE %:longitude%", nativeQuery = true)
        List<Country> findByLongitude(@Param("longitude") String longitude);

        @Query(value = "SELECT * FROM countries WHERE area LIKE %:area%", nativeQuery = true)
        List<Country> findByArea(@Param("area") String area);

        @Query(value = "SELECT * FROM countries WHERE gini LIKE %:gini%", nativeQuery = true)
        List<Country> findByGini(@Param("gini") String gini);

        @Query(value = "SELECT * FROM countries WHERE demonym LIKE %:demonym%", nativeQuery = true)
        List<Country> findByDemonym(@Param("demonym") String demonym);

        @Query(value = "SELECT * FROM countries WHERE flag LIKE %:flag%", nativeQuery = true)
        List<Country> findByFlag(@Param("flag") String flag);

        @Query(value = "SELECT * FROM countries WHERE native_name LIKE %:native_name%", nativeQuery = true)
        List<Country> findByNativeName(@Param("native_name") String native_name);
}
