package com.manuela.backendusersapp.Service;

import com.manuela.backendusersapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
public class JpaUsersDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.manuela.backendusersapp.models.entities.User
                > o = repository.getUserByUsername(username) ;

        if (!o.isPresent()){
            throw new UsernameNotFoundException(String.format("El username %S no existe",username ));
        }
        com.manuela.backendusersapp.models.entities.User user= o.orElseThrow();

        /*
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));*/

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                Collections.emptyList());  // No asignamos roles/authorities

    }
}
