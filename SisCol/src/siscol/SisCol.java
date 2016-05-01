/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscol;

import siscol.persistencia.model.Aluno;
import siscol.persistencia.model.Disciplina;
import siscol.persistencia.model.Funcionario;
import siscol.persistencia.model.Professor;

/**
 *
 * @author tiago
 */
public class SisCol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        populate();
    }

    private static void populate() {
        
		Aluno aluno = new Aluno();
		
		aluno.Nome = "Samuel Almeida";
		aluno.Matricula = 21096878;
		aluno.RG = 1234567;
		aluno.Serie = 8;
		//aluno.disciplinas = Disciplinas.class
		
		Disciplina disciplina = new Disciplina();
		
		disciplina.Nome = "Engenharia 2";
		//disciplinas.professor = Professor.class
		disciplina.qtdTotalAlunos = 45;
		disciplina.Turma = 2;
		
		
		
		Professor professor = new Professor();
		
		professor.Nome = "Tiago Gonçalves";
		professor.Endereco = "Rua B";
		professor.RG = 1234560;
		professor.Cargo = "Concursado";
		professor.Titulacao = "Doutorado";
		//professor.disciplina = Disciplinas.class
		
		Funcionario func = new Funcionario();
		
		func.Nome = "Priscila Teles";
		func.Endereco = "Rua C";
		func.RG = 1234456;
		func.Cargo = "Auxiliar administrativo";
    }
    
}
