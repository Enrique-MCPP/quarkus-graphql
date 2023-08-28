package com.quark.repository;


import com.quark.model.User;

import jakarta.enterprise.context.ApplicationScoped;


import java.util.Optional;

@ApplicationScoped
public class UserRepository implements BaseRepository<User, Long> {

    public Optional<User> findByIdWithPets(Long userId) {
        User user = find("SELECT u FROM User u JOIN FETCH u.pets WHERE u.id = ?1", userId).firstResult();
        return Optional.ofNullable(user);
    }

    public Optional<User> findByIdWithChats(Long userId) {
        User user = find("SELECT u FROM User u JOIN FETCH u.chats WHERE u.id = ?1", userId).firstResult();
        return Optional.ofNullable(user);
    }

}

