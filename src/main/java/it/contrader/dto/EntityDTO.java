package it.contrader.dto;
/*
 * 
 * @author Selenia, Brunco 
 *
 */


public class EntityDTO {

	

		private int id;

		private String name;
		 private int idproject;
		
		

		
		public EntityDTO() {
			
		}

		public EntityDTO (String name, int idproject) {
			this.name = name;
			this.idproject = idproject;
			
		}

		public EntityDTO (int id, String name , int idproject) {
			this.id = id;
			this.name = name;
			this.idproject = idproject;
			
		}

		
		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		}

		

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		
		public int getIdproject() {
			return idproject;
		}

		public void setIdproject(int idproject) {
			this.idproject = idproject;
		}

		@Override
		public String toString() {
			return  id + "\t"  + name + "\t" + idproject ;
		}

}
