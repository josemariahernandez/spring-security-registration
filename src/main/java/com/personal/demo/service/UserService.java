package com.personal.demo.service;

import com.personal.demo.domain.dto.UserDto;
import com.personal.demo.domain.model.User;
import com.personal.demo.exception.EmailExistsException;

/**
 * Created by Chema on 18/05/2017.
 */
public interface UserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

}
