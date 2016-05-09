package siscol.esa2.siscol.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import siscol.esa2.siscol.R;
import siscol.esa2.siscol.persistencia.Diretor;
import siscol.esa2.siscol.persistencia.Professor;
import siscol.esa2.siscol.ui.fragments.ListFragment;

public class ProfessorActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextRG;
    private EditText editTextEndereco;
    private EditText editTextTitulacao;
    private Professor professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNome = (EditText) findViewById(R.id.edt_txt_value_nome);
        editTextRG = (EditText) findViewById(R.id.edt_txt_value_rg);
        editTextEndereco = (EditText) findViewById(R.id.edt_txt_value_serie);
        editTextTitulacao = (EditText) findViewById(R.id.edt_txt_value_disciplina);


        if (getIntent().getExtras() != null && getIntent().getExtras().get(ListFragment.MODEL) != null)
            professor = (Professor) getIntent().getExtras().get(ListFragment.MODEL);

        if (professor != null) {
            editTextNome.setText(professor.Nome);
            editTextEndereco.setText(professor.Endereco);
            editTextRG.setText(professor.RG);
            editTextTitulacao.setText(professor.Titulacao);
        }

        lock_unlock();

        Button buttonSalvar = (Button) findViewById(R.id.buttonSalvar);

        assert buttonSalvar != null;
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                professor = new Professor();
                if(professor !=null){
                    professor.Nome = editTextNome.getText().toString();
                    professor.RG = editTextRG.getText().toString();
                    professor.Endereco = editTextEndereco.getText().toString();
                    professor.Titulacao = editTextTitulacao.getText().toString();
                    if(professor.save()>0)
                        Toast.makeText(getApplicationContext(),getString(R.string.salvo),Toast.LENGTH_SHORT).show();



                }
            }
        });


    }

    private void lock_unlock() {
        editTextNome.setEnabled(!editTextNome.isEnabled());
        editTextRG.setEnabled(!editTextRG.isEnabled());
        editTextEndereco.setEnabled(!editTextEndereco.isEnabled());
        editTextTitulacao.setEnabled(!editTextTitulacao.isEnabled());
    }
}
