package com.quark.service.interfaces;


import com.quark.model.EntidadInfo;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E extends EntidadInfo, ID extends Serializable> {

    E findById(ID id) throws Exception;

    E save(E entityForm) throws Exception;

    List<E> findAll() throws Exception;

    boolean delete(ID id) throws Exception;


}