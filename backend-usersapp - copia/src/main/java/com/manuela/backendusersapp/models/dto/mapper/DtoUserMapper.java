package com.manuela.backendusersapp.models.dto.mapper;

import com.manuela.backendusersapp.models.dto.UsersDto;
import com.manuela.backendusersapp.models.entities.User;

public class DtoUserMapper {

    private User user;

    private DtoUserMapper() {

    }

    public static  DtoUserMapper builder(){
        return new DtoUserMapper();
    }

    public DtoUserMapper setUser(User user) {
        this.user = user;
        return this;
    }

    public UsersDto build(){
        if (user== null){
           throw new RuntimeException("Debe pasar el entity user");
        }
       return new  UsersDto (this.user.getId(), user.getUsername(), user.getEmail());

    }
}
