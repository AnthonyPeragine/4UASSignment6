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
 * @author jaf
 */
public class HHSSAdventure implements KeyListener {

    ArrayList<Location> locations = new ArrayList<Location>();
    int currentDirection;
    String currentLocation;
    private AdventureFrame gui;

    public HHSSAdventure() {
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
        Scanner input = new Scanner(file);
        currentLocation = input.nextLine();
        currentDirection = Direction.getDir(input.nextLine());
        System.out.println(currentLocation);
        while (input.hasNext()) {
            Location location = new Location(input);
            //System.out.println(location.getLocationName());
            locations.add(location);
        }
        gui = new AdventureFrame(this);
        gui.setVisible(true);
        gui.addKeyListener(this);
        switchLocation(currentLocation, currentDirection);
    }

//    public Location getCurrentLocation()
//    {
//        return;
//    }
    public void switchLocation(String name, int direction) {
        //System.out.println(direction);
        for (int x = 0; x < locations.size(); x++) {
            if (locations.get(x).getLocationName().equals(name)) {
                gui.setImage(locations.get(x).getScene(direction));
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
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            currentDirection = Direction.getNextDir(currentDirection);
            switchLocation(currentLocation, currentDirection);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
