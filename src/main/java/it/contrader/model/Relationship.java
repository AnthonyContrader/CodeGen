package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import it.contrader.model.EntityOwner;
import it.contrader.model.EntityCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Relationship {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	private EntityOwner entityowner;
	
	@NotNull
	@ManyToOne
	private EntityCustomer entitycustomer;

}
