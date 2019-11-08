package ar.com.quantum.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import ar.com.quantum.satm.R;

public class FeatureListAdapter extends ArrayAdapter<Feature> {

    private Context mContext = null;
    private Integer mResource = null;

    public FeatureListAdapter(@NonNull Context context, int resource, @NonNull List<Feature> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get symptom information
        Feature feature = new Feature(getItem(position).getDescription(), getItem(position).getImage());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        ImageView imageViewSymptom = (ImageView)convertView.findViewById(R.id.imageViewFeature);
        imageViewSymptom.setImageResource(feature.getImage());
        TextView textViewSymptomDescription = (TextView)convertView.findViewById(R.id.textViewFeatureDescription);
        textViewSymptomDescription.setText(feature.getDescription());
        return convertView;
    }
}
