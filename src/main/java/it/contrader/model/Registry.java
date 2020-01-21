package it.contrader.model;

	public class Registry {
		
		private int id;
		private String question;
		private int idquest;
	
		public Registry () {
			
		}
		

		public Registry(String question, int idquest) {
			
			this.question = question;
			this.idquest = idquest;
		}


		public Registry(int id, String question, int idquest) {
		
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
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Registry other = (Registry) obj;
			if (id != other.id)
				return false;
			if (question == null) {
				if (other.question != null)
					return false;
			} else if (!question.equals(other.question))
				return false;
			if (idquest != other.idquest) {
				
					return false;
			} 
			
			return true;
		}
	}
