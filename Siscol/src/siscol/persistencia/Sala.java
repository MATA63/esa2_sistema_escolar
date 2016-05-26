package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "salas")
public class Sala extends Model implements Serializable {

	@DatabaseField
	public int numero;
	@DatabaseField
	public int qtdMaxima;
	@Override
	public String toString() {
		return "Salas [numero=" + numero + ", qtdMaxima=" + qtdMaxima + "]";
	}

}
