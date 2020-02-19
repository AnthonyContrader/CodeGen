package it.contrader.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "Logs")

public class Log {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;		
	
	@NotNull
	@Column(length = 255)
	private String user;
	
	@NotNull
	@Column(length = 255)
	private String action;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date moment;
	//CURRENT_TIMESTAMP
	
}