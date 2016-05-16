package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "disciplina")
public class Disciplina extends Model implements Serializable {
	@DatabaseField
	public String Nome;
	@DatabaseField
	public int Turma;
	@DatabaseField
	public int qtdTotalAlunos;
	@DatabaseField(foreign = true,columnName="professor_id")
	public Professor professor;

	public Disciplina() {
	}

	@Override
	public String toString() {
		return "Disciplina [Nome=" + Nome + ", Turma=" + Turma + ", qtdTotalAlunos=" + qtdTotalAlunos + ", professor="+ professor + "]";
	}
	
	
}
