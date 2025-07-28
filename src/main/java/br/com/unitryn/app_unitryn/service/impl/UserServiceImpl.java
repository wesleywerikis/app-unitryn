package br.com.unitryn.app_unitryn.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.unitryn.app_unitryn.dto.UserDto;
import br.com.unitryn.app_unitryn.entity.User;
import br.com.unitryn.app_unitryn.mapper.UserMapper;
import br.com.unitryn.app_unitryn.repository.UserRepository;
import br.com.unitryn.app_unitryn.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public UserDto save(User user) {
        return mapper.toDto(repository.save(user));
    }

    @Override
    public Optional<UserDto> update(Long id, User updateUser) {
        return repository.findById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            return mapper.toDto(repository.save(user));
        });
    }

    @Override
    public boolean delete(Long id) {
        return repository.findById(id).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
    }
}
