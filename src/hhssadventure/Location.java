/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author haidj9901
 */
public class Location {

    private ArrayList<Scene> scenes = new ArrayList<Scene>(); //an array list containing the 4 scenes of each location
    private String locationName; //name of the location

    /**
     * Constructor for the location class
     * @param input 
     */
    public Location(Scanner input) {

        locationName = input.nextLine(); //assign first word as the name of the location
        //cycle through every scene of the location and add it to the array list
        for (int x = 0; x < 4; x++) {
            Scene s = new Scene(input);
            scenes.add(s);
        }
    }
/**
 * Get the image from the scene
 * @param direction specify the direction of the current location (specific scene)
 * @return the image from the scene
 */
    public BufferedImage getImage(int direction) {
        return scenes.get(direction).getImage();
    }

    public String getNextLocation(int direction) {
        return scenes.get(direction).getNextLocation();
    }

    public int getNextDirection(int direction) {
        return scenes.get(direction).getNextDirection();
    }

    public boolean isFrontBlocked(int direction) {
        return scenes.get(direction).isFrontBlocked();
    }

    public String getLocationName() {
        return locationName;
    }
}
