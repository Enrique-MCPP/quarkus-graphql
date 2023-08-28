package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "user_videos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVideo extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El ID del usuario no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "La URL del vídeo no puede estar vacía.")
    @Size(max = 256, message = "La URL del vídeo no puede superar los 256 caracteres.")
    @Column(name = "video_url")
    private String videoUrl;
}
