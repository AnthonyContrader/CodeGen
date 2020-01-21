package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Car {

	/**
	 * Qui sotto definisco gli attributi di Car. 
	 */
	private int id;

	private int idquest;
	
	private String question;
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Car
	 */
	public Car() {
		
	}

	public Car (int idquest, String question) {
		this.idquest = idquest;
		this.question = question;
	}

	public Car (int id, int idquest, String question) {
		this.id = id;
		this.idquest = idquest;
		this.question = question;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIdquest() {
		return this.idquest;
	}

	public void setIdquest(int idquest) {
		this.idquest = idquest;
	}


	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + idquest +"\t\t" +   question;
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
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		if (idquest != other.idquest)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
			
		return true;
	}
}
