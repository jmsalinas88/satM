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

public class ProvinceListAdapter extends ArrayAdapter<Province> {

    private Context mContext = null;
    private Integer mResource = null;

    public ProvinceListAdapter(@NonNull Context context, int resource, @NonNull List<Province> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    public View initView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Province province = new Province();
        province.setDescription(getItem(position).getDescription());
        province.setId(getItem(position).getId());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView textViewProvince = (TextView)convertView.findViewById(R.id.provinceTextView);
        textViewProvince.setText(province.getDescription());

        return convertView;
    }
}
