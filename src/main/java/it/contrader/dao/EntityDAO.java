package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Entity;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class EntityDAO implements DAO<Entity> {

	private final String QUERY_ALL = "SELECT e.id as 'id',"
			+ "e.name as 'name', "
			+ "e.idproject as 'idproject' "
			
			+ "FROM entity e JOIN project p ON p.id=e.idproject;"
			+ ""
			+ "  ";
	private final String QUERY_CREATE = "INSERT INTO entity (name, idproject) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM entity WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE entity SET name=?,idproject=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM entity WHERE id=?";

	public EntityDAO() {

	}

	public List<Entity> getAll() {
		List<Entity> entitiesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Entity entity;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int idproject = Integer.parseInt(resultSet.getString("idproject"));
			
				entity = new Entity(name,idproject);
				entity.setId(id);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entitiesList;
	}

	public boolean insert(Entity entityToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, entityToInsert.getName());
			preparedStatement.setInt(2, entityToInsert.getIdproject());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Entity read(int entityId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, entityId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;
			int idproject;

			name = resultSet.getString("name");
			idproject = resultSet.getInt("idproject");
			
			Entity entity = new Entity(name, idproject);
			entity.setId(resultSet.getInt("id"));

			return entity;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Entity entityToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (entityToUpdate.getId() == 0)
			return false;

		Entity entityRead = read(entityToUpdate.getId());
		if (!entityRead.equals(entityToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (entityToUpdate.getName() == null || entityToUpdate.getName().equals("")) {
					entityToUpdate.setName(entityRead.getName());
				}

				if (entityToUpdate.getIdproject() == 0 ) {
					entityToUpdate.setIdproject(entityRead.getIdproject());
				}
				

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, entityToUpdate.getName());
				preparedStatement.setInt(2, entityToUpdate.getIdproject());
				preparedStatement.setInt(3, entityToUpdate.getId());
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