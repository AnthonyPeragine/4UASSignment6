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
        }
    }
    public BufferedImage getScene(int direction)
    {
       return scenes.get(direction).getImage();
    }
    
    public boolean isFrontBlocked(int direction)
    {
        return scenes.get(direction).isFrontBlocked();
    }
    public String getLocationName() {
        return locationName;
    }
}
