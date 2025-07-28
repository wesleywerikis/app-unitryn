package br.com.unitryn.app_unitryn.service;

import java.util.List;
import java.util.Optional;

import br.com.unitryn.app_unitryn.dto.UserDto;
import br.com.unitryn.app_unitryn.entity.User;

public interface UserService {

    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    UserDto save(User user);

    Optional<UserDto> update(Long id, User user);

    boolean delete(Long id);

}