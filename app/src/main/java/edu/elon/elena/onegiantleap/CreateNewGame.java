package edu.elon.elena.onegiantleap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class CreateNewGame extends Activity {
    private EditText cubeName;
    private String color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_game);

        //Edit text for the name of the cube
        cubeName = (EditText) findViewById(R.id.cubeName);
    }

    //On the button press Go! this method launches. It writes the name of the
    //cube as well as the color to a file.
    public void launchNew(View view) {

        String name = cubeName.getText().toString();
        int level = 1;

        //default color
        color = "Blue";

        Context context = getBaseContext();
        PlayerPrefs prefs = new PlayerPrefs();
        prefs.setAll(name, color, level, context);

        //Launch new game
        Intent intent = new Intent(this, GameStory.class);
        startActivity(intent);
    }

}
