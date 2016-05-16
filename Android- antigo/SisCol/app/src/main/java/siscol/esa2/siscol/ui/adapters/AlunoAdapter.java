package siscol.esa2.siscol.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import siscol.esa2.siscol.R;
import siscol.esa2.siscol.persistencia.Aluno;

/**
 *
 * Created by tiagogoncalves
 */
public class AlunoAdapter extends ArrayAdapter<Aluno> {
    private Context context;
    private List<Aluno> alunoList;

    public AlunoAdapter(Context context, List<Aluno> alunoList) {
        super(context, R.layout.item_list_view, alunoList);
        this.context = context;
        this.alunoList = alunoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list_view, parent, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView matricula = (TextView) view.findViewById(R.id.matricula);

        Aluno aluno = alunoList.get(position);

        nome.setText(aluno.Nome);
        matricula.setText(aluno.Matricula);

        return view;
    }


}
