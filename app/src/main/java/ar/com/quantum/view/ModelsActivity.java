package ar.com.quantum.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.model.Equipment;
import ar.com.quantum.model.EquipmentListAdapter;
import ar.com.quantum.satm.R;

public class ModelsActivity extends BaseActivity {

    private final String TOOL_BAR_TILTE = "Selecciona tu Quantum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.models_view);
        this.setCommonsToolbarTitle(R.id.modelsToolbar, TOOL_BAR_TILTE);

        ListView modelsListView = (ListView)findViewById(R.id.modelListView);
        Equipment qfit = new Equipment("Quantum Fit", "--- Quantum Fit", R.drawable.q_fit);
        Equipment qM = new Equipment("Quantum M", "--- Quantum M", R.drawable.q_m);
        Equipment qMini = new Equipment("Quantum Mini", "--- Quantum Mini", R.drawable.q_mini);
        Equipment qV = new Equipment("Quantum V", "--- Quantum V", R.drawable.q_m);
        Equipment qYou = new Equipment("Quantum You", "--- Quantum You", R.drawable.q_you);

        List<Equipment> equipmentList  = new ArrayList<Equipment>();
        equipmentList.add(qfit);
        equipmentList.add(qM);
        equipmentList.add(qMini);
        equipmentList.add(qV);
        equipmentList.add(qYou);
        EquipmentListAdapter adapter = new EquipmentListAdapter(this,R.layout.model_item_layout, equipmentList);
        modelsListView.setAdapter(adapter);

        modelsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent singIn = new Intent(ModelsActivity.this, SingInActivity.class);
                startActivity(singIn);
                finish();

            }
        });
    }

}
