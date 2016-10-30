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
            for(int i= 0; i < 10; i++){
                System.out.println("Create level 3 ya goon!");
            }
        } else {
            layout.setBackgroundResource(R.drawable.level1);

        }
    }

    /*
    * getArray() returns an array of drawables based upon the level.
    * */
    public int [] getArray(){
        if(level==1) {
            return levelOneBacks;
        } else if (level==2){
            return levelTwoBacks;
        }
        return levelOneBacks;
    }

    /*
    * maxParts returns the number of parts in a given story block.
    * */
    public int maxParts(int aLevel){
        if(level==1){
            return levelOneBacks.length-1;
        } else if(level==2){
            return levelTwoBacks.length-1;
        }
        return levelOneBacks.length-1;
    }


}
