package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "booking_status")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingStatus extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El nombre del estado de la reserva no puede estar vacío.")
    @Size(max = 20, message = "El nombre del estado de la reserva no puede superar los 20 caracteres.")
    @Column(name = "status_name")
    private String statusName;
}
