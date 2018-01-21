/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

/**
 *.
 * @author jetkeo
 */
public class Player {

    //initializing integers
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private static final int MAXDIR = 4;

    public static int getDir(String direction) {
        switch (direction) {
            case "N":
                return 0;
            case "E":
                return 1;
            case "S":
                return 2;
            case "W":
                return 3;
        }
        //return -1 if the direction string is invalid
        return -1; 
    }

    
    public static int turnRight(int direction) {
        if (direction + 1 < MAXDIR) {
            return direction + 1;
        }
        return 0;
    }

    public static int turnLeft(int direction) {
        if (direction - 1 >= 0) {
            return direction - 1;
        }
        return 3;
    }
}
