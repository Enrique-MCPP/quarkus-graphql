package com.quark.dto;


import com.quark.dto.interfaces.IDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDto extends EntidadInfoDto implements IDto {
    private Long id;
    // Este campo se mapea desde la entidad User
    @NotNull(message = "El usuario es requerido.")
    private UserDto user;

    @NotNull(message = "El ID del tipo de mascota no puede ser nulo.")
    private PetTypeDto petType;

    @NotBlank(message = "El nombre no puede estar en blanco.")
    @Size(max = 20, message = "El nombre no puede superar los 20 caracteres.")
    private String name;

    @Past(message = "La fecha de nacimiento debe ser en el pasado.")
    private LocalDate birthdate;

    @PositiveOrZero(message = "El peso debe ser un número positivo.")
    private BigDecimal weight;


    private Boolean isMicrochipped;


    private Boolean isSterilized;


    private Boolean isTrained;

    @Min(value = 0, message = "El nivel de compatibilidad con los niños debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El nivel de compatibilidad con los niños debe ser un número entre 0 y 5.")
    private Integer kidFriendly;

    @Min(value = 0, message = "El nivel de compatibilidad con los perros debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El nivel de compatibilidad con los perros debe ser un número entre 0 y 5.")
    private Integer dogFriendly;

    @Min(value = 0, message = "El nivel de compatibilidad con los gatos debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El nivel de compatibilidad con los gatos debe ser un número entre 0 y 5.")
    private Integer catFriendly;

    private LocalDate adoptionDate;

    @Min(value = 1, message = "El nivel de energía debe ser un número entre 1 y 5.")
    @Max(value = 5, message = "El nivel de energía debe ser un número entre 1 y 5.")
    private Integer energyLevel;

    @Min(value = 1, message = "El horario de alimentación debe ser un número entre 1 y 5.")
    @Max(value = 5, message = "El horario de alimentación debe ser un número entre 1 y 5.")
    private Integer feedingSchedule;

    @Size(max = 100, message = "Los detalles de alimentación no pueden superar los 100 caracteres.")
    @Column(name = "feeding_details")
    private String feedingDetails;

    @Size(max = 100, message = "Otros detalles no pueden superar los 100 caracteres.")
    private String otherDetails;

    @Min(value = 0, message = "El tiempo solo debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El tiempo solo debe ser un número entre 0 y 5.")
    private Integer aloneTime;

    @Min(value = 0, message = "La medicación debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "La medicación debe ser un número entre 0 y 5.")
    private Integer medication;

    @Size(max = 100, message = "Los detalles de la medicación no pueden superar los 100 caracteres.")
    private String medicationDetails;
}