package it.contrader.dto;
/**
 * 
 * @author Depy
 *
 */
public class LogDTO {

	private int id;

	private String action;
	
	private int iduser;
	
	private String date;



	public LogDTO() {
		
	}

	public LogDTO (String action, int iduser, String Date) {
		this.action = action;
		this.iduser = iduser;
		this.date = Date;
	}

	public LogDTO (int id,String action, int iduser,String Date) {
		this.id = id;
		this.action = action;
		this.iduser = iduser;
		this.date = Date;
	}
	


	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}



	public void setAction(String action) {
		this.action = action;
	}



	public int getIduser() {
		return iduser;
	}



	public void setIduser(int iduser) {
		this.iduser = iduser;
	}



	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return  id + "\t"  + action +"\t\t" +   iduser + "\t\t" + date;
	}

	






}
