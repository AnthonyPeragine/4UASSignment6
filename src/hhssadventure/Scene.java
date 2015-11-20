/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author haidj9901+kittyterror98
 */
public class Scene {

    private BufferedImage image;
//    private Direction direction = new Direction();
    //private Location;
    private boolean frontBlocked;

    public Scene() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("strawberry.jpg"));
        } catch (IOException e) {
        }
        frontBlocked = false;
    }

    public boolean isFrontBlocked() {
        return (frontBlocked == true);
    }
}
