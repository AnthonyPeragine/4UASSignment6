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

    ArrayList<Scene> scenes = new ArrayList<Scene>();
    String locationName;

    public Location(Scanner input) {
        locationName = input.nextLine();
        for (int x = 0; x < 4; x++) {
            Scene s = new Scene(input);
            scenes.add(s);
            System.out.print(s.direction);
            System.out.print(s.imageLocation);
            System.out.print(s.frontBlocked);
            System.out.print(s.nextLocation);
            System.out.print(s.nextDirection);
            System.out.println();
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
