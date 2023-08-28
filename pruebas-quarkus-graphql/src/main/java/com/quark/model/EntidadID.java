package com.quark.model;

import java.io.Serializable;

public interface EntidadID <E extends Serializable> {
    E getId();

    void setId(E id);

}