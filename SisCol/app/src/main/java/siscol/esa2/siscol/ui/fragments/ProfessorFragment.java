package siscol.esa2.siscol.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.orm.SugarRecord;

import java.util.List;

import siscol.esa2.siscol.persistencia.Aluno;
import siscol.esa2.siscol.persistencia.Professor;
import siscol.esa2.siscol.ui.adapters.AlunoAdapter;
import siscol.esa2.siscol.ui.adapters.ProfessorAdapter;

/**
 *
 * Created by tiago on 5/2/16.
 */
public class ProfessorFragment extends ListFragment {
    @Override
    public void buildInOnCreate() {
        createList();
        super.adapter = new ProfessorAdapter(this.getContext(), (List<Professor>) (List<?>) super.modelList);
    }

    @Override
    public void createList() {
        super.modelList = (List<SugarRecord>) (List<?>) Professor.listAll(Professor.class);
    }

    @Override
    public void updateAdapter() {
        super.adapter = new ProfessorAdapter(this.getContext(), (List<Professor>) (List<?>) super.modelList);
        listView.setAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        super.intent = new Intent(this.getActivity(), NewAluno.class);    // TODO: 5/2/16
        super.onItemClick(parent, view, position, id);
    }
}
