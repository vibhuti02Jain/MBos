package com.userInfo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.userInfo.dto.UserDto;

public interface UserService {

	 UserDto saveUser(UserDto userDto);
	    UserDto updateUser(Long id, UserDto userDto);
	    UserDto getUser(Long id);
	    Page<UserDto> getUsers(Pageable pageable);
}
