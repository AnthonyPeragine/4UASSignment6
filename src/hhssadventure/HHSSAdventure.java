/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jafer and caius
 */
public final class HHSSAdventure implements KeyListener {

    //initializing variables
    private ArrayList<Location> locations = new ArrayList<Location>(); //arraylist for locations
    private int currentDirection; //stores current direction (check Direction class)
    private String currentLocation; //stores the name of the current location
    private AdventureFrame gui; //the JFrame made to display the school

    /**
     * Constructor for main HHSSAdventure class
     */
    public HHSSAdventure() {
        //loading in the file containing information for the school
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            System.out.println(e);
        }

        Scanner input = new Scanner(file); //create a scanner out of the file that's been loaded in

        currentLocation = input.nextLine(); //the first line is loaded in as the starting location
        currentDirection = Direction.getDir(input.nextLine()); //the next line is the starting direction

        //populating the locations arraylist with all the Locations found in the file
        while (input.hasNext()) { //loop until there is nothing left to read
            Location location = new Location(input); //initialize a Location class and pass in the scanner
            locations.add(location); //add the location to the locations arraylist
        }

        //initializing the GUI
        gui = new AdventureFrame(this);
        gui.setVisible(true); //make the GUI visible
        gui.addKeyListener(this); //add a keylistener to the GUI

        //switch the picture displayed based on the current location and direction
        switchLocation(currentLocation, currentDirection);
    }

    /**
     * switches the location displayed on the GUI based on the given location
     * name and direction
     *
     * @param locationName the name of the new location
     * @param direction the new direction
     */
    public void switchLocation(String locationName, int direction) {
        //iterate through the locations arraylist to find the index of locationName
        for (int x = 0; x < locations.size(); x++) {
            if (locations.get(x).getLocationName().equals(locationName)) {
                //set the image on the GUI to the new location
                gui.setImage(locations.get(x).getImage(direction));
                break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HHSSAdventure h = new HHSSAdventure();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    /**
     * Handles any key pressed event
     */
    public void keyPressed(KeyEvent e) {
        //if the right key is pressed
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //switch the image based on the next direction
            currentDirection = Direction.getNextDir(currentDirection);
        } //if the left key is pressed
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //switch the image based on the previous direction
            currentDirection = Direction.getPrevDir(currentDirection);
        } //if the up key is pressed
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            //find the next location and the next direction
            for (int x = 0; x < locations.size(); x++) {
                if (locations.get(x).getLocationName().equals(currentLocation) && !locations.get(x).isFrontBlocked(currentDirection)) {
                    currentLocation = locations.get(x).getNextLocation(currentDirection);
                    currentDirection = locations.get(x).getNextDirection(currentDirection);
                    break;
                }
            }
        }

        //change the image based on the new location and direction
        switchLocation(currentLocation, currentDirection);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
