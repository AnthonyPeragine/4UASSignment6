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

    ArrayList<Scene> scenes = new ArrayList<Scene>();

    public HHSSAdventure() {
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            System.out.println(e);
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            Scene s = new Scene(input);
            //pass the next line into the location class
            scenes.add(s);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
