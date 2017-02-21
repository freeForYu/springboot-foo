package com.gein.dao;

import com.gein.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by GY on 2017/2/21.
 */
public interface UserDao {

    User findByName(@Param("name") String name);

}
