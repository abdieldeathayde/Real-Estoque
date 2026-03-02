package com.estoque.realcar.mapper;

import com.estoque.realcar.dto.UserDTO;
import com.estoque.realcar.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-02T09:33:11-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        String username = null;
        String password = null;
        String role = null;

        UserDTO userDTO = new UserDTO( username, password, role );

        return userDTO;
    }
}
