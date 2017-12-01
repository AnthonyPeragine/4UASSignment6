
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author peraa0837
 */
public class TextFileReader {

    ArrayList<Location> locations = new ArrayList<Location>();;
    String spawnLoc;
    String spawnDir;

    public TextFileReader() {
        //create a blank file reader
        FileReader file = null;
        try {
            //creating a file reader
            URL url = ClassLoader.getSystemClassLoader().getResource("pics.txt");
            file = new FileReader(url.getFile());
        } catch (Exception e) {
            //handle any errors
            //print out errors
            e.printStackTrace();
            //exit the program
            System.exit(0);
        }

        //use a scanner
        Scanner in = new Scanner(file);
        //set spawns
        spawnLoc = in.nextLine();
        spawnDir = in.nextLine();

        //set the number of positions in the array


        //start reading in locations
        int count = 0;
        int num = 0;
        String name = "";
        while (in.hasNextLine()) {
            
            if (count % 5 == 0) {
                name = in.nextLine();    
                count++;
            } 
            String direction = in.next();
            String img = in.next();
            System.out.println(img);
            String wall = in.next();
            String nextLoc = "";
            String nextDir = "";
            if (wall.equals("false")) {
                nextLoc = in.next();
                nextDir = in.nextLine();
            }else{
                in.nextLine();
            }
            //create each contact
            Location l = new Location(name + direction);
            l.setDir(direction);
            l.setImage(img);
            l.setNextLoc(nextLoc);
            l.setNextDir(nextDir);

            //add contact to list
            locations.add(l);
            count++;
        }
    }
    
    public String getSpawn(){
        return this.spawnLoc;
    }
    
    public String getSpawnDir(){
        return this.spawnDir;
    }
}
