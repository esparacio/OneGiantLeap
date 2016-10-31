package edu.elon.elena.onegiantleap;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LoadGame extends Activity {

    private A_L3D l3d;
    private final String filename = "preferences.txt";
    private int level;
    int[][][] threeDarray = new int[8][8][8];
    private Character aCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);

        //get the player preferences
        PlayerPrefs prefs = new PlayerPrefs();
        Context context = getBaseContext();
        prefs.readFile(context);

        //if there is no save, go to the New Game Screen
        if(!(prefs.getSave())){
            noSave();
            return;
        }

        level = prefs.getLevel();

        //if you finished the game, reset
        if(level>3){
            prefs.setLevel(1, context);
            level = prefs.getLevel();
        }

        //set background based on level
        StoryMaker maker = new StoryMaker();
        LinearLayout layout = (LinearLayout)findViewById(R.id.gamescreen);
        maker.setGameBack(layout,level);

        //reads a file and creates the appropriate background for the level
        LevelCreator creator = new LevelCreator();
        l3d = new A_L3D();

        //create the level
        AssetManager assetManager = getAssets();
        threeDarray = creator.loadLevel(l3d, assetManager,level);

        //creates a new cube character for movement
        aCharacter = new Character(l3d,context,level);
        setArray();

    }

    public void noSave(){
        Intent intent = new Intent(this, CreateNewGame.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void startOver(){
        //Intent intent = new Intent(this, YouDied.class);
       // startActivity(intent);
    }

    //Sets an array in the character class once the level is read
    public void setArray(){
        aCharacter.setArray(threeDarray);
        //setting the start point of the game for the level - this will change if there is a saved game
        aCharacter.setxValue(0);
        aCharacter.setyValue(0);
        aCharacter.setzValue(7);
    }

    //On button press, this moves the cube character up
    public void launchUp(View view){
        aCharacter.moveUp();

    }

    //On button press, this moves the cube character down
    public void launchDown(View view){
        aCharacter.moveDown();

    }

    //On button press, this moves the cube character right
    public void launchRight(View view){
        aCharacter.moveRight();

    }

    //On button press, this moves the cube character left
    public void launchLeft(View view){
        aCharacter.moveLeft();

    }

    //Allows the player to scroll forward through the layers
    public void launchScrollUp(View view){
        aCharacter.scrollUp();

    }


}
