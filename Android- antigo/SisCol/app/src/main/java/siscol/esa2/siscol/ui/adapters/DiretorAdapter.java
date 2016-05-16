package siscol.esa2.siscol.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import siscol.esa2.siscol.R;
import siscol.esa2.siscol.persistencia.Diretor;

/**
 *
 * Created by tiagogoncalves
 */
public class DiretorAdapter extends ArrayAdapter<Diretor> {
    private Context context;
    private List<Diretor> diretorList;

    public DiretorAdapter(Context context, List<Diretor> diretorList) {
        super(context, R.layout.item_list_view, diretorList);
        this.context = context;
        this.diretorList = diretorList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list_view, parent, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView matricula = (TextView) view.findViewById(R.id.matricula);

        Diretor p = diretorList.get(position);

        nome.setText(p.Nome);
//        matricula.setText(aluno.Matricula);

        return view;
    }


}
