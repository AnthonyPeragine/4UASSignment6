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
    private Interface gui;

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
        
        while (input.hasNext()) {
            Location location = new Location(input);
            //System.out.println(location.getLocationName());
            locations.add(location);
        }
        gui = new Interface(this);
        gui.setVisible(true);
        gui.setImage(locations.get(2).scenes.get(1).getImage());
    }

//    public Location getCurrentLocation()
//    {
//        return;
//    }
    public void switchLocation(String name, int direction) {
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure h = new HHSSAdventure();
    }
}
