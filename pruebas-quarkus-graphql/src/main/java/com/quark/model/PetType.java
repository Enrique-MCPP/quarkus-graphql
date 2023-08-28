package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "pet_types")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetType extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    @Column(name = "name_es", nullable = false)
    private String nameEs;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    @Column(name = "name_ca", nullable = false)
    private String nameCa;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    @Column(name = "name_ga", nullable = false)
    private String nameGa;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    @Column(name = "name_eu", nullable = false)
    private String nameEu;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre puede tener hasta 50 caracteres.")
    @Column(name = "name_en", nullable = false)
    private String nameEn;
}


