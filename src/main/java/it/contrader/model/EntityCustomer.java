package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EntityCustomer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (unique = true) 
	@NotNull
	/*@ManyToMany
	@JoinColumn(name = ‘idproject(foreignKey)’) ; */
	
	private String name;
	@NotNull
	private Long idproject;
	@NotNull
	private Long idowner;

	

}
