package com.quark.dto;


import com.quark.dto.interfaces.IDto;
import lombok.*;
import org.eclipse.microprofile.graphql.Description;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatDto extends EntidadInfoDto implements IDto {

    private Long id;

    private UserDto petOwner;

    private UserDto sitter;

    private List<MessageDto> messages;

    @Description("Last message of the chat")
    private MessageDto lastMessage;

}




