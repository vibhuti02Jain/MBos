package com.userInfo.service;
import com.userInfo.entity.*;
import com.userInfo.dto.*;
import com.userInfo.repository.*;
import com.userInfo.rest.ThirdPartyService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThirdPartyService thirdPartyService;

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user = userRepository.save(user);
        String thirdPartyResponse = thirdPartyService.callThirdPartyApi();
        log.info("thirdPartyResponse : {}", thirdPartyResponse);
        return new UserDto(user.getId(), user.getName(), user.getEmail());

    }

    @Override
    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user = userRepository.save(user);
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserDto> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()));
    }


}