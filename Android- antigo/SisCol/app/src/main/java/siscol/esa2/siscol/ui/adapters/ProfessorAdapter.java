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
import siscol.esa2.siscol.persistencia.Professor;

/**
 *
 * Created by tiagogoncalves
 */
public class ProfessorAdapter extends ArrayAdapter<Professor> {
    private Context context;
    private List<Professor> professorList;

    public ProfessorAdapter(Context context, List<Professor> professorList) {
        super(context, R.layout.item_list_view, professorList);
        this.context = context;
        this.professorList = professorList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list_view, parent, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView matricula = (TextView) view.findViewById(R.id.matricula);

        Professor p = professorList.get(position);

        nome.setText(p.Nome);
//        matricula.setText(aluno.Matricula);

        return view;
    }


}
