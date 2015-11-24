/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jaf
 */
public class HHSSAdventure {

    ArrayList<Location> locations = new ArrayList<Location>();
    String currentDirection;
    String currentLocation;
    private AdventureFrame gui;

    public HHSSAdventure() {
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
        Scanner input = new Scanner(file);
        currentLocation = input.nextLine();
        currentDirection = input.nextLine();
        System.out.println(currentLocation);
        while (input.hasNext()) {
            Location location = new Location(input);
            //System.out.println(location.getLocationName());
            locations.add(location);
        }
        gui = new AdventureFrame(this);
        gui.setVisible(true);
        switchLocation(currentLocation, currentDirection);
    }

    
//    public Location getCurrentLocation()
//    {
//        return;
//    }
    public void switchLocation(String name, String direction) {
        for (int x = 0; x < locations.size(); x++)
        {
            if (locations.get(x).getLocationName().equals(name))
            {
               gui.setImage(locations.get(x).getScene(Direction.getDir(direction)));
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure h = new HHSSAdventure();
    }
}
