package com.quark.mapper;


import com.quark.model.EntidadInfo;
import org.mapstruct.Mapper;

import java.util.List;


public abstract class MapperGeneric<E, D> {

    public abstract D toDto(E entity);

    public abstract E toEntity(D dto);

    public abstract List<D> toDtoList(List<E> entities);

    public abstract List<E> toEntityList(List<D> dtos);
}


