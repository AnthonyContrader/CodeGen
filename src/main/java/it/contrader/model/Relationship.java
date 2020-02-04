package it.contrader.model;

import javax.persistence.*;
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

	@ManyToOne
	@JoinColumn(name = "idowner",referencedColumnName="id")
	private EntityOwner entityowner;
	
	@ManyToOne
	@JoinColumn(name = "idcustomer", referencedColumnName="id")
	private EntityCustomer entitycustomer;

}
