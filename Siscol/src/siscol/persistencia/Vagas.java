package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "vagas")
public class Vagas extends Model implements Serializable {

	@DatabaseField
	public int vagasTotal;
	@DatabaseField
	public int vagasDisponivel;
	
	@Override
	public String toString() {
		return "Vagas [vagasTotal=" + vagasTotal + ", vagasDisponivel=" + vagasDisponivel + "]";
	}

}
