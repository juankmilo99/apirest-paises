package projects.countriesapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import projects.countriesapi.filter.JwtReqFilter;
import projects.countriesapi.services.RolesService;

import javax.sql.DataSource;

@Configuration
public class ConfigSecurity {
    @Autowired
    @Lazy
    private JwtReqFilter jwtReqFilter;


    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource) {
        return new JdbcUserDetailsManager(datasource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure -> {
            configure
                    .requestMatchers(HttpMethod.GET, "/countries").hasRole("Admin")
                    .requestMatchers(HttpMethod.GET, "/countries/**").hasRole("Admin")
                    .requestMatchers(HttpMethod.POST, "/countries").hasRole("Admin")
                    .requestMatchers(HttpMethod.PUT, "/countries").hasRole("Admin")
                    .requestMatchers(HttpMethod.DELETE, "/countries").hasRole("Admin")
                    .requestMatchers(HttpMethod.GET, "/providers").hasRole("Admin")
                    .requestMatchers(HttpMethod.GET, "/providers/**").hasRole("Admin")
                    .requestMatchers(HttpMethod.POST, "/providers").hasRole("Admin")
                    .requestMatchers(HttpMethod.PUT, "/providers").hasRole("Admin")
                    .requestMatchers(HttpMethod.DELETE, "/providers").hasRole("Admin")
                    .requestMatchers(HttpMethod.GET, "/providers-country").hasRole("Admin")
                    .requestMatchers(HttpMethod.GET, "/providers-country/**").hasRole("Admin")
                    .requestMatchers(HttpMethod.POST, "/providers-country").hasRole("Admin")
                    .requestMatchers(HttpMethod.PUT, "/providers-country").hasRole("Admin")
                    .requestMatchers(HttpMethod.DELETE, "/providers-country").hasRole("Admin")
                    .requestMatchers(HttpMethod.GET, "/risks").hasRole("Admin")
                    .requestMatchers(HttpMethod.GET, "/risks/**").hasRole("Admin")
                    .requestMatchers(HttpMethod.POST, "/risks").hasRole("Admin")
                    .requestMatchers(HttpMethod.PUT, "/risks").hasRole("Admin")
                    .requestMatchers(HttpMethod.DELETE, "/risks").hasRole("Admin")
                    .requestMatchers("/authenticate","/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();
        })
                .addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement( (session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
