//Programmer: Afia Nyantakyi and Christoher Harbin
//Date: 11/5/19
//Goal: To create the moving bullet for the game.
//Program name: A_Bullet.java
//Project File Name: clhasnLauncherB


import objectdraw.*;
import java.awt.*;

public class A_Bullet extends ActiveObject {
    
    // set how far (in pixels) that the ball will fly in each step
    private double DX = 10;
    
    
    //Class to create the graphical "hit"
    private Resizableball dots;
    //Class for the target
    public clhTarget Target, a;
    //variable for the launchpad
    private launchZone launchpad;
    
    //The bullets
    private FilledOval bullet, secBullet;
    
    //variable for the canvas
    private DrawingCanvas canvas;
    
    
    //checks if the target was hit
    private boolean hit;   
    
     
    	
    //The constructor
    public A_Bullet(Location startPoint, DrawingCanvas pCanvas, clhTarget Ball, launchZone pad) 
    {
        //pass the the startpoint of bullet, the canvas, the target and launchpad.
        canvas = pCanvas;
        launchpad = pad;
        Target = Ball;
        
        //creates the first and second bullet
        bullet = new FilledOval(startPoint, 15, 15, canvas); 
        bullet.setColor(Color.gray);
        secBullet = new FilledOval((startPoint.getX() + 30),startPoint.getY(), 15, 15, canvas);
           
        // activates the run() routine below   
        start();
    }
    
    
    public void run() 
    {
        //While the bullet is on the screen
        while (secBullet.getX() < canvas.getWidth()) 
        {
            //if the target is hit, the boolean is set to true
            if (Target.contains(bullet.getLocation()) || Target.contains (secBullet.getLocation()))
            {
                    hit = true;

                    Target.moveTo(400, 400);
            }
            
            //the bullet will move across the screen
            else
            {
               bullet.move(DX, 0);
               pause(100);
               secBullet.move(DX, 0);
            }
            
            //if target is hit
            if (hit)
            {
               //the bullets are moved.
               bullet.removeFromCanvas();
               secBullet.removeFromCanvas();
               
               //the scoreboard for when it is hit, updates
               launchpad.update_hits();
               
               //There is a text that says "HIT"
               Text A = new Text ("HIT", canvas.getWidth()/2, 20, canvas);
               
               //The graphical expression of hitting the target is there
               showDot();
               
               //The text is removed
               A.removeFromCanvas();
               
               pause(1000);
               //move the target to a new place
               new_target();

               //The loop is stopped
               break;
            }
               
        } //The target isn't hit
        
         //updates the score to show the misses
         launchpad.update_miss();
       
         //the bullets are removed.
         if (bullet != null)
         {
               bullet.removeFromCanvas();
               secBullet.removeFromCanvas();
         }
     }
     
     //subroutine to show the dots.
     public void showDot ()
     {
         //makes 10 dots that move.
         for (int k = 0; k < 10; k++)
         {
            dots = new Resizableball(canvas);
            pause(100);
         }
     }
     
     //moves the target to a new place by changing the location
     public void new_target()
     {
         RandomIntGenerator place = new RandomIntGenerator (0, canvas.getHeight() - 30);
         Target.moveTo (canvas.getWidth()-60, place.nextValue());
     }
     
} // end of class
