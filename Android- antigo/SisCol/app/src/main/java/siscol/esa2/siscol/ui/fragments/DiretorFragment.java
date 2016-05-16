package siscol.esa2.siscol.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.orm.SugarRecord;

import java.util.List;

import siscol.esa2.siscol.persistencia.Diretor;
import siscol.esa2.siscol.ui.activities.AlunoActivity;
import siscol.esa2.siscol.ui.activities.DiretorActivity;
import siscol.esa2.siscol.ui.adapters.DiretorAdapter;

/**
 *
 * Created by tiago on 5/2/16.
 */
public class DiretorFragment extends ListFragment {
    @Override
    public void buildInOnCreate() {
        createList();
        super.adapter = new DiretorAdapter(this.getContext(), (List<Diretor>) (List<?>) super.modelList);
        assert fab != null;
        fab.setVisibility(FloatingActionButton.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DiretorActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void createList() {
        super.modelList = (List<SugarRecord>) (List<?>) Diretor.listAll(Diretor.class);
    }

    @Override
    public void updateAdapter() {
        super.adapter = new DiretorAdapter(this.getContext(), (List<Diretor>) (List<?>) super.modelList);
        listView.setAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.intent = new Intent(this.getActivity(), DiretorActivity.class);
        super.onItemClick(parent, view, position, id);
    }

    @Override
    public void onEdit(int position) {
        super.intent = new Intent(this.getActivity(), DiretorActivity.class);
        super.onEdit(position);
    }
}
