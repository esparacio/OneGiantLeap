package edu.elon.elena.onegiantleap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

public class GameStory extends Activity {

    int storyPart;
    int level;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_story);
        storyPart = 0;
        layout = (RelativeLayout)findViewById(R.id.storyboard);
        Context context = getBaseContext();
        getLevel(context);
    }

    public void getLevel(Context context){

        PlayerPrefs prefs = new PlayerPrefs();
        prefs.readFile(context);
        this.level = prefs.getLevel();

        if(level==1){
            layout.setBackgroundResource(R.drawable.story1);
        } else if (level==2){
            layout.setBackgroundResource(R.drawable.story1);
        } else if (level==3){
            layout.setBackgroundResource(R.drawable.story1);
        } else if (level > 3){
            System.out.println("You won the game! We will do stuff for this.");
        }
    }

    public void launchNextStory(View view) {

        storyPart++;
        StoryMaker maker = new StoryMaker();
        int maxStory = maker.maxParts(level);

        if (storyPart>maxStory){
            //Launch next level!
            Intent intent = new Intent(this, LoadGame.class);
            startActivity(intent);
        } else {
            maker.setBackground(layout, storyPart, level);
        }



    }
}