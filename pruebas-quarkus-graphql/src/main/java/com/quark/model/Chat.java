package com.quark.model;


import com.quark.dto.MessageDto;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "chat")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat extends EntidadInfo<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pet_owner", nullable = false)
    private User petOwner;

    @ManyToOne
    @JoinColumn(name = "id_sitter", nullable = false)
    private User sitter;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    @Transient
    private Message lastMessage;

}
