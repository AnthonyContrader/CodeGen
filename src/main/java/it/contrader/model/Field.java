package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//https://github.com/AnthonyContrader/iTeams/tree/iteams-spring/src/main/java/it/contrader/model


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Field {
	
	
	
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
	
	 @ManyToOne
	 @JoinColumn(name = "id", referencedColumnName="identity")
	 private EntityOwner entityowner;//Viene richiamato da tutte le parti
	
}