package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El ID del propietario de la mascota no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "pet_owner_id", nullable = false)
    private User petOwner;

    @NotNull(message = "El ID del cuidador de mascotas no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "pet_sitter_id", nullable = false)
    private User petSitter;

    @Min(value = 1, message = "Las estrellas deben ser un número entre 1 y 5.")
    @Max(value = 5, message = "Las estrellas deben ser un número entre 1 y 5.")
    @Column(name = "stars")
    private Integer stars;

    @NotBlank(message = "El comentario no puede estar vacío.")
    @Size(max = 256, message = "El comentario no puede superar los 256 caracteres.")
    @Column(name = "comment")
    private String comment;
}
