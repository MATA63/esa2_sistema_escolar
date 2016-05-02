package siscol.persistencia.model;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Aluno extends Model{

	public String Nome;
	public String RG;
	public String Serie;
	public Disciplina disciplina;
	public String Matricula;

    @Override
    public int getNumColumns() {
        return 5;
    }
    
    public static void buildTableModel(List<Aluno> alunoList,DefaultTableModel alunoDataModel){

        // names of columns
        Vector<String> columnNames = new Vector<String>();
            columnNames.add("Nome");
            columnNames.add("RG");
            columnNames.add("Matrícula");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<Object> vector = new Vector<Object>();
        for(Aluno aluno: alunoList){
            // data of the table
            vector.add(aluno.Nome);        
            vector.add(aluno.RG);        
            vector.add(aluno.Matricula);        
        }
        data.add(vector);
        alunoDataModel.setDataVector(data, columnNames);
    }
}


