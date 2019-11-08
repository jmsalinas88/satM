package ar.com.quantum.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Feacture;
import ar.com.quantum.entity.FeactureListAdapter;
import ar.com.quantum.satm.R;

public class FeatureView extends BaseView {

    private final String TOOL_BAR_TILTE = "Diagnostica tu equipo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.feature_view);
        super.setCommonsToolbarTitle(R.id.symptomToolbar,TOOL_BAR_TILTE);

        ListView feactureListView = (ListView)findViewById(R.id.featureListView);


        Feacture s1 = new Feacture("BATERIA", 0);
        Feacture s2 = new Feacture("ENCENDIDO", 0);
        Feacture s3 = new Feacture("PANTALLA", 0);
        Feacture s4 = new Feacture("RED", 0);
        Feacture s5 = new Feacture("AUDIO", 0);
        Feacture s6 = new Feacture("CAMARA", 0);

        List<Feacture> featureList  = new ArrayList<Feacture>();

        featureList.add(s1);
        featureList.add(s2);
        featureList.add(s3);
        featureList.add(s4);
        featureList.add(s5);
        featureList.add(s6);


        FeactureListAdapter adapter = new FeactureListAdapter(this,R.layout.feature_item_layout, featureList);

        feactureListView.setAdapter(adapter);


        feactureListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent singIn = new Intent(FeatureView.this, SymptomView.class);
                startActivity(singIn);
                finish();

            }
        });

    }
}
