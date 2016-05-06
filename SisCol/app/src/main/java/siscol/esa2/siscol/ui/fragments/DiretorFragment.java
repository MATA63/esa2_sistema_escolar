package siscol.esa2.siscol.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.orm.SugarRecord;

import java.util.List;

import siscol.esa2.siscol.persistencia.Diretor;
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
//        super.intent = new Intent(this.getActivity(), NewAluno.class);    // TODO: 5/2/16
        super.onItemClick(parent, view, position, id);
    }
}
