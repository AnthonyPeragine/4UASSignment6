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
 * Main game logic class
 *.
 * @author peraa0837
 */
public final class TextFileReader implements KeyListener {

    //initializing variables
    private ArrayList<Location> locations = new ArrayList<Location>(); 
    private int currentDir;
    private String currentLoc;
    private Interface gui; 

    //constuctor
    public TextFileReader() {
        //loading in the file containing information for the school
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
        //use a scanner
        Scanner input = new Scanner(file); 
        //first line is starting location
        currentLoc = input.nextLine();
        //the next line is the starting direction
        currentDir = Player.getDir(input.nextLine()); 

        //loop until there is nothing left to read
        while (input.hasNext()) { 
            //initialize a Location class and pass in the scanner
            Location location = new Location(input);
            //add the location to the locations arraylist
            locations.add(location); 
        }

        //initializing the GUI
        gui = new Interface(this);
        //make the GUI visible
        gui.setVisible(true);
        //add a keylistener to the GUI
        gui.addKeyListener(this); 

        //switch the picture displayed based on the current location and direction
        move(currentLoc, currentDir);
    }

    /**
     * switches the location displayed on the GUI based on the given location
     * name and direction
     *
     * @param locationName the name of the new location
     * @param direction the new direction
     */
    public void move(String Name, int direction) {
        //iterate through the locations arraylist to find the index of locationName
        for (int x = 0; x < locations.size(); x++) {
            if (locations.get(x).getLocationName().equals(Name)) {
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
        TextFileReader h = new TextFileReader();
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
            currentDir = Player.turnRight(currentDir);
        } //if the left key is pressed
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            currentDir = Player.turnLeft(currentDir);
        } //if the up key is pressed
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            for (int x = 0; x < locations.size(); x++) {
                if (locations.get(x).getLocationName().equals(currentLoc) && !locations.get(x).isFrontBlocked(currentDir)) {
                    currentLoc = locations.get(x).getNextLocation(currentDir);
                    currentDir = locations.get(x).getNextDirection(currentDir);
                    break;
                }
            }
        }

        //change the image based on the new location and direction
        move(currentLoc, currentDir);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
