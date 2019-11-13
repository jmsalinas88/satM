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
import ar.com.quantum.util.Constants;
import ar.com.quantum.util.Utils;

public class FeatureListAdapter extends ArrayAdapter<Feature> {

    private Context mContext;
    private Integer mResource;

    public FeatureListAdapter(@NonNull Context context, int resource, @NonNull List<Feature> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get symptom information
        Feature feature = new Feature();
        feature.setDescription(getItem(position).getDescription());
        feature.setImage(getItem(position).getImage());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        ImageView imageViewFeature = (ImageView)convertView.findViewById(R.id.imageViewFeature);
        imageViewFeature.setImageBitmap(Utils.getBitmapFromAsset(this.mContext, Constants.FEATURE_ASSET_PATH + feature.getImage()));
        TextView textViewFeatureDescription = (TextView)convertView.findViewById(R.id.textViewFeatureDescription);
        textViewFeatureDescription.setText(feature.getDescription());

        return convertView;
    }
}
