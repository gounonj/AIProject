/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;

/**
 *
 * @author jocelyn
 */
public class Grid {
    
    private int index;
    
    private int width;
    private int height;
    
    private int startX;
    private int startY;
    
    private int goalX;
    private int goalY;
    
    private LinkedList<Barrier> barriers;

    public Grid(){        
        this.barriers = new LinkedList<Barrier>();
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getGoalX() {
        return goalX;
    }

    public void setGoalX(int goalX) {
        this.goalX = goalX;
    }

    public int getGoalY() {
        return goalY;
    }

    public void setGoalY(int goalY) {
        this.goalY = goalY;
    }

    public LinkedList<Barrier> getBarriers() {
        return barriers;
    }

    public void setBarriers(LinkedList<Barrier> barriers) {
        this.barriers = barriers;
    }
    
    public void printBarriers(){
        for(Barrier barrier : this.barriers){
            System.out.println(" Size :" + barrier.getWidth() + "x" + barrier.getHeight()
                                + ", Anchor :" +  barrier.getAnchorX()+ "," + barrier.getAnchorY());
        }
    }
}
