/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author caius and jafer and jafer and caius
 */
public class Scene {

    //initializing variables
    private BufferedImage image; //initializing image for the scene
    private int direction; //the direction of the location, specifying the scene
    private boolean frontBlocked; //is front blocked
    private String nextLocation; //the name of the next location based on the direction of the current location  (scene)
    private int nextDirection; //the direction to be facing after arriving at the next location

    /**
     * Constructor for the Scene class
     *
     * @param input the scanner to read information from
     */
    public Scene(Scanner input) {
        direction = Direction.getDir(input.next()); //convert next word to direction
        image = null; //set the image as null to begin

        //pass the next word to be read, and assign the image of the scene
        try {
            image = ImageIO.read(new File("images/" + input.next()));
        } catch (IOException e) {
        }

        frontBlocked = input.next().equals("true"); //use the next word to determine whether front is blocked
        
        
        if (!frontBlocked) { //if front isn't blocked:
            nextLocation = input.next(); //get the next word to be the next location based on the scene
            nextDirection = Direction.getDir(input.next()); // get the direction to be facing after arriving at the next location
            input.nextLine(); //go to next line(next location name)
        } else {
            input.nextLine();
        }
    }

    /**
     * Get the name of the next location
     *
     * @return next location
     */
    public String getNextLocation() {
        return nextLocation;
    }

    /**
     * Get the direction of the next location
     *
     * @return next direction
     */
    public int getNextDirection() {
        return nextDirection;
    }

    /**
     * get the Image of the current scene
     *
     * @return the bufferedImage for the scene
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Determine whether the front of the scene is blocked
     *
     * @return whether front is blocked or not
     */
    public boolean isFrontBlocked() {
        return (frontBlocked);
    }
}
