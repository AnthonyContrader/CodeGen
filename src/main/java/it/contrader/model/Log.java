package it.contrader.model;
/**
 * @author Depy
 * 
 */
public class Log {

	private int id;

	private String action;
	
	private String user;
	
	private String date;



	public Log() {
		
	}

	public Log (String action, String user,String date) {
		this.action = action;
		this.user = user;
		this.date = date;
	}

	public Log (int id,String action, String user,String date) {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (id != other.id)
			return false;
		
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}






}
