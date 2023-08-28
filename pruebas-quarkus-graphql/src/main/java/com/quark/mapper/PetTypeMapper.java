package com.quark.mapper;



import com.quark.dto.PetTypeDto;
import com.quark.model.PetType;


import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;


@Mapper(componentModel = "jakarta")
@ApplicationScoped
public abstract class PetTypeMapper extends MapperGeneric<PetType, PetTypeDto> {

}




