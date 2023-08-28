package com.quark.repository;


import com.quark.model.EntidadInfo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@ApplicationScoped
public interface BaseRepository<E extends EntidadInfo, ID extends Serializable> extends PanacheRepositoryBase<E, ID> {

}
