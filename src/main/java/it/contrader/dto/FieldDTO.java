package it.contrader.dto;


import it.contrader.model.EntityOwner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldDTO {

	private Long id;

	private String name;

	private String type;	
		
	private Long lenght;
	
	private EntityOwner entityowner;
	

}