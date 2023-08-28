package com.quark.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
public abstract class EntidadInfoDto {


    @NotNull

    protected LocalDateTime creationDate;

    @NotNull
    protected LocalDateTime modifiedDate;


}
