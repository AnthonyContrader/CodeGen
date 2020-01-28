package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Project {

	/**
	 * Qui sotto definisco gli attributi di Project. 
	 */
	private int id;

	private String name;
	
	private String description;
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Project
	 */
	public Project() {
		
	}

	public Project (String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Project (int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Project
	 */
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


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t" +   description;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
