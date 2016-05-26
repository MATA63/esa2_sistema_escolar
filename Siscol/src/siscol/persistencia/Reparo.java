package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "reparo")
public class Reparo extends Model implements Serializable {

	@DatabaseField
	private int numeroChamado;
	@DatabaseField
	public String solicitante;
	@DatabaseField
	private int ramal;
	@DatabaseField
	public String responsavel;
	
	
	@Override
	public String toString() {
		return "Reparo [numeroChamado=" + numeroChamado + ", solicitante=" + solicitante + ", ramal=" + ramal + ", responsavel=" + responsavel + "]";
	}

}
