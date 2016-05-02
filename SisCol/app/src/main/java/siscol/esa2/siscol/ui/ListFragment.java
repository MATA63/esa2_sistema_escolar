package siscol.esa2.siscol.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.List;

import siscol.esa2.siscol.R;


/**
 * This is the fragment that shows the list of Scope.
 *
 * @author tiagogoncalves
 */
public abstract class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static final String MODEL = "model";

    public List<SugarRecord> modelList;
    public ArrayAdapter adapter;
    public Intent intent;

    public ListView listView;


    public abstract void buildInOnCreate();

    public abstract void createList();

    public abstract void updateAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listView = (ListView) view.findViewById(R.id.list_view);
        listView.setVisibility(ListView.VISIBLE);
        buildInOnCreate();
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (intent != null) {
            Bundle b = new Bundle();
            b.putSerializable(MODEL, (Serializable) modelList.get(position));
            intent.putExtras(b);
            startActivityForResult(intent, 0);
        }
    }

    /**
     * Updating a particular item inside the list.
     *
     * @param model - item
     */
    protected void updateModelList(SugarRecord model) {
        createList();
        updateAdapter();
    }


    @Override
    public void onResume() {
        super.onResume();
        createList();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && data.getExtras() != null) {
            Bundle b = data.getExtras();
            if (b.getSerializable(ListFragment.MODEL) != null) {
                updateModelList((SugarRecord) b.getSerializable(ListFragment.MODEL));
                updateAdapter();
            }
        }
    }

}