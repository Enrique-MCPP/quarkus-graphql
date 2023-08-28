package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El ID del usuario no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "El ID del tipo de mascota no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @NotBlank(message = "El nombre no puede estar en blanco.")
    @Size(max = 20, message = "El nombre no puede superar los 20 caracteres.")
    @Column(name = "name")
    private String name;

    @Past(message = "La fecha de nacimiento debe ser en el pasado.")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @PositiveOrZero(message = "El peso debe ser un número positivo.")
    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "is_microchipped")
    private Boolean isMicrochipped;

    @Column(name = "is_sterilized")
    private Boolean isSterilized;

    @Column(name = "is_trained")
    private Boolean isTrained;

    @Min(value = 0, message = "El nivel de compatibilidad con los niños debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El nivel de compatibilidad con los niños debe ser un número entre 0 y 5.")
    @Column(name = "kid_friendly")
    private Integer kidFriendly;

    @Min(value = 0, message = "El nivel de compatibilidad con los perros debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El nivel de compatibilidad con los perros debe ser un número entre 0 y 5.")
    @Column(name = "dog_friendly")
    private Integer dogFriendly;

    @Min(value = 0, message = "El nivel de compatibilidad con los gatos debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El nivel de compatibilidad con los gatos debe ser un número entre 0 y 5.")
    @Column(name = "cat_friendly")
    private Integer catFriendly;

    @Column(name = "adoption_date")
    private LocalDate adoptionDate;

    @Min(value = 1, message = "El nivel de energía debe ser un número entre 1 y 5.")
    @Max(value = 5, message = "El nivel de energía debe ser un número entre 1 y 5.")
    @Column(name = "energy_level")
    private Integer energyLevel;

    @Min(value = 1, message = "El horario de alimentación debe ser un número entre 1 y 5.")
    @Max(value = 5, message = "El horario de alimentación debe ser un número entre 1 y 5.")
    @Column(name = "feeding_schedule")
    private Integer feedingSchedule;

    @Size(max = 100, message = "Los detalles de alimentación no pueden superar los 100 caracteres.")
    @Column(name = "feeding_details")
    private String feedingDetails;

    @Size(max = 100, message = "Otros detalles no pueden superar los 100 caracteres.")
    @Column(name = "other_details")
    private String otherDetails;

    @Min(value = 0, message = "El tiempo solo debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "El tiempo solo debe ser un número entre 0 y 5.")
    @Column(name = "alone_time")
    private Integer aloneTime;

    @Min(value = 0, message = "La medicación debe ser un número entre 0 y 5.")
    @Max(value = 5, message = "La medicación debe ser un número entre 0 y 5.")
    @Column(name = "medication")
    private Integer medication;

    @Size(max = 100, message = "Los detalles de la medicación no pueden superar los 100 caracteres.")
    @Column(name = "medication_details")
    private String medicationDetails;
}
