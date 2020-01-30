package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Relationship;

/**
 * 
 * @author Salvatore
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class RelationshipDAO {

	private final String QUERY_ALL = "SELECT * FROM relationship";
	private final String QUERY_CREATE = "INSERT INTO relationship (entity1,entity2) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM relationship WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE relationship SET entity1=?, entity2=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM relationship WHERE id=?";

	public RelationshipDAO() {

	}

	public List<Relationship> getAll() {
		List<Relationship> relationshipsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Relationship relationship;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int entity1 = Integer.parseInt(resultSet.getString("entity1"));
				int entity2 = Integer.parseInt(resultSet.getString("entity2"));
				relationship = new Relationship(entity1, entity2);
				relationship.setId(id);
				relationshipsList.add(relationship);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relationshipsList;
	}

	public boolean insert(Relationship relationshipToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, relationshipToInsert.getEntity1());
			preparedStatement.setInt(2, relationshipToInsert.getEntity2());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Relationship read(int relationshipId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, relationshipId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int entity1, entity2;

			entity1 = resultSet.getInt("entity1");
			entity2 = resultSet.getInt("entity2");
			Relationship relationship = new Relationship(entity1, entity2);
			relationship.setId(resultSet.getInt("id"));

			return relationship;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Relationship relationshipToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (relationshipToUpdate.getId() == 0)
			return false;

		Relationship relationshipRead = read(relationshipToUpdate.getId());
		if (!relationshipRead.equals(relationshipToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (relationshipToUpdate.getEntity1() == 0 || relationshipToUpdate.getEntity1() == 0) {
					relationshipToUpdate.setEntity1(relationshipRead.getEntity1());
				}

				if (relationshipToUpdate.getEntity2() == 0 || relationshipToUpdate.getEntity2() == 0) {
					relationshipToUpdate.setEntity2(relationshipRead.getEntity2());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, relationshipToUpdate.getEntity1());
				preparedStatement.setInt(2, relationshipToUpdate.getEntity2());
				preparedStatement.setInt(3, relationshipToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
			
		}
		return false;
	}


}
