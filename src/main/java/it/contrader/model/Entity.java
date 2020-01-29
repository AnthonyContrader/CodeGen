package it.contrader.model;
/*
 * 
 * @author Selenia, Brunco 
 *
 */


public class Entity {

	private int id;

	private String name;
	private int idproject;
	
	

	
	public Entity() {
		
	}

	public Entity (String name, int idproject) {
		this.name = name;
		this.idproject = idproject;
		
	}

	public Entity (int id, String name, int idproject) {
		this.id = id;
		this.name = name;
		this.idproject = idproject;
		
		
	}

	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getIdproject() {
		return idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + name + "\t" + idproject ;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (idproject!= other.idproject)
			return false;
		
		return true;
	}
}


