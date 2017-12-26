package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class DrawEnemyScorpions extends PyramidPanicGame implements ActionListener{

    Timer timer=new Timer(5,this);

    private int VelocityX=2;

    int ImageX, ImageY;
    
    private int ImageWidth=ScorpionImage.getWidth()/4;
    private int ImageHeight=ScorpionImage.getHeight();

    DrawEnemyScorpions(int imageX, int imageY) {
        ImageX = imageX;
        ImageY = imageY;
    }

    public void DrawScorpion(Graphics g, ImageObserver ImgObs) {
     
        g.drawImage(ScorpionImage.getSubimage(ImageWidth,0,ImageWidth,ImageHeight),ImageX,ImageY,ImgObs);
        timer.start();
    }

    public boolean ScorpionCollision(int width, int height, int x, int y) {

        if((ImageHeight + ImageY > y) && (ImageY < height + y)){
          if((ImageWidth + ImageX > x) && (ImageX < width + x)){
            return true;
          }
        }
        return false;
    }

  public void actionPerformed(ActionEvent e){

    if(walls.wall1Collision(ImageWidth-20,ImageHeight,ImageX+20, ImageY) || walls.wall2Collision(ImageWidth-20,ImageHeight,ImageX+20, ImageY) || beetles.beetlesCollision(ImageWidth-20,ImageHeight,ImageX+20, ImageY) || VertBlock.VertBlockCollision(ImageWidth-20,ImageHeight,ImageX+20, ImageY) || HoriBlock.HoriBlockCollision(ImageWidth-20,ImageHeight,ImageX+20, ImageY)){

      VelocityX=-VelocityX;
          try{
              ScorpionImage=GetBufferedImageResource("Pictures/Scorpion_left_strip4.png");
          }catch(Exception ex){}

          ImageWidth = ScorpionImage.getWidth()/4;
          ImageHeight = ScorpionImage.getHeight();

   }

   ImageX+=VelocityX;

   repaint();

  }

}
