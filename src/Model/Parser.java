/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author jocelyn
 */
public class Parser {
    
    private HashMap<String,Grid> grids;

   
    public Parser(){
        this.grids = new HashMap<String,Grid>();        
    }

    public HashMap<String, Grid> getGrids() {
        return grids;
    }

    public void setGrids(HashMap<String, Grid> grids) {
        this.grids = grids;
    }    
    
    public void resetGrids(){
        this.grids.clear();
    }
    
    public void parseGrid(){
        
        String filePath = "./grids/grid.txt";
        try{
            Scanner scanner = new Scanner(new FileReader(filePath));
            String str = null;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                parseLine(str);
            }
        } catch (IOException ioe) {
            System.out.println("Error --" + ioe.toString());
        }   
       /* for(Grid grid : this.grids){
            grid.printBarriers();
            System.out.println(grid.getIndex());
        }*/
        return;
    }

    private void parseLine(String line) {
        if(line.length() > 1 && line.substring(0,1).equals("#")){
            System.out.println("Commentaire");
            return;
        }
        Grid grid = new Grid();
        String[] words = null;       
        words = line.split(" ") ;
        System.out.println("nombre de mot :" + words.length);
        if(words.length>3){
            String index; 
            //condition a ajouter
            index = words[0];
            parseSize(words[1],grid);
            parseStart(words[2],grid);
            parseGoal(words[3],grid);
            if(words.length>4){
                parseBarrier(words,grid);
            }
            this.grids.put(index, grid);
           /* System.out.println("index : " + grid.getIndex());
            System.out.println(grid.getHeight() +  " et " + grid.getHeight());
            System.out.println(grid.getStartX() +  " et " + grid.getStartY());
            System.out.println(grid.getGoalX()+  " et " + grid.getGoalY());
            grid.printBarriers();*/
            
        } else {
        }
    }

    private void parseSize(String str, Grid grid) {
        String[] words = null;       
        words = str.split(",");
        if(words.length == 2){
           grid.setWidth(Integer.parseInt(words[0]));
           grid.setHeight(Integer.parseInt(words[1]));
        }
    }


    private void parseStart(String str, Grid grid) {
        String[] words = null;       
        words = str.split(",");
        if(words.length == 2){
           grid.setStartX(Integer.parseInt(words[0]));
           grid.setStartY(Integer.parseInt(words[1]));
        }
    }

    private void parseGoal(String str, Grid grid) {
        String[] words = null;       
        words = str.split(",");
        if(words.length == 2){
           grid.setGoalX(Integer.parseInt(words[0]));
           grid.setGoalY(Integer.parseInt(words[1]));
        }
    }

    private void parseBarrier(String[] str, Grid grid) {
        for(int i =4; i<str.length ; i++){
            Barrier barrier = new Barrier();
            
            String[] words = null;       
            words = str[i].split(",");
            if(words.length == 4){
               barrier.setAnchorX(Integer.parseInt(words[0]));
               barrier.setAnchorY(Integer.parseInt(words[1]));
               barrier.setWidth(Integer.parseInt(words[2]));
               barrier.setHeight(Integer.parseInt(words[3]));
               grid.getBarriers().add(barrier);
            }
        }
    }
    
}
