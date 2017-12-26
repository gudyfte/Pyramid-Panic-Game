package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DrawPotions extends PyramidPanicGame{ 

   private int ImageX, ImageY;

   private int ImageWidth=PotionImage.getWidth(null);
   private int ImageHeight=PotionImage.getHeight(null);
    
    DrawPotions(int imageX, int imageY) {

        ImageX = imageX;
        ImageY = imageY;
        
    }

    public boolean PotionCollision(int width,int height,int x,int y) {

       if ((ImageHeight + ImageY > y) && (ImageY < height + y)) {
          if((ImageWidth + ImageX > x) && (ImageX < width + x)){
                ImageX =  2948;
                ImageY = 2308; 
                return true;
            }
         }
        return false;

         
    }


   public void DrawPotion(Graphics g, ImageObserver ImgObs) {
              
            g.drawImage(PotionImage,ImageX,ImageY, ImgObs);
   }
}
