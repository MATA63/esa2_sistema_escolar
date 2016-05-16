package siscol.persistencia;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="professor")
public class Professor extends Model implements Serializable {
	@DatabaseField
	public String Nome;
	@DatabaseField
	public String RG;
	@DatabaseField
	public String Endereco;
	@DatabaseField
	public String Titulacao;
	@DatabaseField(foreign = true)
	public Disciplina disciplina;
	@DatabaseField
	public String Cargo;

	public Professor() {
	}

}
