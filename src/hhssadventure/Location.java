/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *.
 * @author peraa0837
 */
public class Location {
    //an array list containing the 4 directions of each location
    private ArrayList<Image> image = new ArrayList<Image>();
    //name of the location
    private String Name; 

    //constuctor
    public Location(Scanner input) {
        //first word is name of the location
        Name = input.nextLine(); 

        //go through every direction of the location and add it to the array list
        for (int x = 0; x < 4; x++) {
            Image s = new Image(input);
            image.add(s);
        }
    }

    public BufferedImage getImage(int direction) {
        return image.get(direction).getImage();
    }

    public String getNextLocation(int direction) {
        return image.get(direction).getNextLocation();
    }

    public int getNextDirection(int direction) {
        return image.get(direction).getNextDirection();
    }

    public boolean isFrontBlocked(int direction) {
        return image.get(direction).isFrontBlocked();
    }

    public String getLocationName() {
        return Name;
    }
}
