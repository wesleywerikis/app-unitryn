package br.com.unitryn.app_unitryn.mapper;

import org.springframework.stereotype.Component;

import br.com.unitryn.app_unitryn.dto.UserDto;
import br.com.unitryn.app_unitryn.entity.User;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
