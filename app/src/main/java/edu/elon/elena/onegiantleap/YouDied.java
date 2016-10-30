package edu.elon.elena.onegiantleap;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class YouDied extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_died);
    }

    public void launchHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

}
