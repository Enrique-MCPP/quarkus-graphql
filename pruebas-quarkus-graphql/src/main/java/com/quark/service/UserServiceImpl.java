package com.quark.service;


import com.quark.model.User;
import com.quark.service.interfaces.IUserService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApplicationScoped
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements IUserService {


}




