package ar.com.quantum.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Province;
import ar.com.quantum.entity.ProvinceListAdapter;
import ar.com.quantum.entity.User;
import ar.com.quantum.model.ISingIn;
import ar.com.quantum.presenter.SingInPresenter;
import ar.com.quantum.satm.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SingInView extends BaseView implements ISingIn.View{

    private final Integer STEP = 1;
    private ISingIn.Presenter presenter;
    private Spinner provinces;
    private EditText imei;
    private EditText name;
    private EditText surname;
    private EditText email;
    private EditText phoneNumber;
    private Button sinInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin_view);
        this.setCommonsToolbarTitle(R.id.singInToolbar,TITLES_BY_STEP[STEP]);
        this.provinces = (Spinner) findViewById(R.id.provinces);
        this.imei = (EditText)findViewById(R.id.imei);
        this.name = (EditText)findViewById(R.id.name);
        this.surname = (EditText)findViewById(R.id.surname);
        this.email = (EditText)findViewById(R.id.email);
        this.phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        this.sinInButton = (Button) findViewById(R.id.buttonSingIn);
        this.presenter = new SingInPresenter(this, this);
        this.presenter.showProvinces();
        this.sinInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        User user = new User();
        user.setNamne(this.name.getText().toString().trim());
        user.setSurname(this.surname.getText().toString().trim());
        user.setEmail(this.email.getText().toString().trim());
        user.setPhoneNumber(this.phoneNumber.getText().toString().trim());
        Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
        user.setEmei(this.imei.getText().toString().trim());

        Province province = new Province();
        province.setDescription(this.provinces.getSelectedItem().toString());
        user.setProvinceId(1);

        System.out.println(" Equipo: " + equipment.getName());
        System.out.println(" Provincia: " + province.getDescription());

        this.presenter.performLogin(user);
    }

    @Override
    public void showProvinces(List<String> provincesList) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter <String>(this, R.layout.localityitem, provincesList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinces.setAdapter(dataAdapter);
    }

    @Override
    public void loginValidations(String message) {
        this.showInformation(this, "Informacion",message, "ACEPTAR");
    }

    @Override
    public void loginSucess() {
        Toast toast = Toast.makeText(getApplicationContext(), "Contacto Registrado!", Toast.LENGTH_SHORT);
        toast.show();
        Intent symptom = new Intent(SingInView.this, FeatureView.class);
        startActivity(symptom);
        finish();
    }

    @Override
    public void loginError() {
        Toast toast = Toast.makeText(getApplicationContext(), "Error, volve a intentar en un rato", Toast.LENGTH_SHORT);
        toast.show();
    }


}
