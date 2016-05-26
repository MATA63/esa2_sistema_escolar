package siscol.persistencia;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import siscol.persistencia.helper.DBConn;

/**
 * A simple demonstration object we are creating and persisting to the database.
 */
@DatabaseTable(tableName="model")
public abstract class Model implements Serializable {

	@DatabaseField(generatedId = true)
    public int id;
	
	@DatabaseField
	public boolean inativo;
	
	public boolean save(Class c) {
		// Updating date when object was updated.
		DBConn dbConn = new DBConn();
		try {
			dbConn.createIfNotExists(c,this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbConn.close();
		return false;
	}

	/**
	 * Find all models.
	 *
	 * @param context
	 *            - context
	 * @param active
	 *            - if true it brings only active models.
	 * @param ascending
	 *            - true = ORDER BY id ASC, false = ORDER BY id DESC
	 * @return - lits of models
	 */
	public static List<Model> findAll(Class<?> cm) {
		DBConn dbConn = new DBConn();
		List<Model> modelList = null;
		try {
			modelList = dbConn.findAll(cm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbConn.close();
		return modelList != null ? modelList : new ArrayList<Model>();
	}

	/**
	 * Find specific models.
	 *
	 * @param context
	 *            - context
	 * @param columns
	 *            columns of table
	 * @param values
	 *            values
	 * @return - list of models
	 */
	public static List<Model> find(Class c, String[] columns, String[] values) {
		DBConn dbConn = new DBConn();
		List<Model> modelList = null;
		try {
			modelList = dbConn.find(c,columns, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbConn.close();
		return modelList != null ? modelList : new ArrayList<Model>();
	}

	/**
	 * Find specific models.
	 *
	 * @param context
	 *            - context
	 * @param column
	 *            column of table
	 * @param value
	 *            value
	 * @return list of models
	 */
	public static List<Model> find(Class c, String column, String value) {
		DBConn dbConn = new DBConn();
		List<Model> modelList = null;
		try {
			String[] columns = new String[1];
			columns[0] = column;
			String[] values = new String[1];
			values[0] = value;
			modelList = dbConn.find(c,columns, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbConn.close();
		return modelList != null ? modelList : new ArrayList<Model>();
	}

	/**
	 * Find especific models.
	 *
	 * @param context
	 *            - context
	 * @return List of models
	 */
	public static List<Model> raw(Class c, String query) {
		DBConn dbConn = new DBConn();
		List<Model> modelList = null;
		try {
			modelList = dbConn.raw(c,query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbConn.close();
		return modelList != null ? modelList : new ArrayList<Model>();
	}

	/**
	 * Save if it does not exist, update if it exists.
	 *
	 * @param context
	 *            - context
	 * @return true if it was deleted, false if it is not
	 */
	public boolean delete(Class c) {
		DBConn dbConn = new DBConn();
		inativo = true;
		try {
			dbConn.delete(c,this);
			dbConn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbConn.close();
		return false;
	}
}