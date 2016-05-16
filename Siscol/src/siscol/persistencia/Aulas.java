package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="aulas")
public class Aulas extends Model implements Serializable {
	@DatabaseField
	private String Login;
	@DatabaseField
	private int MatriculaAluno;
	@DatabaseField
	private int passwd;
	@DatabaseField
	private Professor professor;
	@Override
	public String toString() {
		return "Aulas [Login=" + Login + ", MatriculaAluno=" + MatriculaAluno + ", passwd=" + passwd + ", professor="
				+ professor + "]";
	}
	
	
	

}
