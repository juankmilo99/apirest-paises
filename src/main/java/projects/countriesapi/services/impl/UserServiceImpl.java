package projects.countriesapi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.countriesapi.entities.Users;
import projects.countriesapi.repository.UsersRepository;
import projects.countriesapi.response.UserResponseRest;
import projects.countriesapi.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(RolesServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<UserResponseRest> buscarUsers() {

        UserResponseRest response = new UserResponseRest();

        try {
            List<Users> users = usersRepository.findAll();
            response.getUserResponse().setUsers(users);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
        } catch (Exception e) {

            response.setMetadata("Respuesta nok", "-1", "Error al consultar providers");
            log.error("error al consultar providers: ", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity<UserResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<UserResponseRest>(response, HttpStatus.OK); //devuelve 200
    }
}
