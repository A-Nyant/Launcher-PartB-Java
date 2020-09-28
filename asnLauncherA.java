//Programmer: Afia Nyantakyi and Christoher Harbin
//Date: 11/5/19
//Goal: The controller of the game.
//Program name: asnLauncherA.java
//Project File Name: clhasnLauncherB

import objectdraw.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class asnLauncherB extends WindowController{        
    public static void main(String[] args)
    {
      new asnLauncherB().startController(400,400);    
    }
    
    private clhTarget ball; //The target
    private A_Bullet bullet; //The ball
    private launchZone launchPad; //The class for the launch pad
    
    //The variable to create the instructions
    private FilledRect inst_box; 
    private Text instructionA, instructionB, instructionC, instructionD;
    private int count = 0;
    
    
    //Location of the ball
    private Location Target_Point = new Location (200, 100);
        
    
    //When the game begins.
    public void begin()
    {
        //The target is made
        ball = new clhTarget (canvas);
        
        
        //this sets the instruction for the game.
        inst_box = new FilledRect (50, 100, 250, 300, canvas);
        inst_box.setColor(Color.white);
        instructionA = new Text ("To play the game, you should press the" , 60, 110, canvas);
        instructionB = new Text ("mouse. Then a ball will appear and move", 60, 135, canvas);
        instructionC = new Text ("across the screen. Try to aim for the", 60, 150, canvas);
        instructionD = new Text ("middle of the target on the right side", 60, 165, canvas);
        
        //The area where the player can shot from
        launchPad = new launchZone (canvas);
     }//end of subroutine
     

    

    public void onMousePress(Location p)
    {
        //After the first press, the instructions disappear
        if (count == 0)
        {
            instructionA.removeFromCanvas();
            instructionB.removeFromCanvas();
            instructionC.removeFromCanvas();
            instructionD.removeFromCanvas();
            inst_box.removeFromCanvas();
            count+= 1;
         }
         
         
         //Game starts
         else
         {
            //Only when the mouse is inside the launch area,
            //a bullet will come out.
            if (launchPad.contains(p))
            {
               bullet = new A_Bullet (p, canvas, ball, launchPad);
            }
            
          }
          
    }//end of subroutine 
    
    
    public void onMouseMove(Location point)
    {
         if (launchPad.contains(point))
         {
               launchPad.shot_place(point);
         }
    }
       
} // end class
