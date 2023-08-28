package com.quark.dto;


import com.quark.dto.interfaces.IDto;
import lombok.*;


import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto extends EntidadInfoDto implements IDto {
    private Long id;
    private ChatDto chat;
    private UserDto user;
    private boolean messageRead;
    private LocalDateTime messageDate;
    private String messageContent;
}



