package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;

import java.util.List;

public interface RoleService extends CrudService<RoleDTO,Long> {

    RoleDTO myLogic (RoleDTO roleDTO, String name);    // if we need specific method for this class

//   RoleDTO save (RoleDTO role);
//
//   RoleDTO findById (Long id);
//
//   List<RoleDTO> findAll();
//
//   void delete (RoleDTO role);
//
//   void delete (Long id);
}
