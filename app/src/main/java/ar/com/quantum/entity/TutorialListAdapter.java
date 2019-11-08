package ar.com.quantum.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ar.com.quantum.satm.R;

public class TutorialListAdapter  extends ArrayAdapter<Tutorial> {

    private Context mContext = null;
    private Integer mResource = null;

    public TutorialListAdapter(@NonNull Context context, int resource, @NonNull List<Tutorial> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get symptom information
        Tutorial tutorial = new Tutorial(getItem(position).getTitle());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.tutorialCheckBox);
        checkBox.setText(tutorial.getTitle());
        return convertView;
    }
}
