package com.gein.controller;

import com.gein.bean.User;
import com.gein.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by GY on 2017/2/21.
 */
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user/{name}", method = RequestMethod.GET)
    public User findByName(@PathVariable(value = "name") String name) {
        return userService.findByName(name);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUser() {
        try {
            List<User> list = userService.findAllUser();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            if (logger.isInfoEnabled())
                logger.info("查询失败", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            if (logger.isInfoEnabled())
                logger.info("保存失败", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            if (logger.isInfoEnabled())
                logger.info("更新失败", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            if (logger.isInfoEnabled())
                logger.info("删除失败", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
