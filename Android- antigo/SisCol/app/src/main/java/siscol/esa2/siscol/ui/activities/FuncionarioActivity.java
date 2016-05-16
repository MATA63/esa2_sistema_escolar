package siscol.esa2.siscol.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import siscol.esa2.siscol.R;
import siscol.esa2.siscol.persistencia.Funcionario;
import siscol.esa2.siscol.ui.fragments.ListFragment;

public class FuncionarioActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextRG;
    private EditText editTextEndereco;
    private Funcionario funcionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNome = (EditText) findViewById(R.id.edt_txt_value_nome);
        editTextRG = (EditText) findViewById(R.id.edt_txt_value_rg);
        editTextEndereco = (EditText) findViewById(R.id.edt_txt_value_endereco);

        if (getIntent().getExtras() != null && getIntent().getExtras().get(ListFragment.MODEL) != null)
            funcionario = (Funcionario) getIntent().getExtras().get(ListFragment.MODEL);

        if (funcionario != null) {
            editTextNome.setText(funcionario.Nome);
            editTextEndereco.setText(funcionario.Endereco);
            editTextRG.setText(funcionario.RG);
        }

        lock_unlock();

        Button buttonSalvar = (Button) findViewById(R.id.buttonSalvar);

        assert buttonSalvar != null;
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionario = new Funcionario();
                if (funcionario != null) {
                    funcionario.Nome = editTextNome.getText().toString();
                    funcionario.RG = editTextRG.getText().toString();
                    funcionario.Endereco = editTextEndereco.getText().toString();
                    if (funcionario.save() > 0)
                        Toast.makeText(getApplicationContext(), getString(R.string.salvo), Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    private void lock_unlock() {
        editTextNome.setEnabled(!editTextNome.isEnabled());
        editTextRG.setEnabled(!editTextRG.isEnabled());
        editTextEndereco.setEnabled(!editTextEndereco.isEnabled());
    }
}
