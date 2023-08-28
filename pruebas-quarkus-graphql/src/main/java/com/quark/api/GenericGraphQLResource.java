package com.quark.api;

import com.quark.dto.interfaces.IDto;
import com.quark.exceptions.*;
import com.quark.mapper.MapperGeneric;
import com.quark.model.EntidadInfo;
import com.quark.service.BaseServiceImpl;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.graphql.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Slf4j
@Setter
@Getter
public abstract class GenericGraphQLResource<E extends EntidadInfo, ID extends Serializable, D extends IDto, S extends BaseServiceImpl<E, ID>, M extends MapperGeneric<E, D>> {

    @Inject
    protected S baseService;

    @Inject
    protected M mapper;

    // Instancia a nivel de clase
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private List<String> listaErrores = new ArrayList<>();

    private E entity;

    private D dto;

    @Query
    public List<D> getAll() {
        try {
            List<E> entities = baseService.findAll();
            return mapper.toDtoList(entities);
        } catch (Exception e) {
            throw new GenericException(ErrorCode.DATABASE_ERROR, "Error al obtener todos los registros: " + e.getMessage(), e);
        }
    }

    @Query
    public D getOne(ID id) {
        try {
            E entity = baseService.findById(id);
            if (entity == null) {
                throw new GenericException(ErrorCode.NOT_FOUND_ERROR, "No se encontró el registro con id " + id);
            }
            return mapper.toDto(entity);
        } catch (Exception e) {
            throw new GenericException(ErrorCode.DATABASE_ERROR, e.getMessage(), e);
        }
    }

    @Mutation
    @Transactional
    public D save(D dto) {
        log.info("Iniciando proceso de guardado de un registro...");

        getListaErrores().clear();

        // Validación Bean del DTO
        // Usar la instancia a nivel de clase
        Set<ConstraintViolation<D>> violations = validator.validate(dto);

        for (ConstraintViolation<D> violation : violations) {
            getListaErrores().add(violation.getMessage());
        }

        try {
            this.dto = dto;
            entity = mapper.toEntity(dto);

            boolean entityNew = false;
            if (entity.getId() == null) {
                entityNew = true;
                beforeInsert(entity);
                log.info("Ejecutando método doBeforeInsert...");
            } else {
                entityNew = false;
                beforeUpdate(entity);
                log.info("Ejecutando método doBeforeUpdate...");
            }

            if (!getListaErrores().isEmpty()) {
                throw new GenericException(ErrorCode.VALIDATION_ERROR, "Errores de validación: " + String.join(", ", getListaErrores()));
            }

            // Guardar entidad
            log.trace("Objeto a guardar: {}", entity);
            E savedEntity = baseService.save(entity);
            log.trace("Objeto guardado: {}", savedEntity);
            D savedDto = mapper.toDto(savedEntity);

            if (entityNew) {
                afterInsert(entity);
                log.info("Ejecutando método doAfterInsert...");
            } else {
                afterUpdate(entity);
                log.info("Ejecutando método doAfterUpdate...");
            }

            return savedDto;

        } catch (Exception e) {
            log.error("Error guardando el registro: " + e.getMessage(), e);
            throw new GenericException(ErrorCode.DATABASE_ERROR, "No se ha podido guardar el registro: " + e.getMessage(), e);
        }
    }

    @Mutation
    @Description("Método genérico para eliminar un registro")
    public boolean delete(@Name("id") ID id) {
        try {
            log.info("Eliminando registro con ID %s", id);

            // Llamada a método personalizado antes de eliminar
            beforeDelete(id);

            baseService.delete(id);

            // Llamada a método personalizado después de eliminar
            afterDelete(id);

            log.info("Registro eliminado con éxito");
            return true;
        } catch (Exception e) {
            log.error("Error al eliminar registro con ID %s", id, e);
            throw new GenericException(ErrorCode.DATABASE_ERROR, "Error al eliminar registro: " + e.getMessage(), e);
        }
    }

    // ... (otras partes de tu clase)

    protected void beforeInsert(E entity) {
        // Método vacío en la clase genérica
    }

    protected void afterInsert(E entity) {
        // Método vacío en la clase genérica
    }

    protected void beforeUpdate(E entity) {
        // Método vacío en la clase genérica
    }

    protected void afterUpdate(E entity) {
        // Método vacío en la clase genérica
    }

    protected void beforeDelete(ID id) {
        // Método vacío en la clase genérica
    }

    protected void afterDelete(ID id) {
        // Método vacío en la clase genérica
    }
}
