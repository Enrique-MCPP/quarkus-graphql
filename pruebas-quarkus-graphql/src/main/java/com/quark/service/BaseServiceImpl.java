package com.quark.service;


import com.quark.model.EntidadInfo;
import com.quark.repository.BaseRepository;
import com.quark.service.interfaces.IBaseService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<E extends EntidadInfo, ID extends Serializable> implements IBaseService<E, ID> {
    @Inject
    protected BaseRepository<E, ID> baseRepository;

    @Override
    public E findById(ID id) {
        return baseRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + id));
    }

    @Override
    public E save(E entityForm) {
        if (entityForm.getId() == null) {
            baseRepository.persistAndFlush(entityForm);
        } else {
            entityForm = baseRepository.getEntityManager().merge(entityForm);
        }
        return entityForm;
    }

    @Override
    public List<E> findAll() {
        return baseRepository.listAll();
    }

    @Override
    public boolean delete(ID id) {
        return baseRepository.deleteById(id);
    }

}
