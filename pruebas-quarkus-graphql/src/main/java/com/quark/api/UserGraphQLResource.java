package com.quark.api;

import com.quark.dto.UserDto;
import com.quark.mapper.UserMapper;
import com.quark.model.User;
import com.quark.service.UserServiceImpl;
import com.quark.validations.ValidaUser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.graphql.GraphQLApi;

@GraphQLApi
@Slf4j
@Setter
@Getter
@ApplicationScoped
public class UserGraphQLResource {

    @Inject
    private UserServiceImpl userServiceImpl;

    @Inject
    private ValidaUser validaUser;

    @Inject
    private UserMapper userMapper;



}

