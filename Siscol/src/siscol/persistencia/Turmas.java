package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "turmas")
public class Turmas extends Model implements Serializable {
	
	@DatabaseField
	public Sala sala;
	@DatabaseField
	public Disciplina disciplina;
	
	@Override
	public String toString() {
		return "Turmas [sala=" + sala + ", disciplina=" + disciplina + "]";
	}

}
