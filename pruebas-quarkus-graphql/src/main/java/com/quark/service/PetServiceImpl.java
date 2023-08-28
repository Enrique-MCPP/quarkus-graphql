/*package com.quark.service;


import com.quark.dto.PetDto;
import com.quark.exceptions.ErrorCode;
import com.quark.exceptions.GenericException;
import com.quark.mapper.PetMapper;
import com.quark.model.Pet;
import com.quark.model.User;
import com.quark.repository.PetRepository;
import com.quark.repository.UserRepository;
import com.quark.service.interfaces.IPetService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@ApplicationScoped
public class PetServiceImpl extends BaseServiceImpl<Pet, Long> implements IPetService {

    @Inject
    private UserRepository userRepository;
    @Inject
    private PetRepository petRepository;
    @Inject
    private PetMapper petMapper;


    public List<PetDto> getUserPets(Long userId) {
        Optional<User> userOptional = userRepository.findByIdWithPets(userId);

        if (userOptional.isEmpty()) {
            // Manejar el caso en el que el usuario no se encuentre
            return new ArrayList<>();
        }

        User user = userOptional.get();
        // Convertir tus entidades Pet en PetDto para devolver
        //List<PetDto> petDtos = user.getPets().stream().map(pet -> petMapper.toDto(pet)).collect(Collectors.toList());

        return petMapper.toDtoList(user.getPets());
    }

    public void deleteUserPet(Long userId, Long petId) {
        Optional<User> userOptional = userRepository.findByIdWithPets(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Pet> pets = user.getPets();
            boolean petRemoved = pets.removeIf(pet -> pet.getId().equals(petId));

            if (petRemoved) {
                userRepository.persistAndFlush(user);
            } else {
                throw new GenericException(ErrorCode.NOT_FOUND_ERROR, "Mascota no encontrada.");
            }
        } else {
            throw new GenericException(ErrorCode.NOT_FOUND_ERROR, "Usuario no encontrado.");
        }
    }


}

*/