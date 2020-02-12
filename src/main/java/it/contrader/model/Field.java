package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Field {
	
	@NotNull
	@ManyToOne
	private EntityOwner entityowner;//Viene richiamato da tutte le parti
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotNull
	@Column(length = 255)
	private String name;

	@NotNull
	@Column( length = 255)
	private String type;

	@NotNull
	@Column( length = 255)	
	private Long lenght;
}
