package it.contrader.model;
/**
 * @author Depy
 * 
 */
public class Log {

	private int id;

	private String action;
	
	private int iduser;
	
	private String date;



	public Log() {
		
	}

	public Log (String action, int iduser,String date) {
		this.action = action;
		this.iduser = iduser;
		this.date = date;
	}

	public Log (int id,String action, int iduser,String date) {
		this.id = id;
		this.action = action;
		this.iduser = iduser;
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
		
		if (iduser == 0) {
			if (other.iduser != 0)
				return false;
			
		} else if (iduser!=(other.iduser))
			return false;
		
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}






}
