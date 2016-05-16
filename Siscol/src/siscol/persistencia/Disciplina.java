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
	@DatabaseField(foreign = true)
	public Professor professor;

	public Disciplina() {
	}
}
