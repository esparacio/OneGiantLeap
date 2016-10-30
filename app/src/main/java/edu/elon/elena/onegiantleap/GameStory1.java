package edu.elon.elena.onegiantleap;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

public class GameStory1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_story1);
    }

    public void launchStory2(View view) {

        RelativeLayout layout = (RelativeLayout)findViewById(R.id.storyboard);
        layout.setBackgroundResource(R.drawable.titlescreen);

    }
}