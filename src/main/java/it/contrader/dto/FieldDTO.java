package it.contrader.dto;

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

	private Long identity;
		
	private Long lenght;
	
	

}
