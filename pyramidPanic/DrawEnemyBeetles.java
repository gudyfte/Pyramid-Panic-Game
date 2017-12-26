package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class DrawEnemyBeetles extends PyramidPanicGame implements ActionListener{
    Timer timer=new Timer(5,this);

    private int VelocityY=2;

    int BeetleX, BeetleY;

    private int BeetleWidth= BeetleImage.getWidth()/4;
    private int BeetleHeight=BeetleImage.getHeight(); 

    DrawEnemyBeetles(int beetleX, int beetleY) {
        BeetleX = beetleX;
        BeetleY = beetleY;
    }

    public void DrawBeetle(Graphics g, ImageObserver ImgObs) {

          g.drawImage(BeetleImage.getSubimage(BeetleWidth,0,BeetleWidth,BeetleHeight),BeetleX,BeetleY,ImgObs);
          timer.start();

    }
   
    public boolean BeetleCollision(int width, int height, int x, int y) {

        if((BeetleHeight + BeetleY > y) && (BeetleY < height + y)){
          if((BeetleWidth + BeetleX > x) && (BeetleX < width + x)){
            return true;
          }
        }
        return false;
 
    }

  public void actionPerformed(ActionEvent e){

    if(walls.wall1Collision(BeetleWidth-19,BeetleHeight,BeetleX+19, BeetleY) || walls.wall2Collision(BeetleWidth-19,BeetleHeight,BeetleX+19, BeetleY) || scorpions.scorpionsCollision(BeetleWidth-19,BeetleHeight,BeetleX+19, BeetleY) || VertBlock.VertBlockCollision(BeetleWidth-19,BeetleHeight,BeetleX+19, BeetleY) || HoriBlock.HoriBlockCollision(BeetleWidth-19,BeetleHeight,BeetleX+19, BeetleY) ){
      
        VelocityY=-VelocityY;

         try{
                BeetleImage=GetBufferedImageResource("Pictures/Beetle_up_strip4.png");
         }catch(Exception ex){}

           BeetleWidth = BeetleImage.getWidth()/4;
           BeetleHeight = BeetleImage.getHeight();
       
    }

   BeetleY+=VelocityY;

   repaint();

  }

}
