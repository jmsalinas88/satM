package ar.com.quantum.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ar.com.quantum.satm.R;

public abstract  class BaseActivity extends AppCompatActivity {

    protected  void setCommonsToolbarTitle(int toolbarId, String title){
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)findViewById(toolbarId);
        toolbar.setTitle(title);
    }

}
