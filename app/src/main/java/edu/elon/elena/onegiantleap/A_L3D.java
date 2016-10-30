package edu.elon.elena.onegiantleap;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Joel Hollingsworth (c) 2016
 *
 * A_L3D is a class that connects the cube with the phone, and
 * has methods to update the cube.
 *
 */
public class A_L3D {

    private final String IP_ADDRESS = "192.168.1.138";
    private final int PORT = 2222;

    protected final int SIDE = 8;

    // for sending data to the cube
    private InetAddress cubeAddress = null;
    private DatagramSocket socket;

    protected int[][][] cube;
    byte[] data=new byte[SIDE*SIDE*SIDE];

    // thread that continually updates the cube
    private CubeUpdate cubeUpdateThread;


    public A_L3D() {

        // create the cube model
        cube = new int[SIDE][SIDE][SIDE];

        // create a connection to the cube
        try {
            cubeAddress = InetAddress.getByName(IP_ADDRESS);
            socket = new DatagramSocket();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // setup the update thread (and start it)
        cubeUpdateThread = new CubeUpdate();
        cubeUpdateThread.start();
    }

    public void stop() {
        // nicely exit the thread
        cubeUpdateThread.isRunning = false;
    }

    // change one voxel
    public void setVoxel(int x, int y, int z, int col) {
        if ((x >= 0) && (x < SIDE))
            if ((y >= 0) && (y < SIDE))
                if ((z >= 0) && (z < SIDE))
                    cube[x][y][z] = col;
    }

    public void setVoxel(double x, double y, double z, int col) {
        setVoxel((int) x, (int) y, (int) z, col);
    }

    public void setCube(int [][][] cube) {
        this.cube = cube;
    }

    public int [][][] getCube() {
        return this.cube;
    }

    private void serializeCube(int[][][] cube)
    {
        for (int z=0; z<cube[0][0].length; z++)
            for (int y=0; y<cube[0].length; y++)
                for (int x=0; x<cube.length; x++)
                {
                    int index=z*cube.length*cube[0].length+y*cube.length+x;
                    data[index]=colorByte(cube[x][y][z]);
                }
    }

    public byte colorByte(int col)
    {
        return (byte)(red(col)&0xE0 | (green(col)&0xE0)>>3 | (blue(col)&0xC0)>>6);
    }

    public int red(int col)
    {
        return((col>>16)&0xFF);
    }

    public int green(int col)
    {
        return((col>>8)&0xFF);
    }

    public int blue(int col)
    {
        return(col&0xFF);
    }

    /*
    public void update() {
        new SendDatagram().execute();
    }

    private class SendDatagram extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            // prepare the data for sending
            byte [] data = serializeCube(cube);

            // send the data to the cube
            try {
                DatagramPacket p = new DatagramPacket(data, data.length, cubeAddress, PORT);
                socket.send(p);
                System.out.println("Sent datagram to " + IP_ADDRESS + ":" + PORT);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    */

    private class CubeUpdate extends Thread {

        private final int RATE_MS = 100;    // update rate in milliseconds
        private long triggerTime;
        protected boolean isRunning;

        public CubeUpdate() {
            triggerTime = System.currentTimeMillis() + RATE_MS;
            isRunning = false;
        }

        @Override
        public void run() {
            isRunning = true;

            while (isRunning) {

                // prepare the data for sending
                serializeCube(cube);

                // prepare and send a new packet
                DatagramPacket p = new DatagramPacket(data, data.length, cubeAddress, PORT);
                try {
                    socket.send(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // how much time to wait until the next update
                long diff = triggerTime - System.currentTimeMillis();
                if (diff > 0) try {
                    Thread.sleep(diff);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // when to send the next update
                triggerTime = System.currentTimeMillis() + RATE_MS;
            }
        }
    }
}