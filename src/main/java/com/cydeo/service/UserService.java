package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends CrudService<UserDTO, String> {

//    UserDTO save(UserDTO user);
//
//    UserDTO findById(String userName);
//
//    List<UserDTO> findAll();
//
//    void delete(UserDTO user);
//
//    void deleteById(String username);

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();

}
