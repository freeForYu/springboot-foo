package com.gein.service;

import com.gein.bean.User;

/**
 * Created by GY on 2017/2/21.
 */
public interface UserService {

    User findByName(String name);

}
