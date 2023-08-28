/*package com.quark.service;


import com.quark.dto.ChatMessageDto;
import com.quark.dto.MessageDto;
import com.quark.exceptions.ErrorCode;
import com.quark.exceptions.GenericException;
import com.quark.mapper.MessageMapper;
import com.quark.model.Chat;
import com.quark.model.Message;
import com.quark.model.User;
import com.quark.repository.ChatRepository;
import com.quark.repository.MessageRepository;
import com.quark.repository.UserRepository;
import com.quark.service.interfaces.IMessageService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@ApplicationScoped
public class MessageServiceImpl extends BaseServiceImpl<Message, Long> implements IMessageService {

    @Inject
    private ChatRepository chatRepository;

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private MessageMapper messageMapper;

    @Inject
    private UserRepository userRepository;

    public List<MessageDto> getChatMessages(Long chatId) {
        Optional<Chat> chatOptional = chatRepository.findByIdWithMessages(chatId);

        if (chatOptional.isEmpty()) {
            return new ArrayList<>();
        }

        Chat chat = chatOptional.get();
        return messageMapper.toDtoList(chat.getMessages());
    }

    public void deleteChatMessage(Long chatId, Long messageId) {
        Optional<Chat> chatOptional = chatRepository.findByIdWithMessages(chatId);

        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();
            List<Message> messages = chat.getMessages();
            boolean messageRemoved = messages.removeIf(message -> message.getId().equals(messageId));

            if (messageRemoved) {
                chatRepository.persistAndFlush(chat);
            } else {
                throw new GenericException(ErrorCode.NOT_FOUND_ERROR, "Mensaje no encontrado.");
            }
        } else {
            throw new GenericException(ErrorCode.NOT_FOUND_ERROR, "Chat no encontrado.");
        }
    }

    public void markMessageAsRead(Long messageId) {
        Optional<Message> messageOptional = messageRepository.findByIdOptional(messageId);

        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setMessageRead(true);
            messageRepository.persistAndFlush(message);
        } else {
            throw new GenericException(ErrorCode.NOT_FOUND_ERROR, "Mensaje no encontrado.");
        }
    }

    public ChatMessageDto saveMessage(ChatMessageDto chatMessageDto) {
        // Encuentra el chat y el usuario asociado en la base de datos
        Chat chat = chatRepository.findByIdOptional(chatMessageDto.getChatId())
                .orElseThrow(() -> new GenericException(ErrorCode.NOT_FOUND_ERROR, "Chat not found"));
        User user = userRepository.findByIdOptional(chatMessageDto.getUserId())
                .orElseThrow(() -> new GenericException(ErrorCode.NOT_FOUND_ERROR, "User not found"));

        // Crea una nueva entidad Message y guarda en la base de datos
        MessageDto messageDto = messageMapper.chatMessageDtoToMessageDto(chatMessageDto);
        Message message = messageMapper.toEntity(messageDto);
        message.setChat(chat);
        message.setUser(user);

        // Guarda el mensaje en la base de datos
        messageRepository.persistAndFlush(message);

        // Nota: Asumiendo que el objeto "message" después de "persistAndFlush" ya tiene su ID asignado.
        return messageMapper.toChatMessageDto(message);
    }
}

*/


