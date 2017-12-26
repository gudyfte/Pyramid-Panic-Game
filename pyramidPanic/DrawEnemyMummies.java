package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.image.BufferedImage;

public class DrawEnemyMummies extends PyramidPanicGame implements ActionListener{
    Timer timer=new Timer(5,this);

    private int VelocityX=2;
    private int VelocityY=2;

    int VertImageX, VertImageY;
    
    private int VertImageWidth=VertMummyImage.getWidth()/4;
    private int VertImageHeight=VertMummyImage.getHeight();

    private int HoriImageWidth;
    private int HoriImageHeight;

    private BufferedImage horiMummyImage;

    private int HoriImageX;
    private int HoriImageY;

    DrawEnemyMummies(int vertImageX, int vertImageY) {
        VertImageX = vertImageX;
        VertImageY = vertImageY;
    }

    DrawEnemyMummies(BufferedImage HoriMummyImage,int horiImageX,int horiImageY){
      horiMummyImage=HoriMummyImage;

      HoriImageX=horiImageX;
      HoriImageY=horiImageY;

      HoriImageWidth=horiMummyImage.getWidth()/4;
      HoriImageHeight=horiMummyImage.getHeight();
    }

    public void DrawVertMummy(Graphics g, ImageObserver ImgObs) {

        g.drawImage(VertMummyImage.getSubimage(VertImageWidth,0,VertImageWidth,VertImageHeight),VertImageX,VertImageY,ImgObs);

          timer.start();

    }

     public void DrawHoriMummy(Graphics g, ImageObserver ImgObs) {

         g.drawImage(horiMummyImage.getSubimage(HoriImageWidth,0,HoriImageWidth,HoriImageHeight),HoriImageX,HoriImageY,ImgObs);

         timer.start();
    }

    public boolean VertMummyCollision(int width, int height, int x, int y) {

        if((VertImageHeight + VertImageY > y) && (VertImageY < height + y)){
          if((VertImageWidth + VertImageX > x) && (VertImageX < width + x)){
            return true;
          }
        }
        return false;
 
    }

     public boolean HoriMummyCollision(int width, int height, int x, int y) {

        if((HoriImageHeight + HoriImageY > y) && (HoriImageY < height + y)){
          if((HoriImageWidth + HoriImageX > x) && (HoriImageX < width + x)){
            return true;
          }
        }
        return false;
 
    }

  public void actionPerformed(ActionEvent e){
   
    if(walls.wall1Collision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY) || walls.wall2Collision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY) || ((IsSwordActive) && explorer.ExplorerCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY)) || ((IsScarabActive) && explorer.ExplorerCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY)) || VertBlock.VertBlockCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY) || HoriBlock.HoriBlockCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY)){

       if((IsSwordActive && explorer.ExplorerCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY)) || (IsScarabActive) && explorer.ExplorerCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY)){

         if(IsScarabActive && explorer.ExplorerCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY)){
             explorer.scores+=10;
          }
         else if(IsSwordActive && explorer.ExplorerCollision(VertImageWidth-19,VertImageHeight,VertImageX+19, VertImageY)){
            explorer.scores-=10;

            if(explorer.scores<=0)
                 explorer.scores=0;
         }

          VertImageX=2948;
          VertImageY=2308;

       }
       else{ 
        VelocityY=-VelocityY;

          try{
               VertMummyImage=GetBufferedImageResource("Pictures/Mummy_up_strip4.png");
          }catch(Exception ex){}

            VertImageWidth = VertMummyImage.getWidth()/4;
            VertImageHeight = VertMummyImage.getHeight();
       }

   }

   if(walls.wall1Collision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY) || walls.wall2Collision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY) || ((IsSwordActive) && explorer.ExplorerCollision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY)) || ((IsScarabActive) && explorer.ExplorerCollision(HoriImageWidth-19,HoriImageHeight,HoriImageX+15, HoriImageY)) || VertBlock.VertBlockCollision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY) || HoriBlock.HoriBlockCollision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY) ){

      if((IsSwordActive && explorer.ExplorerCollision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY)) || (IsScarabActive && explorer.ExplorerCollision(HoriImageWidth-15,HoriImageHeight,HoriImageX+15, HoriImageY))){

       if(IsScarabActive && explorer.ExplorerCollision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY)){
          explorer.scores+=10;
        }
       else if(IsSwordActive && explorer.ExplorerCollision(HoriImageWidth-19,HoriImageHeight,HoriImageX+19, HoriImageY)){
          explorer.scores-=10;

          if(explorer.scores<=0)
            explorer.scores=0;
       }

        HoriImageX=2948;
        HoriImageY=2308;

      }
      else{
       VelocityX=-VelocityX;
          try{
             horiMummyImage=GetBufferedImageResource("Pictures/Mummy_left_strip4.png");
          }catch(Exception ex){}

          HoriImageWidth = horiMummyImage.getWidth()/4;
          HoriImageHeight = horiMummyImage.getHeight();
      }
   }

   VertImageY+=VelocityY;

   HoriImageX+=VelocityX;

   repaint();

  }
}
