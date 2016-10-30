package edu.elon.elena.onegiantleap;

import static android.os.SystemClock.sleep;

/**
 * Created by ElenaSparacio on 10/20/16.
 */
public class CubeAnimations {

    public void deathAnimation(A_L3D l3d){

        //fills the cube with blue
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 8; z++) {
                    l3d.setVoxel(x, y, z, 660818);
                }
            }
        }

        //pauses for the animation
        sleep(200);
        int time = 0;
        int yVal = 7;
        int yVal2 = 8;

        //loop to make it slowly turn black
        while(time < 8) {
            for (int x = 0; x < 8; x++) {
                for (int y = yVal; y < yVal2; y++) {
                    for (int z = 0; z < 8; z++) {
                        l3d.setVoxel(x, y, z, 0);
                    }
                }
            }
            yVal--;
            yVal2--;
            time++;
            sleep(200);
        }

        l3d.stop();
    }

    public void winAnimation(A_L3D l3d){

        //fills the cube with black
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 8; z++) {
                    l3d.setVoxel(x, y, z, 0);
                }
            }
        }

        //pauses for the animation
        sleep(200);


        //get a cubie
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 8; z++) {
                    l3d.setVoxel(x, y, z, 660818);
                }
            }
        }

        //eye 1
        l3d.setVoxel(1,6,7,0xFCFF33);
        l3d.setVoxel(2,6,7,0xFCFF33);
        l3d.setVoxel(1,5,7,0xFCFF33);
        l3d.setVoxel(2,5,7,0xFCFF33);

        //eye 2
        l3d.setVoxel(5,6,7,0xFCFF33);
        l3d.setVoxel(6,6,7,0xFCFF33);
        l3d.setVoxel(5,5,7,0xFCFF33);
        l3d.setVoxel(6, 5, 7, 0xFCFF33);

        //small smile
        l3d.setVoxel(3,0,7,0xFCFF33);
        l3d.setVoxel(4, 0, 7, 0xFCFF33);

        //smile bigger :) -> :D
        sleep(400);
        l3d.setVoxel(2, 0, 7, 0xFCFF33);
        l3d.setVoxel(5, 0, 7, 0xFCFF33);

        sleep(200);
        l3d.setVoxel(1, 1, 7, 0xFCFF33);
        l3d.setVoxel(6, 1, 7, 0xFCFF33);

        sleep(200);
        l3d.setVoxel(0, 2, 7, 0xFCFF33);
        l3d.setVoxel(7, 2, 7, 0xFCFF33);

        sleep(200);
        l3d.setVoxel(2, 1, 7, 0xFCFF33);
        l3d.setVoxel(3, 1, 7, 0xFCFF33);
        l3d.setVoxel(4, 1, 7, 0xFCFF33);
        l3d.setVoxel(5, 1, 7, 0xFCFF33);

        sleep(200);
        l3d.setVoxel(1, 2, 7, 0xFCFF33);
        l3d.setVoxel(2, 2, 7, 0xFCFF33);
        l3d.setVoxel(3, 2, 7, 0xFCFF33);
        l3d.setVoxel(4, 2, 7, 0xFCFF33);
        l3d.setVoxel(5, 2, 7, 0xFCFF33);
        l3d.setVoxel(6, 2, 7, 0xFCFF33);

        //make eye 1 widen
        l3d.setVoxel(0 ,7 ,7 ,0xFCFF33);
        l3d.setVoxel(0 ,6 ,7 ,0xFCFF33);
        l3d.setVoxel(0 ,5 ,7 ,0xFCFF33);
        l3d.setVoxel(0 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(1 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(2 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(3 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(4 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(4 ,5 ,7 ,0xFCFF33);
        l3d.setVoxel(4 ,6 ,7 ,0xFCFF33);
        l3d.setVoxel(4 ,7 ,7 ,0xFCFF33);
        l3d.setVoxel(3 ,7 ,7 ,0xFCFF33);
        l3d.setVoxel(2 ,7 ,7 ,0xFCFF33);
        l3d.setVoxel(1 ,7 ,7 ,0xFCFF33);

        //make eye 2 widen
        l3d.setVoxel(4 ,7 ,7 ,0xFCFF33);
        l3d.setVoxel(4 ,6 ,7 ,0xFCFF33);
        l3d.setVoxel(4 ,5 ,7 ,0xFCFF33);
        l3d.setVoxel(4 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(5 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(6 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(7 ,4 ,7 ,0xFCFF33);
        l3d.setVoxel(7 ,5 ,7 ,0xFCFF33);
        l3d.setVoxel(7 ,6 ,7 ,0xFCFF33);
        l3d.setVoxel(7 ,7 ,7 ,0xFCFF33);
        l3d.setVoxel(6 ,7 ,7 ,0xFCFF33);
        l3d.setVoxel(5 ,7 ,7 ,0xFCFF33);

        //set pupils
        //eye 1
        l3d.setVoxel(1,6,7,0x3FFF33);
        l3d.setVoxel(2,6,7,0x3FFF33);
        l3d.setVoxel(1,5,7,0x3FFF33);
        l3d.setVoxel(2,5,7,0x3FFF33);

        //eye 2
        l3d.setVoxel(5,6,7,0x3FFF33);
        l3d.setVoxel(6,6,7,0x3FFF33);
        l3d.setVoxel(5,5,7,0x3FFF33);
        l3d.setVoxel(6,5,7,0x3FFF33);



    }
}
