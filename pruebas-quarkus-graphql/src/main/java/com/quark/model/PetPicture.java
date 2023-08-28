package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "pet_pictures")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetPicture extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El ID del usuario no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "La URL de la imagen no puede estar vacía.")
    @Size(max = 256, message = "La URL de la imagen no puede superar los 256 caracteres.")
    @Column(name = "picture_url")
    private String pictureUrl;
}
