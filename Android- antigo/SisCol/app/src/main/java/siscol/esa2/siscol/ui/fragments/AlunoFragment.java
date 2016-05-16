package siscol.esa2.siscol.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.List;

import siscol.esa2.siscol.persistencia.Aluno;
import siscol.esa2.siscol.ui.activities.AlunoActivity;
import siscol.esa2.siscol.ui.adapters.AlunoAdapter;

/**
 *
 * Created by tiago on 5/2/16.
 */
public class AlunoFragment extends ListFragment {
    @Override
    public void buildInOnCreate() {
        createList();
        super.adapter = new AlunoAdapter(this.getContext(), (List<Aluno>) (List<?>) super.modelList);
        adapter.notifyDataSetChanged();

        assert fab != null;
        fab.setVisibility(FloatingActionButton.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AlunoActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void createList() {
        super.modelList = (List<SugarRecord>) (List<?>) Aluno.listAll(Aluno.class);
    }

    @Override
    public void updateAdapter() {
        super.adapter = new AlunoAdapter(this.getContext(), (List<Aluno>) (List<?>) super.modelList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.intent = new Intent(this.getActivity(), AlunoActivity.class);
        super.onItemClick(parent, view, position, id);
    }

    @Override
    public void onEdit(int position) {
        super.intent = new Intent(this.getActivity(), AlunoActivity.class);
        super.onEdit(position);
    }
}
