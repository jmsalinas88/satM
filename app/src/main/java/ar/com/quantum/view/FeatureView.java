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


        Feature s1 = new Feature();
        s1.setDescription("BATERIA");
        Feature s2 = new Feature();
        s2.setDescription("ENCENDIDO");
        Feature s3 = new Feature();
        s3.setDescription("PANTALLA");
        Feature s4 = new Feature();
        s4.setDescription("RED");
        Feature s5 = new Feature();
        s5.setDescription("AUDIO");
        Feature s6 = new Feature();
        s6.setDescription("CAMARA");

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
