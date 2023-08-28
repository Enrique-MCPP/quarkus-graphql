package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "services")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El ID del usuario no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @NotNull(message = "El ID del tipo de servicio no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_service_type", nullable = false)
    private ServiceType serviceType;

    @PositiveOrZero(message = "El precio debe ser un número positivo.")
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "isActive")
    private Boolean isActive;
}
