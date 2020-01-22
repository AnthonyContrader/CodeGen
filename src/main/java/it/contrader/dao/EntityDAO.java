package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Entity;

public class EntityDAO {


private final String QUERY_ALL = "SELECT * FROM entity";
private final String QUERY_CREATE = "INSERT INTO entity (name) VALUES (?)";
private final String QUERY_READ = "SELECT * FROM entity WHERE id=?";
private final String QUERY_UPDATE = "UPDATE entity SET name=? WHERE id=?";
private final String QUERY_DELETE = "DELETE FROM entity WHERE id=?";

public EntityDAO() {

}

public List<Entity> getAll() {
	List<Entity> entityList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance();
	try {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(QUERY_ALL);
		Entity entity;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			
			entity = new Entity(name);
			entity.setId(id);
			entityList.add(entity);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return entityList;
}

public boolean insert(Entity entityToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {	
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setString(1, entityToInsert.getName());
	
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

		name = resultSet.getString("name");
		
		Entity entity = new Entity(name);
		entity.setId(resultSet.getInt("id"));

		return entity;
	} catch (SQLException e) {
		return null;
	}

}

public boolean update(Entity entityToUpdate) {
	Connection connection = ConnectionSingleton.getInstance();

	
	if (entityToUpdate.getId() == 0)
		return false;

	Entity entityRead = read(entityToUpdate.getId());
	if (!entityRead.equals(entityToUpdate)) {
		try {
			
			if (entityToUpdate.getName() == null || entityToUpdate.getName().equals("")) {
				entityToUpdate.setName(entityRead.getName());
			}

			

			
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, entityToUpdate.getName());
			preparedStatement.setInt(2, entityToUpdate.getId());
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
