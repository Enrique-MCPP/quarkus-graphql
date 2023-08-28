package com.quark.mapper;


import com.quark.dto.UserDto;

import com.quark.model.User;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.ws.rs.Produces;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@ApplicationScoped
@Produces
public class UserMapper {

    private final UserMapperImpl_ mapper = Mappers.getMapper(UserMapperImpl_.class);

    public UserDto toDto(User entity) {
        return mapper.toDto(entity);
    }

    public User toEntity(UserDto dto) {
        return mapper.toEntity(dto);
    }

    public List<UserDto> toDtoList(List<User> entities) {
        return mapper.toDtoList(entities);
    }

    public List<User> toEntityList(List<UserDto> dtos) {
        return mapper.toEntityList(dtos);
    }
}








