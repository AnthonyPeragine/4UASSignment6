/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

/**
 * Class used to converted directions in the form of the strings, "N", "E", "S", "W" to an integer value
 * 
 * @author caius and Jafer
 */
public class Direction {

    //initializing integers compass variables
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private static final int MAXDIR = 4;

    /**
     * Returns the integer value of a direction string in the aforementioned form
     * @param direction the string value of the direction
     * @return the integer value of the direction
     */
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
        return -1; //return -1 if the direction string is invalid
    }

    /**
     * Returns the direction following the direction passed in
     * @param direction the current direction 
     * @return the next direction
     */
    public static int getNextDir(int direction) {
        if (direction + 1 < MAXDIR) {
            return direction + 1;
        }
        return 0;
    }

    /**
     * Returns the direction followed by the direction passed in
     * @param direction the current direction
     * @return the previous direction
     */
    public static int getPrevDir(int direction) {
        if (direction - 1 >= 0) {
            return direction - 1;
        }
        return 3;
    }
}
