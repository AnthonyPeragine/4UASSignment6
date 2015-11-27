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

    private ArrayList<Scene> scenes = new ArrayList<Scene>();
    private String locationName;

    public Location(Scanner input) {
        locationName = input.nextLine();
        System.out.println(locationName);
        for (int x = 0; x < 4; x++) {
            Scene s = new Scene(input);
            scenes.add(s);
        }
    }

    public BufferedImage getImage(int direction) {
        return scenes.get(direction).getImage();
    }

    public Scene getScene(int direction) {
        return scenes.get(direction);
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
