package siscol.esa2.siscol.persistencia;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Aluno extends SugarRecord implements Serializable{

	public String Nome;
	public String RG;
	public String Serie;
	public Disciplina disciplina;
	public String Matricula;

	public Aluno(){}

}


