package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "dogs_races")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DogRace extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El nombre largo no puede estar en blanco.")
    @Size(max = 256, message = "El nombre largo no puede superar los 256 caracteres.")
    @Column(name = "long_name")
    private String longName;

    @NotBlank(message = "El nombre no puede estar en blanco.")
    @Size(max = 256, message = "El nombre no puede superar los 256 caracteres.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "El nombre en inglés no puede estar en blanco.")
    @Size(max = 256, message = "El nombre en inglés no puede superar los 256 caracteres.")
    @Column(name = "name_en")
    private String nameEn;

    @NotBlank(message = "El nombre en euskera no puede estar en blanco.")
    @Size(max = 256, message = "El nombre en euskera no puede superar los 256 caracteres.")
    @Column(name = "name_eu")
    private String nameEu;

    @NotBlank(message = "El nombre en catalán no puede estar en blanco.")
    @Size(max = 256, message = "El nombre en catalán no puede superar los 256 caracteres.")
    @Column(name = "name_ca")
    private String nameCa;

    @NotBlank(message = "El nombre en gallego no puede estar en blanco.")
    @Size(max = 256, message = "El nombre en gallego no puede superar los 256 caracteres.")
    @Column(name = "name_ga")
    private String nameGa;
}
