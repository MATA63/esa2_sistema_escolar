/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscol.interfaces;

import java.util.List;
import siscol.persistencia.model.Aluno;
import siscol.persistencia.model.Diretor;
import siscol.persistencia.model.Funcionario;
import siscol.persistencia.model.Professor;

/**
 *
 * @author tiago
 */
public interface IPersistencia {
    
    public void setAluno(Aluno aluno);
    public void setDiretor(Diretor diretor);
    public void setFuncionario(Funcionario funcionario);
    public void setProfessor(Professor professor);
    public List<Aluno> getAlunoList();
    
}
