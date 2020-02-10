package it.contrader.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import it.contrader.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EntityOwner {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (unique = true  ) 
	@NotNull
	private String name;
	@NotNull
	@ManyToOne
	private Project project;
	

	

}
