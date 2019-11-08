package ar.com.quantum.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.EquipmentListAdapter;
import ar.com.quantum.model.IEquipment;
import ar.com.quantum.presenter.EquipmentPresenter;
import ar.com.quantum.satm.R;

public class EquipmentView extends BaseView implements IEquipment.View {

    private final String TOOL_BAR_TILTE = "Selecciona tu Quantum";

    private ListView equipmentListView;
    private IEquipment.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_view);
        this.setCommonsToolbarTitle(R.id.modelsToolbar, TOOL_BAR_TILTE);
        this.equipmentListView = (ListView)findViewById(R.id.eqipmentListView);
        this.presenter = new EquipmentPresenter(this, this);
        this.presenter.showEquipments();
        this.equipmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent singIn = new Intent(EquipmentView.this, SingInView.class);
               startActivity(singIn);
               finish();
            }
        });
    }

    @Override
    public void showEquipments(List<Equipment> equipmentList) {
        EquipmentListAdapter adapter = new EquipmentListAdapter(this,R.layout.equipment_item_layout, equipmentList);
        this.equipmentListView.setAdapter(adapter);
    }




}
