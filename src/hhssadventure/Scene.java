/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

/**
 *
 * @author haidj9901
 */
public class Scene {

    //private BufferedImage;
    //private Direction;
    //private Location;
    private boolean frontBlocked;

    public Scene() {
        frontBlocked = false;
    }

    public boolean isFrontBlocked() {
        return (frontBlocked == true);
    }
}
