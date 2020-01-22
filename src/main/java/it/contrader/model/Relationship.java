package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Relationship {

	/**
	 * Qui sotto definisco gli attributi di Relationship. 
	 */
	private int id;

	private String entity1;
	
	private String entity2;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costruire oggetti di tipo Relationship
	 */
	public Relationship() {//vuoto
		
	}

	public Relationship (String entity1, String entity2) {//construttore pieno
		this.entity1 = entity1;
		this.entity2 = entity2;
	}

	public Relationship (int id, String entity1, String entity2) {//construttore pieno con ID
		this.id = id;
		this.entity1 = entity1;
		this.entity2 = entity2;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Relationship
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEntity1() {
		return this.entity1;
	}

	public void setEntity1(String entity1) {
		this.entity1 = entity1;
	}


	public String getEntity2() {
		return this.entity2;
	}

	public void setEntity2(String entity2) {
		this.entity2 = entity2;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + entity1 +"\t\t" +   entity2;
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
		Relationship other = (Relationship) obj;
		if (id != other.id)
			return false;
		if (entity1 == null) {
			if (other.entity1 != null)
				return false;
		} else if (!entity1.equals(other.entity1))
			return false;
		if (entity2 == null) {
			if (other.entity2 != null)
				return false;
		} else if (!entity2.equals(other.entity2))
			return false;
		return true;
	}
}
