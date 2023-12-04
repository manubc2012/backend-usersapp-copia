package com.manuela.backendusersapp.Service;

import com.manuela.backendusersapp.models.Request.UserRequest;
import com.manuela.backendusersapp.models.dto.UsersDto;
import com.manuela.backendusersapp.models.dto.mapper.DtoUserMapper;
import com.manuela.backendusersapp.models.entities.User;
import com.manuela.backendusersapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional(readOnly = true)
    public List<UsersDto> findAll() {
        List<User> users = (List<User>) repository.findAll();
        return users.stream().map(u -> DtoUserMapper
                .builder().setUser(u).build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsersDto> findById(Long id) {
        return repository.findById(id).map(u -> DtoUserMapper
                .builder()
                .setUser(u)
                .build());

    }

    @Override
    @Transactional
    public UsersDto save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return DtoUserMapper.builder().setUser(repository.save(user)).build();
    }

    @Override
    @Transactional
    public Optional<UsersDto> update(UserRequest user, Long id) {
        Optional<User> o = repository.findById(id);
        User userOptional = null;
        if (o.isPresent()) {
            User userDb = o.orElseThrow();
            userDb.setUsername(user.getUsername());
            userDb.setEmail(user.getEmail());
            userOptional = repository.save(userDb);
        }
        return Optional.ofNullable(DtoUserMapper.builder().setUser(userOptional).build());
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }


}
