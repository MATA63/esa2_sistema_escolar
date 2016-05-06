package siscol.esa2.siscol.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import siscol.esa2.siscol.R;
import siscol.esa2.siscol.persistencia.Aluno;
import siscol.esa2.siscol.persistencia.Professor;

public class ProfessorActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextRG;
    private EditText editTextSerie;
    private EditText editTextDisciplina;
    private EditText editTextMatricula;
    private Professor professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNome = (EditText) findViewById(R.id.edt_txt_value_nome);
        editTextRG = (EditText) findViewById(R.id.edt_txt_value_rg);
        editTextSerie = (EditText) findViewById(R.id.edt_txt_value_serie);
        editTextDisciplina = (EditText) findViewById(R.id.edt_txt_value_disciplina);
        editTextMatricula = (EditText) findViewById(R.id.edt_txt_value_matricula);

        lock_unlock();

        Button buttonSalvar = (Button) findViewById(R.id.buttonSalvar);

        assert buttonSalvar != null;
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor = new Professor();
                if(professor !=null){
                    professor.Nome = editTextNome.getText().toString();
//                    professor.RG = editTextRG.getText().toString();
//                    professor.Serie = editTextSerie.getText().toString();
////                    professor.disciplina = editTextDisciplina.getText().toString();
//                    professor.Matricula = editTextMatricula.getText().toString();
                    if(professor.save()>0)
                        Toast.makeText(getApplicationContext(),getString(R.string.salvo),Toast.LENGTH_SHORT).show();



                }
            }
        });


    }

    private void lock_unlock() {
        editTextNome.setEnabled(!editTextNome.isEnabled());
        editTextRG.setEnabled(!editTextRG.isEnabled());
        editTextSerie.setEnabled(!editTextSerie.isEnabled());
        editTextDisciplina.setEnabled(!editTextDisciplina.isEnabled());
        editTextMatricula.setEnabled(!editTextMatricula.isEnabled());
    }
}
