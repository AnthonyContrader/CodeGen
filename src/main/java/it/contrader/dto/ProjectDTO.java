package it.contrader.dto;

/**
 * 
 * @author Salvatore
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio di dati sensibili
 *che non devono arrivare alla Servlet). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "Project".
 */
public class ProjectDTO {

	/**
	 * Qui sotto definisco gli attributi di Project. 
	 */
	private int id;

	private String name;
	
	private String description;
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Project
	 */
	public ProjectDTO() {
		
	}

	public ProjectDTO (String name, String description) {
		this.name = name;
		this.description = description;
	}

	public ProjectDTO (int id, String name, String description) {
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
}
