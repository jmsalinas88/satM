package ar.com.quantum.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Tutorial;
import ar.com.quantum.entity.TutorialListAdapter;
import ar.com.quantum.satm.R;

public class TutorialView extends BaseView {

    private final String TOOL_BAR_TILTE = "Tutorial: Verificacion RED MOVIL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_view);
        super.setCommonsToolbarTitle(R.id.tutorialToolbar, TOOL_BAR_TILTE);
        ListView tutorialListView = (ListView)findViewById(R.id.tutorialListView);

        Tutorial t1 = new Tutorial("Este es el item 1");
        Tutorial t2= new Tutorial("Este es el item 2");
        Tutorial t3 = new Tutorial("Este es el item 3");
        Tutorial t4 = new Tutorial("Eliminar Cache RAM 4");
        Tutorial t5 = new Tutorial("Eliminar Cache RAM 5");
        Tutorial t6 = new Tutorial("Eliminar Cache RAM 6");

        List<Tutorial> tutorialList  = new ArrayList<Tutorial>();
        tutorialList.add(t1);
        tutorialList.add(t2);
        //tutorialList.add(t3);
        //tutorialList.add(t4);
        //tutorialList.add(t5);
        //tutorialList.add(t6);
        TutorialListAdapter adapter = new TutorialListAdapter(this,R.layout.tutorial_item_layout, tutorialList);
        tutorialListView.setAdapter(adapter);

        tutorialListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast toast = Toast.makeText(getApplicationContext(), "Ver! !", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

    }
}
