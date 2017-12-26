package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DrawWalls extends PyramidPanicGame{

    private int WallX, WallY;

    private int WallWidth1= WallImage1.getWidth(null);
    private int WallHeight1= WallImage1.getHeight(null); 

    private int WallWidth2=WallImage2.getWidth(null);
    private int WallHeight2=WallImage2.getWidth(null);

    DrawWalls(int wallX, int wallY) {
        WallX = wallX;
        WallY = wallY;
    }

    public void DrawWall1(Graphics g, ImageObserver ImgObs) {
            g.drawImage(WallImage1, WallX, WallY, ImgObs);
 
    }

    public void DrawWall2(Graphics g, ImageObserver ImgObs) {
       
            g.drawImage(WallImage2, WallX, WallY, ImgObs);
      
    }

    public boolean Wall1Collision(int width, int height, int x, int y) {

        if((WallHeight1 + WallY > y) && (WallY < height + y)){
          if((WallWidth1 + WallX > x) && (WallX < width + x)){
            return true;
          }
        }
        return false;
    }

    public boolean Wall2Collision(int width, int height, int x, int y) {

     if((WallHeight2 + WallY > y) && (WallY < height + y)){
      if((WallWidth2 + WallX > x) && (WallX < width + x)){
        return true;
      }
     }
     return false;
  }   

}
