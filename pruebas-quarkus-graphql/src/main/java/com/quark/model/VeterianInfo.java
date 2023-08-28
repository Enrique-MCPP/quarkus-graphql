package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "veterian_info")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterianInfo extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El ID de la mascota no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @NotBlank(message = "El nombre del veterinario no puede estar vacío.")
    @Size(max = 256, message = "El nombre del veterinario no puede superar los 256 caracteres.")
    @Column(name = "veterinarian_name")
    private String veterinarianName;

    @NotBlank(message = "La dirección del veterinario no puede estar vacía.")
    @Size(max = 256, message = "La dirección del veterinario no puede superar los 256 caracteres.")
    @Column(name = "veterinarian_address")
    private String veterinarianAddress;

    @Pattern(regexp = "^[0-9]{9}$", message = "El número de teléfono del veterinario debe ser un número de 9 dígitos.")
    @Column(name = "veterinarian_phone")
    private String veterinarianPhone;
}
