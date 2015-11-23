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
 * @author haidj9901+kittyterror98
 */
public class Scene {

    private BufferedImage image;
    private String direction;
    //private Location;
    private boolean frontBlocked;
    private String nextLocation;
    private String nextDirection;

    public Scene(Scanner input) {
        direction = input.next();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("images/" + input.next()));
        } catch (IOException e) {
        }
        frontBlocked = input.next().equals("true");
        if (!frontBlocked) {
            nextLocation = input.next();
            nextDirection = input.nextLine();
        } else {
            input.nextLine();
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isFrontBlocked() {
        return (frontBlocked == true);
    }
}
