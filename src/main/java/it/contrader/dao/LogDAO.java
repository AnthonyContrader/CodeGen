package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Log;

/**
 * 
 * @author Depy
 *
 */
public class LogDAO implements DAO<Log> {

	private final String QUERY_ALL = "SELECT id, action, iduser, DATE_FORMAT(date, '%d/%m/%Y %H:%i') as 'date' FROM log";
	private final String QUERY_CREATE = "INSERT INTO log (action, iduser) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM log WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE log SET action=?, iduser=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM log WHERE id=?";

	public LogDAO() {

	}

	public List<Log> getAll() {
		List<Log> logList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Log log;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String action = resultSet.getString("action");
				int iduser = resultSet.getInt("iduser");
				String date = resultSet.getString("date");
				log = new Log(action, iduser,date);
				log.setId(id);
				logList.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logList;
	}

	public boolean insert(Log logToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, logToInsert.getAction());
			preparedStatement.setInt(2, logToInsert.getIduser());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Log read(int logId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, logId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String action, date;
			int iduser;

			action = resultSet.getString("action");
			iduser = resultSet.getInt("iduser");
			date = resultSet.getString("date");
			Log log = new Log(action, iduser, date);
			log.setId(resultSet.getInt("id"));

			return log;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Log logToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (logToUpdate.getId() == 0)
			return false;

		Log logRead = read(logToUpdate.getId());
		if (!logRead.equals(logToUpdate)) {
			try {
				// Fill the logToUpdate object
				if (logToUpdate.getAction() == null || logToUpdate.getAction().equals("")) {
					logToUpdate.setAction(logRead.getAction());
				}

				if (logToUpdate.getIduser() == 0 || logToUpdate.getIduser()==0) {
					logToUpdate.setIduser(logRead.getIduser());
				}


				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, logToUpdate.getAction());
				preparedStatement.setInt(2, logToUpdate.getIduser());
				preparedStatement.setInt(3, logToUpdate.getId());
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
