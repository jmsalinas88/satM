package ar.com.quantum.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.Symptom;
import ar.com.quantum.entity.SymptomListAdapter;
import ar.com.quantum.mvp.interfaces.ISymptom;
import ar.com.quantum.mvp.presenter.SymptomPresenter;
import ar.com.quantum.satm.R;

public class SymptomView extends BaseView implements ISymptom.View{

    private final String TOOL_BAR_TILTE = "Diagnostica tu equipo";
    private ISymptom.Presenter presenter;
    private ListView symptomListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptom_view);
        super.setCommonsToolbarTitle(R.id.symptomToolbar,TOOL_BAR_TILTE);
        this.symptomListView = (ListView)findViewById(R.id.symptomListView);
        this.presenter = new SymptomPresenter(this, this);

        Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
        Feature feature = equipment.getFeatures().get(0);

        this.presenter.showSymptomList(feature);
    }

    @Override
    public void showSymptomList(List<Symptom> symptomList) {

        SymptomListAdapter adapter = new SymptomListAdapter(this,R.layout.symptom_item_layout, symptomList);
        this.symptomListView.setAdapter(adapter);
        this.symptomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // showInformation(this, "Informacion", "En construccion", "ACEPTAR");
                /*Intent singIn = new Intent(SymptomView.this, QuestionView.class);
                startActivity(singIn);
                finish();*/

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent symptom = new Intent(SymptomView.this, FeatureView.class);
        Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
        symptom.putExtra(INTENT_EQUIPMENT_KEY, equipment);
        startActivity(symptom);
        finish();

    }
}
