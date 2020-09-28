//Programmer: Afia Nyantakyi and Christoher Harbin
//Date: 11/5/19
//Goal: Creates the graphical effects.
//Program name: Resizableball.java
//Project File Name: clhasnLauncherB


import objectdraw.*;
import java.awt.*;

public class Resizableball extends ActiveObject {

   //varible for the dots
   private FilledOval dots;
   
   //has the starting size, the times is grow/shrink, how much it changes
   private int Size = 10, count, INC = 10, done_time;
   
   //the canvas of the game
   private DrawingCanvas canvas;
   
   //Locations for the dot
   private Location Place, StartPoint;

   public Resizableball(DrawingCanvas pCanvas)
   {
      //pass the canvas
      canvas = pCanvas;
      
      //creates a random location for the dots
      RandomIntGenerator d_place = new RandomIntGenerator (25, 300);
      Place = new Location (d_place.nextValue(), d_place.nextValue());
      StartPoint = new Location (Place.getX() - Size/2, Place.getY() - Size/2);
      
      //creates the dots and sets the color
      dots = new FilledOval (Place, Size, Size, canvas);
      dots.setColor(find_color(Color.yellow));
      
      //starts the "run routine
      start();
   }
   
   
   
   public void run() {
   
        //until the dot has changed 80 times.
        while (done_time < 40)
        {
            //it increases
            done_time++;
            
            //until the count is over 10, 
            //the dot's size increase
            if (count <= 10)
            {
                INC = 15;
                
            }
            
            //until the count is over 20,
            //the dot's size decreases 
            else if (count <= 20)
            {
                INC = -15;
            }
            
            //the count is restarted.
            else
            {
                count = 0;
            }
            
            //Calls a routine to change the location of the dots
            setLocation();
            
            //changes the size of the dot
            Size += INC;
            dots.setSize(Size, Size);
            
            //the location of the dots is changed
            Place = new Location (StartPoint.getX() - Size/2, StartPoint.getY() - Size/2);
            pause (100);
            
            //count increases.
            count ++;
       }//end of dot's time
       
       //dot is removed from the canvas.
       dots.removeFromCanvas();  
   }
   
   //sets the color of the dot
   public Color find_color(Color pie)
   {
        //the array of the colors
        Color D_color [] = {Color.blue, Color.cyan, Color.green, Color.yellow, Color.orange, Color.red, Color.pink, Color.gray, Color.magenta};
        
        //random number is generated and then based on that, the color is sent
        RandomIntGenerator num_color = new RandomIntGenerator (0, 8);
        return D_color [num_color.nextValue()];
   }

   //set the location of the dots.
   public void setLocation ()
   {
        dots.moveTo (Place.getX(), Place.getY());
   }

}