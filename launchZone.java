//Programmer: Afia Nyantakyi and Christoher Harbin
//Date: 11/5/19
//Goal: Creates the launchzones of the game.
//Program name: launchZone.java
//Project File Name: clhasnLauncherB

import objectdraw.*;
import java.awt.*;

public class launchZone extends WindowController {
    
    //
    private FilledRect fireZone;	  
    private FilledOval start_Shot;
    private DrawingCanvas canvas;
    private Text scoreboard;
    private int S_amount = 0, T_hit = 0;
    private double hit_percent = 0;
    
    public launchZone(DrawingCanvas pCanvas) 
    {
        canvas = pCanvas;
        fireZone = new FilledRect(0,0, 25, canvas.getHeight(), canvas);     //location and color of fire zone
		fireZone.setColor(Color.GREEN);
        scoreboard = new Text ("Shots fired: " + S_amount + "    Target hits: " + T_hit + "    Hit Rate: " + hit_percent,30, canvas.getHeight() - 30, canvas); // location of Scoreboard
        start();	// activates the run() routine below
        start_Shot = new FilledOval (0, 20, 15, 15, canvas); //location and color of launcher
        start_Shot.setColor(Color.blue);
    }
    public void update_miss()
    {
        S_amount++;
        hit_percent = ((double)T_hit/S_amount)*100;                                                                     //updates shots that miss
        scoreboard.setText("Shots fired: " + S_amount + " Target hits: " + T_hit + " Hit Rate: " + hit_percent + "%");
    }
    public void update_hits ()
    {
        S_amount++;
        T_hit++;
        hit_percent = (T_hit/S_amount)*100;
        scoreboard.setText("Shots fired: " + S_amount + " Target hits: " + T_hit + " Hit Rate: " + hit_percent + "%");  //updates shots that hit
    }
	 public boolean contains (Location p)  // returns if firing zone contains the mouse
    {
         return fireZone.contains(p);
    }
    
    public void shot_place (Location p)   // sets loction of the launcher
    {
         start_Shot.moveTo (p);
    }
} // end of class
