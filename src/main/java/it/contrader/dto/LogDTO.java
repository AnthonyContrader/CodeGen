package it.contrader.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LogDTO {

	private Long id;

	private String user;

	private String action;
	
	private Date moment;

}
