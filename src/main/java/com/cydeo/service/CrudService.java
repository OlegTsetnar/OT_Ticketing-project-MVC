package com.cydeo.service;

import java.util.List;

/**
 * We use GENERIC class to avoid writing many interfaces classes with same methods. ex: RoleService class & UserService class
 * for that we input param of out objects which we used in our methods.
 * And just need to extend this class
 * */

public interface CrudService<T,ID> {


    T save (T object);

    List<T> findAll();

    T findById (ID id);

    void delete (T object);

    void deleteById (ID id);
}
