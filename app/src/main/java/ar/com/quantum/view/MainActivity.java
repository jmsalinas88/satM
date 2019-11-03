package ar.com.quantum.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import ar.com.quantum.satm.R;

public class MainActivity extends AppCompatActivity {


    private static long WELCOME_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(MainActivity.this, ModelsActivity.class);
                startActivity(welcome);
                finish();
            }
        },  WELCOME_TIMEOUT);

    }
}
