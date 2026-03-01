package com.estoque.realcar.mapper;

import com.estoque.realcar.dto.UserDTO;
import com.estoque.realcar.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-15T19:34:01-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToDTO(User usuario) {
        if ( usuario == null ) {
            return null;
        }

        String username = null;
        String password = null;
        String role = null;

        UserDTO userDTO = new UserDTO( username, password, role );

        return userDTO;
    }

    @Override
    public User userToEntity(UserDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        User user = new User();

        return user;
    }
}
