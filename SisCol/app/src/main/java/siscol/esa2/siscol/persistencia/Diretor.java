package siscol.esa2.siscol.persistencia;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Diretor extends SugarRecord implements Serializable {
	
	public String Nome;
	public String RG;
	public String Endereco;
	public String Cargo;

	public Diretor(){}


}


