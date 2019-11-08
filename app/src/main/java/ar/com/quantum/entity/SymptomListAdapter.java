package ar.com.quantum.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import ar.com.quantum.satm.R;

public class SymptomListAdapter extends ArrayAdapter<Symptom> {


    private Context mContext = null;
    private Integer mResource = null;

    public SymptomListAdapter(@NonNull Context context, int resource, @NonNull List<Symptom> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get symptom information
        Symptom symptom = new Symptom(getItem(position).getDescription());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView textViewSymptomDescription = (TextView)convertView.findViewById(R.id.textViewSymptomDescription);
        textViewSymptomDescription.setText(symptom.getDescription());
        return convertView;
    }

}
