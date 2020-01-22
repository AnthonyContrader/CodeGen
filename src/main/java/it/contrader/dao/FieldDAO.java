package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Field;

/**
 * 
 * @author Depy
 *
 */
public class FieldDAO {

	private final String QUERY_ALL = "SELECT * FROM field ";
	private final String QUERY_CREATE = "INSERT INTO field (name, type, entity) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM field WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE field SET name=?, type=?, entity=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM field WHERE id=?";

	public FieldDAO() {

	}

	public List<Field> getAll() {
		List<Field> fieldList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Field field;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				String entity = resultSet.getString("entity");
				field = new Field(name, type, entity);
				field.setId(id);
				fieldList.add(field);//Aggiunge tramite comando add un nuovo oggetto per la lista 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fieldList;
	}

	public boolean insert(Field fieldToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, fieldToInsert.getName());
			preparedStatement.setString(2, fieldToInsert.getType());
			preparedStatement.setString(3, fieldToInsert.getEntity());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Field read(int fieldId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, fieldId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, type, entity;

			name = resultSet.getString("name");
			type = resultSet.getString("type");
			entity = resultSet.getString("entity");
			Field field = new Field(name, type, entity);
			field.setId(resultSet.getInt("id"));

			return field;
		} catch (SQLException e) {
			return null;
		}

	}
	

	public boolean update(Field fieldToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (fieldToUpdate.getId() == 0)
			return false;

		Field fieldRead = read(fieldToUpdate.getId());
		if (!fieldRead.equals(fieldToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (fieldToUpdate.getName() == null || fieldToUpdate.getName().equals("")) {
					fieldToUpdate.setName(fieldRead.getName());
				}

				if (fieldToUpdate.getType() == null || fieldToUpdate.getType().equals("")) {
					fieldToUpdate.setType(fieldRead.getType());
				}

				if (fieldToUpdate.getEntity() == null || fieldToUpdate.getEntity().equals("")) {
					fieldToUpdate.setEntity(fieldRead.getEntity());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, fieldToUpdate.getName());
				preparedStatement.setString(2, fieldToUpdate.getType());
				preparedStatement.setString(3, fieldToUpdate.getEntity());
				preparedStatement.setInt(4, fieldToUpdate.getId());
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
