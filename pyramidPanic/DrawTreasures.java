package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DrawTreasures extends PyramidPanicGame{

   private int ImageX, ImageY;

   private int ImageWidth1 = TreasureImage1.getWidth(null);
   private int ImageHeight1 = TreasureImage1.getHeight(null);

   private int ImageWidth2 = TreasureImage2.getWidth(null);
   private int ImageHeight2 = TreasureImage2.getHeight(null);
    
   DrawTreasures(int imageX, int imageY) {

        ImageX = imageX;
        ImageY = imageY;
        
    }

    public boolean Treasure1Collision(int width,int height,int x,int y) {

       if ((ImageHeight1 + ImageY > y) && (ImageY < height + y)) {
          if((ImageWidth1 + ImageX > x) && (ImageX < width + x)){
                ImageX =  2948;
                ImageY = 2308; 
                return true;
            }
         }
        return false;       
    }

     public boolean Treasure2Collision(int width,int height,int x,int y) {

       if ((ImageHeight2 + ImageY > y) && (ImageY < height + y)) {
          if((ImageWidth2 + ImageX > x) && (ImageX < width + x)){
                ImageX =  2948;
                ImageY = 2308; 
                return true;
            }
         }
        return false;

         
    }

   public void DrawTreasure1(Graphics g, ImageObserver ImgObs) {
                
       g.drawImage(TreasureImage1,ImageX, ImageY, ImgObs);
   }

   public void DrawTreasure2(Graphics g, ImageObserver ImgObs) {
                
      g.drawImage(TreasureImage2,ImageX, ImageY, ImgObs);
   }
}
