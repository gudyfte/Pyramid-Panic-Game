package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DrawScarabs extends PyramidPanicGame{
  
   private int ImageX, ImageY;

   private int ImageWidth=ScarabImage.getWidth(null);
   private int ImageHeight=ScarabImage.getHeight(null);
    
   DrawScarabs(int imageX, int imageY) {

        ImageX = imageX;
        ImageY = imageY;
        
    }

    public boolean ScarabCollision(int width,int height,int x,int y) {

       if ((ImageHeight + ImageY > y) && (ImageY < height + y)) {
          if((ImageWidth + ImageX > x) && (ImageX < width + x)){
                ImageX =  2948;
                ImageY = 2308; 
                return true;
            }
         }
        return false;      
    }

   public void DrawScarab(Graphics g, ImageObserver ImgObs) {
                  
            g.drawImage(ScarabImage,ImageX,ImageY, ImgObs);
   }
}
