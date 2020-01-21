package it.contrader.dto;

public class RegistryDTO {

	private int id;
	private String question;
	private int idquest;

	public RegistryDTO () {
		
	}
	

	public RegistryDTO(String question, int idquest) {
		
		this.question = question;
		this.idquest = idquest;
	}


	public RegistryDTO(int id, String question, int idquest) {
	
		this.id = id;
		this.question = question;
		this.idquest = idquest;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public int getIdquest() {
		return idquest;
	}


	public void setIdquest(int idquest) {
		this.idquest = idquest;
	}


	@Override
	public String toString() {
		return "Registry [id=" + id + ", question=" + question + ", idquest=" + idquest + "]";
	}

}
