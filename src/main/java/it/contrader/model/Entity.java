package it.contrader.model;

public class Entity {

	private int id;

	private String name;
	
	

	
	public Entity() {
		
	}

	public Entity (String name) {
		this.name = name;
		
	}

	public Entity (int id, String name) {
		this.id = id;
		this.name = name;
		
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

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + name ;
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
		
		return true;
	}
}


