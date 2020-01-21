package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Question {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;

	private String type;
	
	private int id_user;
	
	private String surveylgt;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Question() {//vuoto
		
	}

	public Question (String type, int id_user, String surveylgt) {//construttore pieno
		this.type=type;
		this.id_user = id_user;
		this.surveylgt = surveylgt;
	}

	public Question (int id, String type, int id_user, String surveylgt) {//construttore pieno con ID
		this.id = id;
		this.type=type;
		this.id_user = id_user;
		this.surveylgt = surveylgt;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + type +"\t\t" +   id_user + "\t\t" + surveylgt;
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
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		
		if (surveylgt == null) {
			if (other.surveylgt != null)
				return false;
		} else if (!surveylgt.equals(other.surveylgt))
			return false;
		
		return true;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getSurveylgt() {
		return surveylgt;
	}

	public void setSurveylgt(String surveylgt) {
		this.surveylgt = surveylgt;
	}
}
