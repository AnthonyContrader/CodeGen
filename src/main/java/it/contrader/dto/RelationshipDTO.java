package it.contrader.dto;

import it.contrader.model.EntityCustomer;
import it.contrader.model.EntityOwner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RelationshipDTO {

	private Long id;

	private EntityOwner entityowner;

	private EntityCustomer entitycustomer;


}
