package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Sword extends PyramidPanicGame{

   private Image SwordImage; 

   private int ImageX, ImageY;

   private int ImageWidth, ImageHeight; 
    
   Sword(Image swordImage,int imageX, int imageY) {
        SwordImage = swordImage;

        ImageWidth = SwordImage.getWidth(null);
        ImageHeight = SwordImage.getHeight(null);

        ImageX = imageX;
        ImageY = imageY;
        
    }

    public boolean SwordCollision(int width,int height,int x,int y) {

       if ((ImageHeight + ImageY > y) && (ImageY < height + y)) {
          if((ImageWidth + ImageX > x) && (ImageX < width + x)){
                ImageX =  2948;
                ImageY = 2308; 
                return true;
            }
         }
        return false;
         
    }

    public void DrawSword(Graphics g, ImageObserver ImgObs) {
         g.drawImage(SwordImage,ImageX,ImageY,ImgObs);
   }
}
