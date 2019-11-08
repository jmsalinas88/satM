package ar.com.quantum.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.FeatureListAdapter;
import ar.com.quantum.satm.R;

public class FeatureView extends BaseView {

    private final String TOOL_BAR_TILTE = "Diagnostica tu equipo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.feature_view);
        super.setCommonsToolbarTitle(R.id.symptomToolbar,TOOL_BAR_TILTE);

        ListView feactureListView = (ListView)findViewById(R.id.featureListView);


        Feature s1 = new Feature("BATERIA", 0);
        Feature s2 = new Feature("ENCENDIDO", 0);
        Feature s3 = new Feature("PANTALLA", 0);
        Feature s4 = new Feature("RED", 0);
        Feature s5 = new Feature("AUDIO", 0);
        Feature s6 = new Feature("CAMARA", 0);

        List<Feature> featureList  = new ArrayList<Feature>();

        featureList.add(s1);
        featureList.add(s2);
        featureList.add(s3);
        featureList.add(s4);
        featureList.add(s5);
        featureList.add(s6);


        FeatureListAdapter adapter = new FeatureListAdapter(this,R.layout.feature_item_layout, featureList);

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
