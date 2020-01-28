package it.contrader.dto;
/**
 * 
 * @author Depy
 *

 */
public class FieldDTO {


	private int id;

	private String name;
	
	private String type;
	
	private int entity;

	public FieldDTO() {//construttore vuoto
		
	}

	public FieldDTO (String name, String type, int entity) {//construttore PIENO
		this.name = name;
		this.type = type;
		this.entity = entity;
		
	}

	public FieldDTO (int id, String name, String type, int entity) {//construttore PIENO con ID
		this.id = id;
		this.name = name;
		this.type = type;
		this.entity = entity;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t" +   type+"\t\t" +   entity ;
	}



	
}
