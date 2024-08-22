package com.userInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.userInfo.dto.UserDto;
import com.userInfo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        logger.info("Request to save user: {}", userDto);
        UserDto result = userService.saveUser(userDto);
        logger.info("Response from save user: {}", result);
        return result;
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        logger.info("Request to update user with id {}: {}", id, userDto);
        UserDto result = userService.updateUser(id, userDto);
        logger.info("Response from update user: {}", result);
        return result;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        logger.info("Request to get user with id {}", id);
        UserDto result = userService.getUser(id);
        logger.info("Response from get user: {}", result);
        return result;
    }

    @GetMapping
    public Page<UserDto> getUsers(Pageable pageable) {
        logger.info("Request to get users with pageable {}", pageable);
        Page<UserDto> result = userService.getUsers(pageable);
        logger.info("Response from get users: {}", result);
        return result;
    }
}
