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

public class ProvinceListAdapter extends ArrayAdapter<String> {

    private Context mContext = null;
    private Integer mResource = null;

    public ProvinceListAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Province province = new Province();
        province.setDescription(getItem(position));
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        return convertView;
    }




}
