package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="aluno")
public class Aluno extends Model implements Serializable {

	@DatabaseField
	public String Nome;
	@DatabaseField
	public String RG;
	@DatabaseField
	public String Serie;
	@DatabaseField(foreign = true)
	public Disciplina disciplina;
	@DatabaseField
	public String Matricula;

	public Aluno() {
	}

	@Override
	public String toString() {
		return "Aluno [Nome=" + Nome + ", RG=" + RG + ", Serie=" + Serie + ", Matricula=" + Matricula + "]";
	}
	
	
}
