package com.it.contrader.codegen.repository;

import com.it.contrader.codegen.domain.Entitycustomer;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Entitycustomer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntitycustomerRepository extends JpaRepository<Entitycustomer, Long> {

}
