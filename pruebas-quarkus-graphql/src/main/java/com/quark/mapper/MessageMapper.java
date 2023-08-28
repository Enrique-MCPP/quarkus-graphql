package com.quark.mapper;


import com.quark.dto.ChatMessageDto;
import com.quark.dto.MessageDto;

import com.quark.model.Message;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.*;


@Mapper(componentModel = "jakarta")
@ApplicationScoped
public abstract class MessageMapper extends MapperGeneric<Message, MessageDto> {




}





