package siscol.esa2.siscol.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import siscol.esa2.siscol.R;


/**
 */
public class EditDeleteDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {

    public static final String MODEL_POS = "model_pos";
    public static final String EDIT_UNABLE = "EDT_ENBLD";
    private OnEditRemoveItem onEditRemoveItem;
    private int position;
    private boolean editUnable;

    public void setOnEditRemoveItem(OnEditRemoveItem onEditRemoveItem) {
        this.onEditRemoveItem = onEditRemoveItem;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_edit_remove, container);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        position = getArguments().getInt(MODEL_POS);

        editUnable = getArguments().getBoolean(EDIT_UNABLE);

        ListView list = (ListView) view.findViewById(R.id.list_view);

        String[] items;
        if (editUnable)
            items = new String[]{getString(R.string.delete)};
        else
            items = new String[]{getString(R.string.edit), getString(R.string.delete)};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (onEditRemoveItem != null)
            switch (position) {
                case 0:
                    onEditRemoveItem.onEdit(this.position);
                    break;
                case 1:
                    onEditRemoveItem.onRemove(this.position);
                    break;

            }
    }

    /**
     * Interface
     */
    public interface OnEditRemoveItem {
        void onEdit(int position);

        void onRemove(int position);
    }

}
