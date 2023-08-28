package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "service_types")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceType extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El tipo de servicio no puede estar vacío.")
    @Size(max = 50, message = "El tipo de servicio no puede superar los 50 caracteres.")
    @Column(name = "type")
    private String type;
}
