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
import ar.com.quantum.model.Symptom;
import ar.com.quantum.model.SymptomListAdapter;
import ar.com.quantum.satm.R;

public class SymptomActivity extends BaseActivity {

    private final String TOOL_BAR_TILTE = "Diagnostica tu equipo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_view);
        super.setCommonsToolbarTitle(R.id.symptomToolbar,TOOL_BAR_TILTE);

        ListView symptomListView = (ListView)findViewById(R.id.symptomListView);
        Symptom s1 = new Symptom("DURACION DE BATERIA");
        Symptom s2 = new Symptom("BATERIA NO CARGA");
        Symptom s3 = new Symptom("BATERIA HINCHADA");

        List<Symptom> symptomList  = new ArrayList<Symptom>();
        symptomList.add(s1);
        symptomList.add(s2);
        symptomList.add(s3);

        SymptomListAdapter adapter = new SymptomListAdapter(this,R.layout.symptom_item_layout, symptomList);

        symptomListView.setAdapter(adapter);


        symptomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent singIn = new Intent(SymptomActivity.this, TutorialActivity.class);
                startActivity(singIn);
                finish();

            }
        });

    }
}
