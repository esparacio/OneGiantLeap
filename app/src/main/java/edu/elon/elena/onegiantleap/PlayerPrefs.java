package edu.elon.elena.onegiantleap;

import android.content.Context;
import android.content.Intent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Elena Sparacio (c) 2016
 *
 * PlayerPrefs is a class that stores the player
 * name, color, and level. It also provides helpful utilities
 * for reading and writing to the player preferences file.
 *
 */
public class PlayerPrefs {

    private String filename = "preferences.txt";
    private String userName;
    private String color;
    private int level;
    private boolean didSave;

    /*
    * getSave() returns a boolean representing if the player
    * created a game or not
    * */

    public boolean getSave(){
        return this.didSave;
    }


    /*
    * getColor() returns a String representing the player
    * color
    * */

    public String getColor(){
        return this.color;
    }

    /*
    * setColor() takes a string and a context and can be used by
    * activities to change or create the player color.
    * */

    public void setColor(String aColor, Context context){
        this.color = aColor;
        writeFile(context);
    }

    /*
    * getLevel() returns an int representing the player
    * level
    * */

    public int getLevel(){
        return this.level;
    }

    /*
    * setLevel() takes an int and a context and can be used by
    * activities to change or create the player level.
    * */

    public void setLevel(int aLevel, Context context){
        this.level = aLevel;
        writeFile(context);
    }


     /*
    * getUserName() returns a String representing the player
    * name
    * */

    public String getUserName(){
        return this.userName;
    }

    /*
    * setAll takes all the parameters and writes to the file. This is called
    * upon new player creation.
    * */

    public void setAll(String aName, String aColor, int aLevel, Context context){
        this.userName = aName;
        this.color = aColor;
        this.level = aLevel;
        writeFile(context);
    }

    public void readFile(Context context){

        BufferedReader reader = null;

        try {
            InputStream in = context.openFileInput(filename);
            Scanner scanner = new Scanner(new InputStreamReader(in));
            scanner.useDelimiter("~");
            userName = scanner.next();
            color = scanner.next();
            String levelNum = scanner.next();
            level = Integer.parseInt(levelNum);
            didSave = true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e1){
            //no one saved, so alert the load class of this so it can relaunch the new game screen
            didSave = false;
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    * writeFile() is a utility method for writing to the preferences
    * file. It takes the context from the particular activity and
    * writes the file with the information stored in this class.
    *
    * */

    public void writeFile(Context context){
        Writer writer = null;

        try {
            OutputStream out = context.openFileOutput(filename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(userName + "~" + color + "~" + level);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
