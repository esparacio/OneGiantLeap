package edu.elon.elena.onegiantleap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

public class GameStory1 extends Activity {

    int storyPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_story1);
        storyPart = 1;
    }


    public void launchNextStory(View view) {

        storyPart++;
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.storyboard);

        if(storyPart==2){
            layout.setBackgroundResource(R.drawable.story2);
        } else if(storyPart==3){
            layout.setBackgroundResource(R.drawable.story3);
        } else if (storyPart==4){
            layout.setBackgroundResource(R.drawable.storylevel1);
        } else if (storyPart>4){
            //Launch Level 1!
            Intent intent = new Intent(this, LoadGame.class);
            startActivity(intent);
        }

    }
}