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
    int direction;
    //private Location;
    boolean frontBlocked;
    String nextLocation;
    int nextDirection;
    String imageLocation;

    public Scene(Scanner input) {
        direction = Direction.getDir(input.next());
        image = null;
        try {
            imageLocation = input.next();
            image = ImageIO.read(new File("images/" + imageLocation));
        } catch (IOException e) {
        }
        frontBlocked = input.next().equals("true");
        if (!frontBlocked) {
            nextLocation = input.next();
            nextDirection = Direction.getDir(input.next());
            input.nextLine();
        } else {
            input.nextLine();
        }
    }

    public String getNextLocation() {
        return nextLocation;
    }

    public int getNextDirection() {
        return nextDirection;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isFrontBlocked() {
        return (frontBlocked);
    }
}
