package ar.com.quantum.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import ar.com.quantum.satm.R;

public class HtmlView extends BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_view);


        TextView newtext = (TextView) findViewById(R.id.htmlTextView);

        try
        {
            //Note here I gave file name with "file:///android_asset/" to get it from assets
            InputStream inputStream = getResources().getAssets().open("html/myFile.html");

            String html = IOUtils.toString(inputStream);

            newtext.setText(Html.fromHtml(html));

            // newtext.setText(Html.fromHtml(getString(R.string.htmltext)));
        }
        catch (IOException exception)
        {
            newtext.setText("Failed loading html.");
        }



    }
}
