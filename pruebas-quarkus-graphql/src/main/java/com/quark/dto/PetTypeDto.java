package com.quark.dto;


import com.quark.dto.interfaces.IDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetTypeDto extends EntidadInfoDto implements IDto {
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    private String nameEs;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    private String nameCa;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    private String nameGa;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    private String nameEu;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    private String nameEn;
}