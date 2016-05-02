package siscol.esa2.siscol.persistencia;

import com.orm.SugarRecord;

public class Aluno extends SugarRecord{

	public String Nome;
	public String RG;
	public String Serie;
	public Disciplina disciplina;
	public String Matricula;

}


