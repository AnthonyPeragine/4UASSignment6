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
 *.
 * @author jetkeo
 */
public class Image {

    //initializing variables
    private BufferedImage image; 
    private int direction; 
    private boolean frontBlocked; 
    private String nextLocation; 
    private int nextDirection; 

    /**
     *
     * @param input the scanner to read information from
     */
    public Image(Scanner input) {
        //next word is the direction
        direction = Player.getDir(input.next());
        //set the image as null
        image = null; 

        //pass the next word to be read, and assign the image
        try {
            image = ImageIO.read(new File("images/" + input.next()));
        } catch (IOException e) {
        }
        //use the next word to determine whether front is blocked
        frontBlocked = input.next().equals("true"); 

        //if front isn't blocked
        if (!frontBlocked) { 
            //the next word is the next location
            nextLocation = input.next();
            //the direction to be facing 
            nextDirection = Player.getDir(input.next());
            //go to next line
            input.nextLine(); 
        } else {
            input.nextLine();
        }
    }

    /**
     *
     * @return next location
     */
    public String getNextLocation() {
        return nextLocation;
    }

    /**
     *
     * @return next direction
     */
    public int getNextDirection() {
        return nextDirection;
    }

    /**
     *
     * @return the buffered image 
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     *
     * @return whether front is blocked or not
     */
    public boolean isFrontBlocked() {
        return (frontBlocked);
    }
}
