package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "turmas")
public class Turma extends Model implements Serializable {

	@DatabaseField
	public String NumTurma;	
	@DatabaseField(foreign=true,columnName="sala_id")
	public Sala sala;
	@DatabaseField(foreign=true,columnName="disciplina_id")
	public Disciplina disciplina;
	
	
	
	@Override
	public String toString() {
		return "Turmas [NumTurma= "+ NumTurma +", sala=" + sala + ", disciplina=" + disciplina + "]";
	}

}
