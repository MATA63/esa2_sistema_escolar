package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "notas")
public class Notas extends Model implements Serializable {
	@DatabaseField
	public int valor;
	@DatabaseField
	public float media;
	@DatabaseField
	public String Status;
	@DatabaseField(foreign=true,columnName="aluno_id")
	public Aluno aluno;
	@DatabaseField(foreign=true,columnName="disciplina_id")
	public Disciplina disciplina;
	@Override
	public String toString() {
		return "Notas [valor=" + valor + ", aluno=" + aluno + ", disciplina=" + disciplina + "]";
	}

	

}
