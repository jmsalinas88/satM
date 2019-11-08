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

public class EquipmentListAdapter extends ArrayAdapter<Equipment> {

    private Context mContext = null;
    private Integer mResource = null;

    public EquipmentListAdapter(@NonNull Context context, int resource, @NonNull List<Equipment> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get equipment information
        Equipment equipment = new Equipment(getItem(position).getName(), getItem(position).getDescription(), getItem(position).getImage());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        ImageView imageViewModel = (ImageView)convertView.findViewById(R.id.imageViewModel);
        imageViewModel.setImageResource(equipment.getImage());
        TextView textViewModelName = (TextView)convertView.findViewById(R.id.textViewModelName);
        textViewModelName.setText(equipment.getName());
        TextView textViewModelDescription = (TextView)convertView.findViewById(R.id.textViewModelDescription);
        textViewModelDescription.setText(equipment.getDescription());
        return convertView;
    }
}
