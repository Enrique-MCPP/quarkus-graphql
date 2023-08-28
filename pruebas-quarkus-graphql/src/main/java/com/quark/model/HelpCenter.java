package com.quark.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "help_center")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HelpCenter extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "La categoría en español no puede estar en blanco.")
    @Size(max = 256, message = "La categoría en español no puede superar los 256 caracteres.")
    @Column(name = "category_es")
    private String categoryEs;

    @NotBlank(message = "La pregunta en español no puede estar en blanco.")
    @Size(max = 256, message = "La pregunta en español no puede superar los 256 caracteres.")
    @Column(name = "question_es")
    private String questionEs;

    @NotBlank(message = "La respuesta en español no puede estar en blanco.")
    @Column(name = "answer_es", columnDefinition = "MEDIUMTEXT")
    private String answerEs;

    @NotBlank(message = "La categoría en inglés no puede estar en blanco.")
    @Size(max = 256, message = "La categoría en inglés no puede superar los 256 caracteres.")
    @Column(name = "category_en")
    private String categoryEn;

    @NotBlank(message = "La pregunta en inglés no puede estar en blanco.")
    @Size(max = 256, message = "La pregunta en inglés no puede superar los 256 caracteres.")
    @Column(name = "question_en")
    private String questionEn;

    @NotBlank(message = "La respuesta en inglés no puede estar en blanco.")
    @Column(name = "answer_en", columnDefinition = "MEDIUMTEXT")
    private String answerEn;

    @NotBlank(message = "La categoría en catalán no puede estar en blanco.")
    @Size(max = 256, message = "La categoría en catalán no puede superar los 256 caracteres.")
    @Column(name = "category_ca")
    private String categoryCa;

    @NotBlank(message = "La pregunta en catalán no puede estar en blanco.")
    @Size(max = 256, message = "La pregunta en catalán no puede superar los 256 caracteres.")
    @Column(name = "question_ca")
    private String questionCa;

    @NotBlank(message = "La respuesta en catalán no puede estar en blanco.")
    @Column(name = "answer_ca", columnDefinition = "MEDIUMTEXT")
    private String answerCa;

    @NotBlank(message = "La categoría en euskera no puede estar en blanco.")
    @Size(max = 256, message = "La categoría en euskera no puede superar los 256 caracteres.")
    @Column(name = "category_eu")
    private String categoryEu;

    @NotBlank(message = "La pregunta en euskera no puede estar en blanco.")
    @Size(max = 256, message = "La pregunta en euskera no puede superar los 256 caracteres.")
    @Column(name = "question_eu")
    private String questionEu;

    @NotBlank(message = "La respuesta en euskera no puede estar en blanco.")
    @Column(name = "answer_eu", columnDefinition = "MEDIUMTEXT")
    private String answerEu;

    @NotBlank(message = "La categoría en gallego no puede estar en blanco.")
    @Size(max = 256, message = "La categoría en gallego no puede superar los 256 caracteres.")
    @Column(name = "category_gl")
    private String categoryGl;

    @NotBlank(message = "La pregunta en gallego no puede estar en blanco.")
    @Size(max = 256, message = "La pregunta en gallego no puede superar los 256 caracteres.")
    @Column(name = "question_gl")
    private String questionGl;

    @NotBlank(message = "La respuesta en gallego no puede estar en blanco.")
    @Column(name = "answer_gl", columnDefinition = "MEDIUMTEXT")
    private String answerGl;


}

