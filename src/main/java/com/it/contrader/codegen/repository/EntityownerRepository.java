package com.it.contrader.codegen.repository;

import com.it.contrader.codegen.domain.Entityowner;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Entityowner entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityownerRepository extends JpaRepository<Entityowner, Long> {

}
