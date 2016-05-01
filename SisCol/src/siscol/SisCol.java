/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscol;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import siscol.interfaces.IPersistencia;
import siscol.persistencia.model.Aluno;
import siscol.persistencia.model.Diretor;
import siscol.persistencia.model.Disciplina;
import siscol.persistencia.model.Funcionario;
import siscol.persistencia.model.Professor;
import siscol.ui.MainJFrame;

/**
 *
 * @author tiago
 */
public class SisCol{

    private static IPersistencia iPersistencia;
    private static List<Aluno> alunoList = new ArrayList();
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        open();
    }

    private static void open() {
        iPersistencia = new IPersistencia() {
            @Override
            public void getAluno(Aluno aluno) {
                alunoList.add(aluno);
                System.out.print(aluno.Nome);
            }

            @Override
            public void getDiretor(Diretor diretor) {
            }

            @Override
            public void getFuncionario(Funcionario funcionario) {
            }

            @Override
            public void getProfessor(Professor professor) {
            }
        };
        
        MainJFrame mjf = new MainJFrame("SisCol - Sistema Escolar",iPersistencia);
        mjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mjf.setSize(1024, 768);
        JFrame.setDefaultLookAndFeelDecorated(true);
        mjf.setVisible(true);
    }

    
}
