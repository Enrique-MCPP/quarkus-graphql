package com.quark.repository;


import com.quark.model.PetType;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public interface PetTypeRepository extends BaseRepository<PetType, Long> {


}
