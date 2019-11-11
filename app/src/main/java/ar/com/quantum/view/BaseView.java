package ar.com.quantum.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ar.com.quantum.satm.R;

public abstract class BaseView extends AppCompatActivity {

    protected final String INTENT_EQUIPMENT_KEY = "EQUIPMENT";
    protected final String[] TITLES_BY_STEP = {"Selecciona tu Quantum", "Dejanos tu contacto"};

    protected  void setCommonsToolbarTitle(int toolbarId, String title){
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)findViewById(toolbarId);
        toolbar.setTitle(title);
    }

    protected void showInformation(Context context, String title, String message, String possitiveButtonText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(possitiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}
