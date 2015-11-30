/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Location class that contains four different scenes based on each direction
 *
 * @author caius and Jafer
 */
public class Location {

    private ArrayList<Scene> scenes = new ArrayList<Scene>(); //an array list containing the 4 scenes of each location
    private String locationName; //name of the location

    /**
     * Constructor for the location class
     *
     * @param input the scanner used to retrieve location information
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
     *
     * @param direction specify the direction of the current location (specific
     * scene)
     * @return the image from the scene
     */
    public BufferedImage getImage(int direction) {
        return scenes.get(direction).getImage();
    }

    /**
     * Get the next location based on the direction passed in
     *
     * @param direction the current direction we're facing
     * @return the name of the next locationF
     */
    public String getNextLocation(int direction) {
        return scenes.get(direction).getNextLocation();
    }

    /**
     * Get the next direction based on the current direction
     *
     * @param direction the current direction
     * @return the direction of the next location
     */
    public int getNextDirection(int direction) {
        return scenes.get(direction).getNextDirection();
    }

    /**
     * Check if the we can move forward
     *
     * @param direction the direction we're facing
     * @return whether or not the front is blocked
     */
    public boolean isFrontBlocked(int direction) {
        return scenes.get(direction).isFrontBlocked();
    }

    /**
     * Get the name of the location
     *
     * @return location name
     */
    public String getLocationName() {
        return locationName;
    }
}
