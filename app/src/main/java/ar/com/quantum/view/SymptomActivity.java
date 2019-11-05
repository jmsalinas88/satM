package ar.com.quantum.view;

import android.os.Bundle;
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


        Symptom s1 = new Symptom("BATERIA", 0);
        Symptom s2 = new Symptom("ENCENDIDO", 0);
        Symptom s3 = new Symptom("PANTALLA", 0);
        Symptom s4 = new Symptom("RED", 0);
        Symptom s5 = new Symptom("AUDIO", 0);
        Symptom s6 = new Symptom("CAMARA", 0);

        List<Symptom> symptomList  = new ArrayList<Symptom>();

        symptomList.add(s1);
        symptomList.add(s2);
        symptomList.add(s3);
        symptomList.add(s4);
        symptomList.add(s5);
        symptomList.add(s6);


        SymptomListAdapter adapter = new SymptomListAdapter(this,R.layout.symptom_item_layout, symptomList);

        symptomListView.setAdapter(adapter);

    }
}
