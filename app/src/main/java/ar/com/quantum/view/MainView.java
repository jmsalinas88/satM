package ar.com.quantum.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ar.com.quantum.satm.R;

public class MainView extends BaseView {

    private static long WELCOME_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(MainView.this, EquipmentView.class);
                startActivity(welcome);
                finish();
            }
        },  WELCOME_TIMEOUT);

    }
}
