package ar.com.quantum.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ar.com.quantum.model.Symptom;
import ar.com.quantum.model.SymptomListAdapter;
import ar.com.quantum.model.Tutorial;
import ar.com.quantum.model.TutorialListAdapter;
import ar.com.quantum.satm.R;

public class TutorialActivity extends BaseActivity {

    private final String TOOL_BAR_TILTE = "Diagnostica tu equipo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_view);
        super.setCommonsToolbarTitle(R.id.tutorialToolbar, TOOL_BAR_TILTE);
        ListView tutorialListView = (ListView)findViewById(R.id.tutorialListView);

        Tutorial t1 = new Tutorial("Eliminar Cache RAM");
        Tutorial t2= new Tutorial("Eliminar Cache RAM 2");
        Tutorial t3 = new Tutorial("Eliminar Cache RAM 3");
        Tutorial t4 = new Tutorial("Eliminar Cache RAM 4");
        Tutorial t5 = new Tutorial("Eliminar Cache RAM 5");
        Tutorial t6 = new Tutorial("Eliminar Cache RAM 6");

        List<Tutorial> tutorialList  = new ArrayList<Tutorial>();
        tutorialList.add(t1);
        tutorialList.add(t2);
        tutorialList.add(t3);
        tutorialList.add(t4);
        tutorialList.add(t5);
        tutorialList.add(t6);
        TutorialListAdapter adapter = new TutorialListAdapter(this,R.layout.tutorial_item_layout, tutorialList);
        tutorialListView.setAdapter(adapter);

    }
}
