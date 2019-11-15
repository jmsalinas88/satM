package ar.com.quantum.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import java.util.List;
import ar.com.quantum.entity.Equipment;
import ar.com.quantum.entity.Province;
import ar.com.quantum.entity.ProvinceListAdapter;
import ar.com.quantum.entity.User;
import ar.com.quantum.mvp.interfaces.ISingIn;
import ar.com.quantum.mvp.presenter.SingInPresenter;
import ar.com.quantum.satm.R;
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
        this.imei.requestFocus();
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
        user.setName(this.name.getText().toString().trim());
        user.setSurname(this.surname.getText().toString().trim());
        user.setEmail(this.email.getText().toString().trim());
        user.setPhoneNumber(this.phoneNumber.getText().toString().trim());
        Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
        equipment.setImei(this.imei.getText().toString().trim());
        Province province = (Province )this.provinces.getSelectedItem();
        user.setProvince(province);
        equipment.setUser(user);
        getIntent().putExtra(INTENT_EQUIPMENT_KEY, equipment);
        this.presenter.performLogin(equipment);
    }

    @Override
    public void showProvinces(List<Province> provincesList) {
        ProvinceListAdapter dataAdapter = new ProvinceListAdapter(this, R.layout.province_item_layout, provincesList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.provinces.setAdapter(dataAdapter);
    }

    @Override
    public void loginValidations(String message) {
        this.showInformation(this, "Información",message, "ACEPTAR");
    }

    @Override
    public void loginSucess() {
        Equipment equipment = (Equipment)getIntent().getSerializableExtra(INTENT_EQUIPMENT_KEY);
        Toast toast = Toast.makeText(getApplicationContext(), "Contacto Registrado!", Toast.LENGTH_SHORT);
        toast.show();
        Intent symptom = new Intent(SingInView.this, FeatureView.class);
        symptom.putExtra(INTENT_EQUIPMENT_KEY, equipment);
        startActivity(symptom);
        finish();
    }

    @Override
    public void loginError() {
        Toast toast = Toast.makeText(getApplicationContext(), "Error, volve a intentar en un rato", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        Intent equipment = new Intent(SingInView.this, EquipmentView.class);
        startActivity(equipment);
        finish();

    }
}
