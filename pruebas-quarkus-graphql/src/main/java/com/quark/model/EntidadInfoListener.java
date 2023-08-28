package com.quark.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class EntidadInfoListener {

    @PrePersist
    public void prePersist(EntidadInfo entidadInfo) {
        if(entidadInfo.getCreationDate() == null) {
            entidadInfo.setCreationDate(LocalDateTime.now());
        }

    }

    @PreUpdate
    public void preUpdate(EntidadInfo entidadInfo) {
        if(entidadInfo.getCreationDate() == null) {
            entidadInfo.setCreationDate(LocalDateTime.now());
        }
        entidadInfo.setModifiedDate(LocalDateTime.now());
    }
}
