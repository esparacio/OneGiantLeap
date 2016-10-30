package edu.elon.elena.onegiantleap;

import android.widget.RelativeLayout;

/**
 * Elena Sparacio (c) 2016
 *
 * StoryMaker is a class that helps display the correct
 * backgrounds during the storytelling part of the animation.
 * It also facilitates the animation on the cube
 *
 */
public class StoryMaker {

    private int level;
    int[] levelOneBacks = new int[]{R.drawable.story1, R.drawable.story2, R.drawable.story3, R.drawable.storylevel1};

    /*
    * setBackground() sets the proper part of the story on the screen
    * */
    public void setBackground(RelativeLayout layout, int storyPart, int aLevel){
        this.level = aLevel;
        int [] levelBacks = getArray();
        layout.setBackgroundResource(levelBacks[storyPart]);
    }

    /*
    * getArray() returns an array of drawables based upon the level.
    * */
    public int [] getArray(){
        if(level==1){
            return levelOneBacks;
        }
        return levelOneBacks;
    }

    /*
    * maxParts returns the number of parts in a given story block.
    * */
    public int maxParts(int aLevel){
        if(level==1){
            return levelOneBacks.length-1;
        }
        return levelOneBacks.length-1;
    }


}
