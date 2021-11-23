package shapes;
import java.awt.*;
import java.lang.Math;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Triangle{
    
    public static final int VERTICES=3;
    
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(){
        height = 30;
        width = 40;
        xPosition = 140;
        yPosition = 15;
        color = "green";
        isVisible = false;
    }

    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        try {
            draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moveUp(){
        try {
            moveVertical(-20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moveDown(){
        try {
            moveVertical(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Move the triangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        try {
            draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Move the triangle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance) throws InterruptedException {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the triangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            try {
                draw();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Slowly move the triangle vertically.
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            try {
                draw();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidth the new width in pixels. newWidht must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        try {
            draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Change the color. 
     * @param newColor the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        try {
            draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Draw the triangle with current specifications on screen.
     */
    private void draw() throws InterruptedException {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPosition, xPosition + (width/2), xPosition - (width/2) };
            int[] ypoints = { yPosition, yPosition + height, yPosition + height };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /*
     * Erase the triangle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /*
     * Duplicate area of the Triangle
     */
    public void duplicate(){
        makeInvisible();
        height = height * 2;
        width = width * 2;
        makeVisible();
    }
    
    /*
     * @return double,its a perimeter of the Triangle
     */
    public double perimeter(){
        double side = Math.pow((Math.pow(height,2) + Math.pow((width/2),2)),0.5);
        return (side * 2) + width;
    }
    
    /*
     * Draws a triangle moving step by step
     * @param integer, its a number of steps
     */
    public void walk(int steps){
        int tempH = height;
        int tempW = width;
        
        for(int i=0;i<steps;i++){
            Canvas canvas = Canvas.getCanvas();
            if(i%2==0){
                changeSize(tempW,tempH);
            }else{
                changeSize(tempH,tempW);
            }
            canvas.wait(1000);
        } 
    }
    
    /*
     * Flashing Triangle
     * @param integer, its a number of the times the Triangle shows
     */
    public void flash(int flash){
        for(int i=0;i<flash;i++){
            Canvas canvas = Canvas.getCanvas();
            if(i%2==0){
                makeInvisible();
            }else{
                makeVisible();
            }
            canvas.wait(500);
        }
        makeVisible();
    }
}
