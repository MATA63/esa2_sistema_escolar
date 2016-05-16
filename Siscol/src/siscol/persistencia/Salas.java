package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "salas")
public class Salas extends Model implements Serializable {

	@DatabaseField
	private int numero;
	@DatabaseField
	private int qtdMaxima;
	@Override
	public String toString() {
		return "Salas [numero=" + numero + ", qtdMaxima=" + qtdMaxima + "]";
	}

}
