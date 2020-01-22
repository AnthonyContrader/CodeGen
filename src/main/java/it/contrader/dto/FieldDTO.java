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

	public FieldDTO() {//construttore vuoto
		
	}

	public FieldDTO (String name, String type) {//construttore PIENO
		this.name = name;
		this.type = type;
	}

	public FieldDTO (int id, String name, String type) {//construttore PIENO con ID
		this.id = id;
		this.name = name;
		this.type = type;
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


	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t" +   type ;
	}

}
