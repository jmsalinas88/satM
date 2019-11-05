package ar.com.quantum.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.satm.R;

public class SingInActivity extends BaseActivity implements OnItemSelectedListener {

    private final String TOOL_BAR_TILTE = "Dejanos tu contacto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singinactivity_view);
        this.setCommonsToolbarTitle(R.id.singInToolbar,TOOL_BAR_TILTE);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();

        categories.add("Ciudad Autonoma de Buenos Aires");
        categories.add("Alberti");
        categories.add("Villa Maria");
        categories.add("Claypole");
        categories.add("Jose Marmol");
        categories.add("Longchamps");
        categories.add("Rafael Calzada");
        categories.add("Avellaneda");
        categories.add("Crucesita");
        categories.add("Sarandi");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter <String>(this, R.layout.localityitem, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        final Button button = (Button) findViewById(R.id.buttonIngresar);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent symptom = new Intent(SingInActivity.this, SymptomActivity.class);
                startActivity(symptom);
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
