package siscol.esa2.siscol.persistencia;

import com.orm.SugarRecord;

public class Disciplina extends SugarRecord {
        
	public String Nome;
	public int Turma;
	public int qtdTotalAlunos;
	public Professor professor;
}

