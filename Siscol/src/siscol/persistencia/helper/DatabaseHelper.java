package siscol.persistencia.helper;


import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import siscol.persistencia.Aluno;
import siscol.persistencia.Diretor;
import siscol.persistencia.Disciplina;
import siscol.persistencia.Funcionario;
import siscol.persistencia.Model;
import siscol.persistencia.Professor;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper{

    private ConnectionSource connectionSource;

    public DatabaseHelper() {

        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:h2:mem:siscol";
        // create a connection source to our database
		try {
			setConnectionSource(new JdbcConnectionSource(databaseUrl));
			TableUtils.createTableIfNotExists(getConnectionSource(), Aluno.class);
			TableUtils.createTableIfNotExists(getConnectionSource(), Model.class);
			TableUtils.createTableIfNotExists(getConnectionSource(), Diretor.class);
			TableUtils.createTableIfNotExists(getConnectionSource(), Disciplina.class);
			TableUtils.createTableIfNotExists(getConnectionSource(), Funcionario.class);
			TableUtils.createTableIfNotExists(getConnectionSource(), Professor.class);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	
    }

    public void close() {
    	try {
			getConnectionSource().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	public ConnectionSource getConnectionSource() {
		return connectionSource;
	}

	public void setConnectionSource(ConnectionSource connectionSource) {
		this.connectionSource = connectionSource;
	}


}
