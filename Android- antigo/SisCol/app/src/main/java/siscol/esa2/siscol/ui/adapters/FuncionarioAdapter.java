package siscol.esa2.siscol.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import siscol.esa2.siscol.R;
import siscol.esa2.siscol.persistencia.Funcionario;

/**
 *
 * Created by tiagogoncalves
 */
public class FuncionarioAdapter extends ArrayAdapter<Funcionario> {
    private Context context;
    private List<Funcionario> funcionarioList;

    public FuncionarioAdapter(Context context, List<Funcionario> funcionarioList) {
        super(context, R.layout.item_list_view, funcionarioList);
        this.context = context;
        this.funcionarioList = funcionarioList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list_view, parent, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView matricula = (TextView) view.findViewById(R.id.matricula);

        Funcionario p = funcionarioList.get(position);

        nome.setText(p.Nome);
//        matricula.setText(aluno.Matricula);

        return view;
    }


}
