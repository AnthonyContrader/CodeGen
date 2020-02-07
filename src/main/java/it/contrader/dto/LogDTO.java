package it.contrader.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LogDTO {

	public LogDTO(String uSER2, String mode, Date date) {

		this.user=uSER2;
		this.action=mode;
		this.moment=date;
	}

	private Long id;

	private String user;

	private String action;
	
	private Date moment;

}
