package it.contrader.dto;

/**
 * 
 * @author Salvatore
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "Relationship".
 */
public class RelationshipDTO {
	
	private int id;

	private String entity1;
	
	private String entity2;

	
	public RelationshipDTO() {
		
	}

	public RelationshipDTO (String entity1, String entity2) {
		this.entity1 = entity1;
		this.entity2 = entity2;
	}

	public RelationshipDTO (int id, String entity1, String entity2) {
		this.id = id;
		this.entity1 = entity1;
		this.entity2 = entity2;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEntity1() {
		return this.entity1;
	}

	public void setEntity1(String entity1) {
		this.entity1 = entity1;
	}


	public String getEntity2() {
		return this.entity2;
	}

	public void setEntity2(String entity2) {
		this.entity2 = entity2;
	}

	@Override
	public String toString() {
		return  id + "\t"  + entity1 +"\t\t" +   entity2;
	}
}
