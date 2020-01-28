package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Project;

/**
 * 
 * @author Salvatore
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class ProjectDAO {

	private final String QUERY_ALL = "SELECT * FROM project";
	private final String QUERY_CREATE = "INSERT INTO project (name, description) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM project WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE project SET name=?, description=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM project WHERE id=?";

	public ProjectDAO() {

	}

	public List<Project> getAll() {
		List<Project> projectsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Project project;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				project = new Project(name, description);
				project.setId(id);
				projectsList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectsList;
	}

	public boolean insert(Project projectToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, projectToInsert.getName());
			preparedStatement.setString(2, projectToInsert.getDescription());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Project read(int projectId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, projectId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description;

			name = resultSet.getString("name");
			description = resultSet.getString("description");
			Project project = new Project(name, description);
			project.setId(resultSet.getInt("id"));

			return project;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Project projectToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (projectToUpdate.getId() == 0)
			return false;

		Project projectRead = read(projectToUpdate.getId());
		if (!projectRead.equals(projectToUpdate)) {
			try {
				// Fill the projectToUpdate object
				if (projectToUpdate.getName() == null || projectToUpdate.getName().equals("")) {
					projectToUpdate.setName(projectRead.getName());
				}

				if (projectToUpdate.getDescription() == null || projectToUpdate.getDescription().equals("")) {
					projectToUpdate.setDescription(projectRead.getDescription());
				}

				// Update the project
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, projectToUpdate.getName());
				preparedStatement.setString(2, projectToUpdate.getDescription());
				preparedStatement.setInt(3, projectToUpdate.getId());
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
