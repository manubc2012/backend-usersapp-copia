package com.manuela.backendusersapp.Service;

import com.manuela.backendusersapp.models.Request.UserRequest;
import com.manuela.backendusersapp.models.dto.UsersDto;
import com.manuela.backendusersapp.models.entities.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UsersDto> findAll();

    Optional<UsersDto> findById(Long id);

    UsersDto save(User user);
    Optional<UsersDto> update(UserRequest user, Long id);

    void remove(Long id);
}
