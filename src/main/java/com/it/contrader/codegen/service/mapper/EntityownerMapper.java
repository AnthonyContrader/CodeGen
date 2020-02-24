package com.it.contrader.codegen.service.mapper;

import com.it.contrader.codegen.domain.*;
import com.it.contrader.codegen.service.dto.EntityownerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Entityowner and its DTO EntityownerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntityownerMapper extends EntityMapper<EntityownerDTO, Entityowner> {



    default Entityowner fromId(Long id) {
        if (id == null) {
            return null;
        }
        Entityowner entityowner = new Entityowner();
        entityowner.setId(id);
        return entityowner;
    }
}
