package com.quark.dto;


import com.quark.dto.interfaces.IDto;
import com.quark.model.Chat;
import com.quark.model.Pet;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto extends EntidadInfoDto implements IDto {

    private Long id;


    private String cognitoUserId;


    private List<Pet> pets;


    private List<Chat> chats;




}


