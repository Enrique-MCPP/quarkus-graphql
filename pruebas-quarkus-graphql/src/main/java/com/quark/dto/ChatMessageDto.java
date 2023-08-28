package com.quark.dto;

import com.quark.dto.interfaces.IDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageDto extends EntidadInfoDto implements IDto {
    private Long chatId;
    private Long userId;
    private boolean messageRead;
    private LocalDateTime messageDate;
    private String messageContent;
}

