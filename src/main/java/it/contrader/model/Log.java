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
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	
	@NotNull
	@Column(length = 255)
	private String user;
	
	@NotNull
	@Column(length = 255)
	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	private Date moment;

	
	 
	
}