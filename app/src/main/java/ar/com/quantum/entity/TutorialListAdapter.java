package ar.com.quantum.entity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.HtmlCompat;

import java.util.List;

import ar.com.quantum.mvp.view.TutorialView;
import ar.com.quantum.satm.R;

public class TutorialListAdapter  extends ArrayAdapter<Tutorial> {

    private Context mContext = null;
    private Integer mResource = null;

    Dialog myDialog;

    public TutorialListAdapter(@NonNull Context context, int resource, @NonNull List<Tutorial> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get symptom information
        Tutorial tutorial = new Tutorial(getItem(position).getTitle());
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.tutorialCheckBox);
        checkBox.setText(tutorial.getTitle());

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.tutorial_content);

        TextView textView = (TextView)convertView.findViewById(R.id.tutorialTextViewVer);

        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView txtcontent = (TextView) myDialog.findViewById(R.id.tutorialContentTextView);;

                // String htmlText = "<h2>What is Android?</h2>" +
                String htmlText = "" +
                        "<p>Android is an open source and Linux-based <b>Operating System</b> for mobile devices such as smartphones and tablet computers." +
                        "Android was developed by the <i>Open Handset Alliance</i>, led by Google, and other companies.</p>" +
                        "<p>Android offers a unified approach to application development for mobile devices which means developers need only" +
                        "develop for Android, and their applications should be able to run on different devices powered by Android.</p>" +
                        "<p>The first beta version of the Android Software Development Kit (SDK) was released by Google in 2007 whereas " +
                        "the first commercial version, Android 1.0, was released in September 2008.</p>";

              /*htmlText += "<p>Android is an open source and Linux-based <b>Operating System</b> for mobile devices such as smartphones and tablet computers." +
                       "Android was developed by the <i>Open Handset Alliance</i>, led by Google, and other companies.</p>" +
                       "<p>Android offers a unified approach to application development for mobile devices which means developers need only" +
                       "develop for Android, and their applications should be able to run on different devices powered by Android.</p>" +
                       "<p>The first beta version of the Android Software Development Kit (SDK) was released by Google in 2007 whereas " +
                       "the first commercial version, Android 1.0, was released in September 2008.</p>"; */

                txtcontent.setText(HtmlCompat.fromHtml(htmlText, 0));

                TextView txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                int width = ViewGroup.LayoutParams.MATCH_PARENT;
                int height = ViewGroup.LayoutParams.MATCH_PARENT;

                myDialog.getWindow().setLayout(width, height);
                myDialog.show();


            }
        });


        return convertView;
    }
}
