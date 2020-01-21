package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class CarDTO {
	
	private int id;

	private int idquest;
	
	private String question;

	
	public CarDTO() {
		
	}

	public CarDTO (int idquest, String question) {
		this.idquest = idquest;
		this.question = question;
	}

	public CarDTO (int id, int idquest, String question) {
		this.id = id;
		this.idquest = idquest;
		this.question = question;
	}

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

	@Override
	public String toString() {
		return  id + "\t"  + idquest +"\t\t" +   question;
	}
}
