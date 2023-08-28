package com.quark.validations;


import com.quark.model.User;
import com.quark.repository.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ValidaUser extends AbstractValidator<User, ValidaUser> {

    @Inject
    private UserRepository userRepository;


}
