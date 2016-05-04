package siscol.esa2.siscol.persistencia;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Disciplina extends SugarRecord implements Serializable {
        
	public String Nome;
	public int Turma;
	public int qtdTotalAlunos;
	public Professor professor;

	public Disciplina(){}
}

