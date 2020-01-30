package it.contrader.dto;
/**
 * @author Depy
 * 
 */
public class LogDTO {

	private int id;

	private String action;
	
	private String user;
	
	private String date;



	public LogDTO() {
		
	}

	public LogDTO (String action, String user,String date) {
		this.action = action;
		this.user = user;
		this.date = date;
	}

	public LogDTO (int id,String action, String user,String date) {
		this.id = id;
		this.action = action;
		this.user = user;
		this.date = date;
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



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return  id + "\t"  + action +"\t\t" +   user + "\t\t" + date;
	}






}
