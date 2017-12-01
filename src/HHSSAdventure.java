
import java.io.FileReader;
import java.net.URL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peraa0837
 */
public class HHSSAdventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        TextFileReader file = new TextFileReader();
        
        System.out.println(file.getSpawn() + " " + file.getSpawnDir());
        for(int i = 0; i < file.locations.size(); i++)
            System.out.println(file.locations.get(i).getName());
        
    }
}
