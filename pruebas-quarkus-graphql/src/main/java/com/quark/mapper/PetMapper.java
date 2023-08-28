package com.quark.mapper;



import com.quark.dto.PetDto;
import com.quark.model.Pet;


import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;



@Mapper(componentModel = "jakarta")
@ApplicationScoped
public abstract class PetMapper extends MapperGeneric<Pet, PetDto> {



}




