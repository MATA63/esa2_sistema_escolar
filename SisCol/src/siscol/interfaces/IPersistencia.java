/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscol.interfaces;

import siscol.persistencia.model.Aluno;
import siscol.persistencia.model.Diretor;
import siscol.persistencia.model.Funcionario;
import siscol.persistencia.model.Professor;

/**
 *
 * @author tiago
 */
public interface IPersistencia {
    
    public void getAluno(Aluno aluno);
    public void getDiretor(Diretor diretor);
    public void getFuncionario(Funcionario funcionario);
    public void getProfessor(Professor professor);
    
}
