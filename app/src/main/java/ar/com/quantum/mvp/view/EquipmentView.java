package ar.com.quantum.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.EquipmentListAdapter;
import ar.com.quantum.mvp.interfaces.IEquipment;
import ar.com.quantum.mvp.presenter.EquipmentPresenter;
import ar.com.quantum.satm.R;

public class EquipmentView extends BaseView implements IEquipment.View {

    private final Integer STEP = 0;
    private ListView equipmentListView;
    private IEquipment.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_view);
        this.setCommonsToolbarTitle(R.id.modelsToolbar, TITLES_BY_STEP[STEP]);
        this.equipmentListView = (ListView)findViewById(R.id.eqipmentListView);
        this.presenter = new EquipmentPresenter(this, this);
        this.presenter.showEquipments();
    }

    @Override
    public void showEquipments(List<Equipment> equipmentList) {
        EquipmentListAdapter adapter = new EquipmentListAdapter(this,R.layout.equipment_item_layout, equipmentList);
        this.equipmentListView.setAdapter(adapter);

        this.equipmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Equipment selectedEquipment = (Equipment)parent.getAdapter().getItem(position);
                Intent singIn = new Intent(EquipmentView.this, SingInView.class);
                singIn.putExtra(INTENT_EQUIPMENT_KEY, selectedEquipment);
                startActivity(singIn);
                finish();
            }
        });
    }
}
