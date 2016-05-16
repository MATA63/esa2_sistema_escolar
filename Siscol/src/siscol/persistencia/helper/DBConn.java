package siscol.persistencia.helper;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import siscol.persistencia.Model;

/**
 * CRUD
 */
public class DBConn {

	public static final int GREATER_THAN = 0;
	public static final int LESS_THAN = 1;

	private DatabaseHelper dh;

	private Dao<Model, Integer> getDao(Class c) throws SQLException {
		return DaoManager.createDao(dh.getConnectionSource(), c);
	}

	public DBConn() {
		dh = new DatabaseHelper();
	}

	public Model createIfNotExists(Class c,Model m) throws SQLException {
		Dao<Model, Integer> dao;
		dao = getDao(c);
		return dao.createIfNotExists(m);
	}

	public void update(Class c,Model m) throws SQLException {
		Dao<Model, Integer> dao;
		dao = getDao(c);
		dao.update(m);
	}

	public void delete(Class c,Model m) throws SQLException {
		if (m != null) {
			Dao<Model, Integer> dao = getDao(c);
			DeleteBuilder<Model, Integer> deleteBuilder = dao.deleteBuilder();
			// deleteBuilder.where().eq(Model.ID, m.id)
			deleteBuilder.delete();
		}
	}

	public List<Model> findAll(Class c) throws SQLException {
		Dao<Model, Integer> dao;
		dao = getDao(c);

		QueryBuilder<Model, Integer> queryBuilder = dao.queryBuilder();
		PreparedQuery<Model> preparedQuery = queryBuilder.prepare();

		return dao.query(preparedQuery);
	}

	public List<Model> find(Class c,String[] args, String[] values) throws SQLException {
		List<Model> ms = null;
		if (args.length == values.length) {
			Dao<Model, Integer> dao = null;
			dao = getDao(c);
			QueryBuilder<Model, Integer> queryBuilder = dao.queryBuilder();
			Where<Model, Integer> where = queryBuilder.where();
			for (int i = 0; i < args.length; i++) {
				where.eq(args[i], values[i]);
				if (i < args.length - 1)
					where.and();// TODO fixed
			}
			PreparedQuery<Model> preparedQuery = queryBuilder.prepare();

			ms = dao.query(preparedQuery);
		}
		return ms;
	}
	

	public List<Model> find(Class c,int operator, String arg, String value) throws SQLException {
		List<Model> ms;
		Dao<Model, Integer> dao;
		dao = getDao(c);
		QueryBuilder<Model, Integer> queryBuilder = dao.queryBuilder();
		Where<Model, Integer> where = queryBuilder.where();
		if (operator == GREATER_THAN)
			where.ge(arg, value);
		else
			where.le(arg, value);

		PreparedQuery<Model> preparedQuery = queryBuilder.prepare();
		ms = dao.query(preparedQuery);
		return ms;
	}

	/**
	 * Find with join
	 *
	 * @param cm
	 *            - class of model that will be returned
	 * @return models of cm
	 */
	public List<Model> raw(Class c,String query) throws SQLException {
		Dao<Model, Integer> dao = getDao(c);
		GenericRawResults<Model> rawResults = dao.queryRaw(query, dao.getRawRowMapper());
		List<Model> ms = rawResults.getResults();
		rawResults.close();
		return ms;
	}

	public void close() {
		dh.close();
	}

}
