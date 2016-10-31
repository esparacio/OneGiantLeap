package edu.elon.elena.onegiantleap;

import android.widget.LinearLayout;
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
    int[] levelTwoBacks = new int[]{R.drawable.story2_1, R.drawable.story2_2, R.drawable.story2_3, R.drawable.storylevel2};
    int[] levelThreeBacks = new int[] {R.drawable.story3_1, R.drawable.story3_2, R.drawable.story3_3, R.drawable.storylevel3};
    int[] endingBacks = new int[] {R.drawable.story_end1, R.drawable.story_end2, R.drawable.story_end3, R.drawable.winscreen};

    /*
    * setBackground() sets the proper part of the story on the screen
    * */
    public void setBackground(RelativeLayout layout, int storyPart, int aLevel){
        this.level = aLevel;
        int [] levelBacks = getArray();
        layout.setBackgroundResource(levelBacks[storyPart]);
    }

    /*
    * setGameBack() sets the proper part of the story on the during gameplay
    * */
    public void setGameBack(LinearLayout layout, int aLevel){
        this.level = aLevel;
        if(level==2){
            layout.setBackgroundResource(R.drawable.level2);
        } else if (level==3){
            layout.setBackgroundResource(R.drawable.level3);
        } else {
            layout.setBackgroundResource(R.drawable.level1);

        }
    }

    /*
    * getArray() returns an array of drawables based upon the level.
    * */
    public int [] getArray(){

        if (level==2){
            return levelTwoBacks;
        } else if (level==3){
            return levelThreeBacks;
        } else if (level >3){
            return endingBacks;
        } else {
            return levelOneBacks;
        }

    }

    /*
    * maxParts returns the number of parts in a given story block.
    * */
    public int maxParts(int aLevel){

        if(level==2){
            return levelTwoBacks.length-1;
        } else if (level==3) {
            return levelThreeBacks.length - 1;
        } else if (level >3){
            return endingBacks.length-1;
        } else return levelOneBacks.length-1;

    }


}
