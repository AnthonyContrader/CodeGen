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
	
	private String entity;

	
	public FieldDTO() {
		
	}

	public FieldDTO (String name, String type, String entity) {
		this.name = name;
		this.type = type;
		this.entity = entity;
	}

	public FieldDTO (int id, String name, String type, String entity) {
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


	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t" +   type + "\t\t" + entity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
}
