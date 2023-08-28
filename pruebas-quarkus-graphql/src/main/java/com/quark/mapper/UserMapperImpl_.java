package com.quark.mapper;

import com.quark.dto.UserDto;
import com.quark.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface UserMapperImpl_ {
    UserDto toDto(User entity);
    User toEntity(UserDto dto);
    List<UserDto> toDtoList(List<User> entities);
    List<User> toEntityList(List<UserDto> dtos);
}

