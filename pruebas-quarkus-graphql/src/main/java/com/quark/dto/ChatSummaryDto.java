package ea.ciges.krakend.dto;


import com.quark.dto.EntidadInfoDto;
import com.quark.dto.UserDto;
import com.quark.dto.interfaces.IDto;
import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatSummaryDto extends EntidadInfoDto implements IDto {
    private Long id;
    private UserDto petOwner;
    private UserDto sitter;
    private LocalDateTime lastMessageDate;
}





