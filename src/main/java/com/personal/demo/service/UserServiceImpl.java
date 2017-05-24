package com.personal.demo.service;

import com.personal.demo.domain.dto.UserDto;
import com.personal.demo.domain.model.Role;
import com.personal.demo.domain.model.User;
import com.personal.demo.domain.model.VerificationToken;
import com.personal.demo.exception.EmailExistsException;
import com.personal.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by Chema on 18/05/2017.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if(emailExist(accountDto.getEmail())){
            throw new EmailExistsException("There is an account with that email address: "
                + accountDto.getEmail());
        }

        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        Role uerRole = new Role();
        uerRole.setName("ROLE_USER");
        user.setRoles(Arrays.asList(uerRole));
        return repository.save(user);
    }

    //TODO Implementar este metodo. Solo esta puesto para que no de errores
    @Override
    public void createVerificationToken(User user, String token) {

    }

    //TODO Implementar este metodo. Solo esta puesto para que no de errores
    @Override
    public VerificationToken getVerificationToken(String token) {
        return null;
    }

    //TODO Implementar este metodo. Solo esta puesto para que no de errores
    @Override
    public void saveRegisteredUser(User user) {

    }

    private boolean emailExist(String email){
        User user = repository.findByEmail(email);
        if(user != null){
            return true;
        }
        return false;
    }
}
