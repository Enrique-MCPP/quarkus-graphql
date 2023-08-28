package com.quark.mapper;


import com.quark.dto.ChatDto;
import com.quark.model.Chat;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;


@Mapper(componentModel = "jakarta")
@ApplicationScoped
public abstract class ChatMapper extends MapperGeneric<Chat, ChatDto> {


}










