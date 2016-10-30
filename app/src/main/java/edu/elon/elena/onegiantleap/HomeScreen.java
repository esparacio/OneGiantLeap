package edu.elon.elena.onegiantleap;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


/*
* Elena Sparacio (c) 2016
*
* HomeScreen allows a user to load a game or start a new game.
*
* */

public class HomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void launchPlay(View view) {
      //  Intent intent = new Intent(this, LoadGame.class);
      //  startActivity(intent);
    }

    public void launchNew(View view) {
        Intent intent = new Intent(this, CreateNewGame.class);
        startActivity(intent);
    }

}
