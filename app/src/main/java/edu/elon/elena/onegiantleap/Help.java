package edu.elon.elena.onegiantleap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Help extends Activity implements DialogInterface.OnClickListener {

    Button okay_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
