/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

/**
 *
 * @author branc2347
 */
public class Direction {

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    public static final int MAXDIR = 4;

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
        return -1;
    }

    public static int getNextDir(String direction) {
        if (getDir(direction) + 1 < 4)
        {
            return getDir(direction) + 1;
        }
        return 0;
    }
}
