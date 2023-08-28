package com.quark.repository;


import com.quark.model.Chat;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class ChatRepository implements BaseRepository<Chat, Long> {

    @Inject
    private EntityManager em;

    public Optional<Chat> findByIdWithMessages(Long chatId) {
        return find("SELECT c FROM Chat c JOIN FETCH c.messages WHERE c.id = ?1", chatId).firstResultOptional();
    }

    public Optional<Chat> findByIdWithUsers(Long chatId) {
        return find("SELECT c FROM Chat c JOIN FETCH c.petOwner JOIN FETCH c.sitter WHERE c.id = ?1", chatId).firstResultOptional();
    }

    public List<Chat> findByPetOwner_id(Long userId) {
        return list("SELECT c FROM Chat c JOIN FETCH c.messages JOIN FETCH c.petOwner JOIN FETCH c.sitter WHERE c.petOwner.id = ?1", userId);
    }

    public List<Object[]> findChatsWithLastMessage(Long userId) {
        String queryStr = "SELECT c, m FROM Chat c JOIN Message m ON m.chat.id = c.id WHERE c.petOwner.id = :userId AND m.id = (SELECT MAX(m2.id) FROM Message m2 WHERE m2.chat.id = c.id)";
        return em.createQuery(queryStr, Object[].class)
                .setParameter("userId", userId)
                .getResultList();
    }


}







