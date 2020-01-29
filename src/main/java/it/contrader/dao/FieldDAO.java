package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Field;

/**
 * 
 * @author Depy
 *
 */
public class FieldDAO implements DAO<Field> {

	private final String QUERY_ALL = "SELECT f.id as 'id',"
			+ "f.name as 'name', "
			+ "f.type as 'type', "
			+ "f.entity as 'entity', "
			+ "e.name as 'nentity',"
			+ "f.lenght as 'lenght' "
			+ "FROM field f JOIN entity e ON e.id=f.entity";
	private final String QUERY_CREATE = "INSERT INTO field (name, type, entity,lenght) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM field WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE field SET name=?, type=?, entity=?,lenght=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM field WHERE id=?";

	public FieldDAO() {

	}

	public List<Field> getAll() {
		List<Field> fieldsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Field field;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				int entity = Integer.parseInt(resultSet.getString("entity"));
				int lenght = Integer.parseInt(resultSet.getString("lenght"));
				field = new Field(name, type, entity,lenght);
				field.setId(id);
				fieldsList.add(field);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fieldsList;
	}

	public boolean insert(Field fieldToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, fieldToInsert.getName());
			preparedStatement.setString(2, fieldToInsert.getType());
			preparedStatement.setInt(3, fieldToInsert.getEntity());
			preparedStatement.setInt(4, fieldToInsert.getLenght());
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
			String name, type;
			int entity=0;

			name = resultSet.getString("name");
			type = resultSet.getString("type");
			entity = resultSet.getInt("entity");
			int lenght = resultSet.getInt("lenght");
			Field field = new Field(name, type, entity,lenght);
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
				// Fill the fieldToUpdate object
				if (fieldToUpdate.getName() == null || fieldToUpdate.getName().equals("")) {
					fieldToUpdate.setName(fieldRead.getName());
				}

				if (fieldToUpdate.getType() == null || fieldToUpdate.getType().equals("")) {
					fieldToUpdate.setType(fieldRead.getType());
				}

				if (fieldToUpdate.getEntity() == 0 ) {
					fieldToUpdate.setEntity(fieldRead.getEntity());
				}
				if (fieldToUpdate.getLenght() == 0 ) {
					fieldToUpdate.setLenght(fieldRead.getLenght());
				}

				// Update the field
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, fieldToUpdate.getName());
				preparedStatement.setString(2, fieldToUpdate.getType());
				preparedStatement.setInt(3, fieldToUpdate.getEntity());
				preparedStatement.setInt(4, fieldToUpdate.getLenght());
				preparedStatement.setInt(5, fieldToUpdate.getId());
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
