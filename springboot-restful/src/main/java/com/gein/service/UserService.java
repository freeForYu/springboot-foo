package com.gein.service;

import com.gein.bean.User;

import java.util.List;

/**
 * Created by GY on 2017/2/21.
 */
public interface UserService {

    User findByName(String name);

    List<User> findAllUser();

    Long saveUser(User user);

    Long updateUser(User user);

    Long deleteUser(Integer id);

}
