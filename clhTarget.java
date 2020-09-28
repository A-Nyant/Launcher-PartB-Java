//Programmer: Afia Nyantakyi and Christoher Harbin
//Date: 11/5/19
//Goal: Creates the target of the game.
//Program name: clhTarget.java
//Project File Name: clhasnLauncherB

import objectdraw.*;
import java.awt.*;

public class clhTarget extends ActiveObject {
    
    //  not needed now. sets how far (in pixels) that the Target will fly in each step
    private double DX = 0;
    private double DY = 5;
    private int change;
    private RandomIntGenerator randChange = new RandomIntGenerator(1,50);
    
      
    private FilledOval circle;
    private FilledRect box;	     // variables for the target
    private DrawingCanvas canvas;	
    
    public clhTarget(DrawingCanvas pCanvas) 
    {
        canvas = pCanvas;
        circle = new FilledOval(canvas.getWidth()-60,70, 50, 50, canvas);      //sets location of target
        box = new FilledRect(canvas.getWidth()-65,80, 55, 30, canvas); 
		  circle.setColor(Color.BLACK);    //sets color for the Target
        box.setColor(Color.WHITE);
        start();	// activates the run() routine below
    }
    
    public void run() 
    {
        while (circle.getY() < canvas.getHeight()) 
        {
            circle.move(DX, DY);	// draw Target in new location.
            box.move(DX,DY);
            change = randChange.nextValue();
            pause(100);				// pause for  N  milliseconds
            if  (circle.getY()+50 > canvas.getHeight()) 
            {
                DY = -DY;
            }                                                //makes target bounce off edges moving up and down with 2% chance of change of direction
            else if  (circle.getY() <= 0) 
            {
                DY = -DY;
            }
            else if (change == 1) 
            {
                 DY = -DY;
            }  
        }
    }
    public boolean contains (Location p)             // checks if two black sections are hit and not the middle
    {
        if (circle.contains (p) && !box.contains(p))
            return true;
        else
            return false;
    }
    
    
       
    public void moveTo(int x, int y) // resets target location after hit
    {
      int count = 0;
      circle.moveTo (x, y);
      box.moveTo (x, y + 10);
      count++;
      if (count == 1)
      {
         run();
         count = 0;
      }

    }
    
}
