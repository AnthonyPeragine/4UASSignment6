/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

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
        System.out.println(locationName);
        for (int x = 0; x < 4; x++) {
            Scene s = new Scene(input);
            scenes.add(s);
        }
    }

    public String getLocationName() {
        return locationName;
    }
}
