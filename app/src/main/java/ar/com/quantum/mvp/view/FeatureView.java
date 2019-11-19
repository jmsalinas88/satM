package ar.com.quantum.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.FeatureListAdapter;
import ar.com.quantum.mvp.interfaces.IFeature;
import ar.com.quantum.mvp.presenter.FeaturePresenter;
import ar.com.quantum.satm.R;

public class FeatureView extends BaseView implements IFeature.View {

    private final String TOOL_BAR_TILTE = "Diagnostica tu equipo";
    private ListView featureListView;
    private IFeature.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feature_view);
        super.setCommonsToolbarTitle(R.id.symptomToolbar,TOOL_BAR_TILTE);
        this.featureListView = (ListView)findViewById(R.id.featureListView);
        this.presenter = new FeaturePresenter(this, this);
        Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
        this.presenter.showEquipmentFeatureList(equipment.getId());
    }

    @Override
    public void showEquipmentFeatureList(List<Feature> featureList) {

        FeatureListAdapter adapter = new FeatureListAdapter(this,R.layout.feature_item_layout, featureList);
        this.featureListView.setAdapter(adapter);
        this.featureListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Feature selectedFeature = (Feature) parent.getAdapter().getItem(position);
                Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
                equipment.addFeature(selectedFeature);
                Intent singIn = new Intent(FeatureView.this, SymptomView.class);
                singIn.putExtra(INTENT_EQUIPMENT_KEY, equipment);
                singIn.putExtra(INTENT_SELECTED_FEATURE_KEY, selectedFeature);
                startActivity(singIn);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent singIn = new Intent(FeatureView.this, SingInView.class);
        Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
        singIn.putExtra(INTENT_EQUIPMENT_KEY, equipment);
        startActivity(singIn);
        finish();

    }
}
