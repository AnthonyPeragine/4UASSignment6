
import java.awt.image.BufferedImage;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
*
* @author peraa0837
*/
public class Location {
    private String name;
    private String direction;
    private String img;
    private boolean wall;
    private String nextLoc;
    private String nextDir;
    

    //construct using the name
    public Location(String name){
        this.name = name;
    }
    
    //SETTERS
    public void setDir(String dir){
        this.direction = dir;
    }
    
    public void setImage(String img){
        this.img = img;
    }
    
    public void setWall(boolean wall){
        this.wall = wall;
    }
    
    public void setNextLoc(String nextLoc){
        if(wall){
            this.nextLoc = nextLoc;
        }
    }
    
    public void setNextDir(String nextDir){
        if(wall){
            this.nextDir = nextDir;
        }
    }
    
    //GETTERS
    public String getName(){
        return this.name;
    }
    
    public String getDir(){
        return this.direction;
    }
    
    public String getImage(){
        return this.img;
    }
    
    public boolean getWall(){
        return this.wall;
    }
    
    public String getNextLoc(){
        return this.nextLoc;
    }
    
    public String getNextDir(){
        return this.nextDir;
    }
}


