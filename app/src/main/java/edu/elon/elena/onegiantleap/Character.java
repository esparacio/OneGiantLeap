package edu.elon.elena.onegiantleap;

import android.content.Context;
import android.content.Intent;


/**
 * Elena Sparacio (c) 2016
 *
 * Character is a class that allows the user to move the character
 * through the 3Darray that represents the background on the cube.
 *
 */
public class Character {

    private A_L3D l3d;
    public int xValue;
    public int yValue;
    public int zValue;
    public int level;
    public int[][][] threeDarray;
    public int[][][] array2;
    public int prevSpace;
    public final int COL = 16711680;

    private CubeAnimations cubeAnimate;

    public Context context;


    public Character(A_L3D aL3d, Context context, int aLevel){
        this.l3d = aL3d;
        this.context = context;
        this.level = aLevel;
        this.cubeAnimate = new CubeAnimations();

    }
    public Character(int xValue, int yValue, int zValue, int[][][] threeDArray, int aLevel) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.zValue = zValue;
        this.level = aLevel;
        this.threeDarray = threeDArray;
        this.cubeAnimate = new CubeAnimations();

    }

    //sets an array at the beginning of the level. Sets prevSpace (the previous space)
    //to equal the color of the cube (currently red, will change).
    public void setArray(int [][][] threeDarray){
        this.threeDarray = threeDarray;
        //value of a platform (assuming array is created at the start of the game)
        prevSpace = 660818;
    }

    //sets the x value of the character in the array
    public void setxValue(int xValue){
        this.xValue = xValue;
    }

    //sets the y value of the character in the array
    public void setyValue(int yValue){
        this.yValue = yValue;
    }

    //sets the z value of the character in the array
    public void setzValue(int zValue){
        this.zValue = zValue;
    }

    //gets the x value of the character in the array
    public int getxValue(){
        return xValue;
    }

    //gets the y value of the character in the array
    public int getyValue(){
        return yValue;
    }

    //gets the z value of the character in the array
    public int getzValue(){
        return zValue;
    }

    //gets the value in the previous space, or the space the
    //character was in before moving - returns a color
    public int getPrevSpace(){ return prevSpace; }

    //sets the value in the previous space
    public void setPrevSpace(int prevSpace){
        this.prevSpace = prevSpace;
    }

    public void checkWin(){

        //if you land on the win space, launch the win activity
        if(prevSpace==0x4f1212){

           cubeAnimate.winAnimation(l3d);

            //level up!
            PlayerPrefs prefs = new PlayerPrefs();
            int newLevel = prefs.getLevel() + 1;
            prefs.setLevel(newLevel, context);

            //start the next level
            Intent i1 = new Intent (context, GameStory.class);
            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i1);
        }
    }


    //When the cube dies...
    public void youDied(){

        cubeAnimate.deathAnimation(l3d);

        //launch the "You Died" screen
        Intent i1 = new Intent (context, YouDied.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i1);


    }


    //allows the user to move up in the game. Updates all the values of the
    //character's location, and previous space. Accounts for teleporting
    //as well.
    public void moveUp(){

        //gets current values
        int x = this.xValue;
        int y = this.yValue;
        int z = this.zValue;

        System.out.println("Platform? "+threeDarray[x][y+1][z]);

        //Allows movement as long as it is within the constraints of the
        //cube
        if(y<=6) {

            //store the next character location
            int aboveSpace = threeDarray[x][y + 1][z];

            //only moves if the aboveSpace isn't air
            if(!(aboveSpace==0||aboveSpace==5921370)) {
                //move character in array
                threeDarray[x][y + 1][z] = COL;
                //fill character's previous location with the old value
                threeDarray[x][y][z] = prevSpace;
                //change character color and former space
                l3d.setVoxel(x, (y + 1), z, COL);
                l3d.setVoxel(x, y, z, prevSpace);

                //store the current location of the character
                setPrevSpace(aboveSpace);
                //reset character location
                setyValue(y + 1);
                if(aboveSpace==5688359||aboveSpace==5688356){
                    teleport(aboveSpace,getxValue(),getyValue());
                }
                checkWin();

            }
            else{
                youDied();
            }


        }
        else{
            System.out.println("Reached the top");
        }

    }

    //allows the user to move down in the game. Updates all the values of the
    //character's location, and previous space. Accounts for teleporting
    //as well.
    public void moveDown(){

        //gets the location
        int x = this.xValue;
        int y = this.yValue;
        int z = this.zValue;

        //Allows movement as long as within constraints of the cube
        if(y>=1) {
            //store the next character location
            int belowSpace = threeDarray[x][y - 1][z];
            if(!(belowSpace==0||belowSpace==5921370)) {
                //move character in array
                threeDarray[x][y - 1][z] = COL;
                //fill character's previous location with the old value
                threeDarray[x][y][z] = prevSpace;
                //change character color and former space
                l3d.setVoxel(x, (y - 1), z, COL);
                l3d.setVoxel(x, y, z, prevSpace);
                //store the current location of the character
                setPrevSpace(belowSpace);
                //reset character location
                setyValue(y - 1);
                checkWin();


            }
            else{
                youDied();
            }
        }
        else{
            System.out.println("Reached the bottom");
        }

    }

    //allows the user to move right in the game. Updates all the values of the
    //character's location, and previous space. Accounts for teleporting
    //as well.
    public void moveRight(){

        //gets location
        int x = this.xValue;
        int y = this.yValue;
        int z = this.zValue;

        //allows user to move only within constraints of the cube
        if(x<=6) {
            //store the next character location
            int rightSpace = threeDarray[x+1][y][z];
            if(!(rightSpace==0||rightSpace==5921370)) {
                //move character in array
                threeDarray[x + 1][y][z] = COL;
                //fill character's previous location with the old value
                threeDarray[x][y][z] = prevSpace;
                //change character color and former space
                l3d.setVoxel((x + 1), y, z, COL);
                l3d.setVoxel(x, y, z, prevSpace);
                //store the current location of the character
                setPrevSpace(rightSpace);
                //reset character location
                setxValue(x + 1);
                checkWin();



            }
            else{
                youDied();
            }
        }
        else{
            System.out.println("Reached the rightmost");
        }

    }

    //allows the user to move left in the game. Updates all the values of the
    //character's location, and previous space. Accounts for teleporting
    //as well.
    public void moveLeft(){
        //gets current location
        int x = this.xValue;
        int y = this.yValue;
        int z = this.zValue;

        //allows users to move only in range of cube
        if(x>=1) {
            //store the next character location
            int leftSpace = threeDarray[x-1][y][z];

            if(!(leftSpace==0||leftSpace==5921370)) {
                //move character in array
                threeDarray[x - 1][y][z] = COL;
                //fill character's previous location with the old value
                threeDarray[x][y][z] = prevSpace;
                //change character color and former space
                l3d.setVoxel((x - 1), y, z, COL);
                l3d.setVoxel(x, y, z, prevSpace);
                //store the current location of the character
                setPrevSpace(leftSpace);
                //reset character location
                setxValue(x - 1);
                checkWin();

            }
            else{
                youDied();
            }
        }
        else{
            System.out.println("Reached the leftmost");
        }

    }


    //Teleporters the user if they land on a teleporter spcae

    public void teleport(int space, int prevX, int prevY){

        //this method is long and complicated, having variables for teleporter
        //locations may be better - but this works for now. It searches through
        //the layer (only in 2 dimensions, as teleporters don't work through layers)
        //and finds the corresponding teleport landing location. It then moves
        //the user there.

        for(int e=0;e<8;e++) {
            for (int j = 0; j < 8; j++) {
                int output = threeDarray[e][j][getzValue()];
                if(space==5688359&&output==5688358) {
                    setxValue(e);
                    setyValue(j);
                    setPrevSpace(space);
                    threeDarray[prevX][prevY][getzValue()] = prevSpace;
                    l3d.setVoxel(e, j, getzValue(), COL);
                    l3d.setVoxel(prevX, prevY, getzValue(), space);
                }
                else if(space==5688356&&output==5688357){
                    setxValue(e);
                    setyValue(j);
                    setPrevSpace(space);
                    threeDarray[prevX][prevY][getzValue()] = prevSpace;
                    l3d.setVoxel(e, j, getzValue(), COL);
                    l3d.setVoxel(prevX, prevY, getzValue(), space);
                }
                }
            }

    }



    //allows the user to move through a layer in the game. Updates all the values of the
    //character's location, and previous space.

    public void scrollUp() {

        //gets current location
        int x = this.xValue;
        int y = this.yValue;
        int z = this.zValue;

        int backSpace = threeDarray[x][y][z-1];

        if (!(backSpace == 0 || backSpace == 5921370)) {

            array2 = new int[8][8][8];
            threeDarray[x][y][z] = prevSpace;


            for (int e = 0; e < 8; e++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {

                        int output = threeDarray[e][j][k];

                        //move forward if not front layer
                        if (!(k == 7)) {
                            array2[e][j][k + 1] = output;
                        }
                        //move the front layer backwards
                        if (k == 7) {

                            //For level 1, the back-most layer is layer 5 in the array
                            int backLayer = 5;

                            //change accordingly
                            if(level==2){
                                backLayer = 3;
                            } else if (level==3){
                                backLayer = 0;
                            }

                            array2[e][j][backLayer] = output;
                        }
                    }
                }
            }


            l3d.setCube(array2);

            //make character stay where he is
            l3d.setVoxel(getxValue(), getyValue(), getzValue(), COL);
            //set the previous space
            prevSpace = backSpace;

            checkWin();
            //update the cube and reset the array
            threeDarray = array2;


        }
        else{
            youDied();

        }
    }



}



