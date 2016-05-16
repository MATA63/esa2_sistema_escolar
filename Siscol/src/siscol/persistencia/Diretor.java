package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="diretor")
public class Diretor extends Model implements Serializable {
	
	@DatabaseField
	public String Nome;
	@DatabaseField
	public String RG;
	@DatabaseField
	public String Endereco;
	@DatabaseField
	public String Cargo;

	public Diretor(){}

	@Override
	public String toString() {
		return "Diretor [Nome=" + Nome + ", RG=" + RG + ", Endereco=" + Endereco + ", Cargo=" + Cargo + "]";
	}


}


