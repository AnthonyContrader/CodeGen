package it.contrader.model;
/**
 * 
 * @author Depy
 *

 */
public class Field {


	private int id;

	private String name;
	
	private String type;
	
	private int entity;
	
	private int lenght;

	public Field() {//construttore vuoto
		
	}

	public Field (String name, String type, int entity, int lenght) {//construttore PIENO
		this.name = name;
		this.type = type;
		this.entity = entity;
		this.lenght = lenght;
	}

	public Field (int id, String name, String type, int entity, int lenght) {//construttore PIENO con ID
		this.id = id;
		this.name = name;
		this.type = type;
		this.entity = entity;
		this.lenght = lenght;
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
		return  id + "\t"  + name +"\t\t" +   type+" ("+lenght+")"    +"\t\t" +   entity;
	}

	//confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Field other = (Field) obj;
		if (id != other.id)
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		
		if (entity == 0) {
			if (other.entity != 0)
				return false;
		} else if (entity!=other.entity)
			return false;
		
		if (lenght == 0) {
			if (other.lenght != 0)
				return false;
		} else if (lenght!=other.lenght)
			return false;
		
		return true;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	
}
