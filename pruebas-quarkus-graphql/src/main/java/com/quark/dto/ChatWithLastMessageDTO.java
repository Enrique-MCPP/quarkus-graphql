package com.quark.dto;

import com.quark.dto.interfaces.IDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatWithLastMessageDTO extends EntidadInfoDto implements IDto {
    private ChatDto chatDto;
    private MessageDto lastMessageDto;
}
