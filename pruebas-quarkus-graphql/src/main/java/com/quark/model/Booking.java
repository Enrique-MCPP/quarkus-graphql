package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends EntidadInfo<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "El ID del servicio no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceType serviceType;

    @NotNull(message = "El ID del cuidador de mascotas no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "pet_sitter_id", nullable = false)
    private User petSitter;

    @NotNull(message = "El ID de la mascota no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @NotNull(message = "El ID del estado de la reserva no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "booking_status_id", nullable = false)
    private BookingStatus bookingStatus;

    @PastOrPresent(message = "La fecha de inicio de la reserva debe ser en el presente o en el pasado.")
    @Column(name = "start_date")
    private LocalDate startDate;

    @Future(message = "La fecha de finalización de la reserva debe ser en el futuro.")
    @Column(name = "end_date")
    private LocalDate endDate;

    @NotNull(message = "El precio total no puede ser nulo.")
    @Column(name = "total_price")
    private BigDecimal totalPrice;

}