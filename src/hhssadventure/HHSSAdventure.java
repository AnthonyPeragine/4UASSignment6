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
    int currentDirection;
    String currentLocation;
    public HHSSAdventure() {
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            Location location = new Location(input);
            locations.add(location);
        }
        
    }

    public void switchLocation(String name, int direction)
    {
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure h = new HHSSAdventure();
    }
}
