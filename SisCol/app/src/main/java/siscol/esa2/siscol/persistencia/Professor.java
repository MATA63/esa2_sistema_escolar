package siscol.esa2.siscol.persistencia;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Professor extends SugarRecord implements Serializable {
	
	public String Nome;
	public int RG;
	public String Endereco;
	public String Titulacao;
	public Disciplina disciplina;
	public String Cargo;


	public void verListaAluno(){
		System.out.println();
	}


	public void verListaProfessor(){
		System.out.println();
	}

	public void alterarNotas(){
		System.out.println();
	}


	public void acessarFrequencia(){
		System.out.println();
	}


}

