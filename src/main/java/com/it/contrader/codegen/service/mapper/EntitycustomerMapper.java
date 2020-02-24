package com.it.contrader.codegen.service.mapper;

import com.it.contrader.codegen.domain.*;
import com.it.contrader.codegen.service.dto.EntitycustomerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Entitycustomer and its DTO EntitycustomerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntitycustomerMapper extends EntityMapper<EntitycustomerDTO, Entitycustomer> {



    default Entitycustomer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Entitycustomer entitycustomer = new Entitycustomer();
        entitycustomer.setId(id);
        return entitycustomer;
    }
}
