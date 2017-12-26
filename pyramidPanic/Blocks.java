package pyramidPanic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Blocks extends PyramidPanicGame implements ActionListener {
    Timer timer=new Timer(5,this);

    private int VelocityX=4;
    private int VelocityY=4;

    private Image vertBlockImage;
    private Image horiBlockImage;

    private int VertBlockX,VertBlockY;

   private int VertBlockWidth;
   private int VertBlockHeight;

   private int HoriBlockX;
   private int HoriBlockY;

   private int HoriBlockWidth;
   private int HoriBlockHeight;

   Blocks(Image VertBlockImage,int vertBlockX,int vertBlockY){
      vertBlockImage=VertBlockImage;

      VertBlockX=vertBlockX;
      VertBlockY=vertBlockY;

      VertBlockWidth=vertBlockImage.getWidth(null);
      VertBlockHeight=vertBlockImage.getHeight(null);
    }
      
    Blocks(int horiBlockX,int horiBlockY,Image HoriBlockImage){
      horiBlockImage=HoriBlockImage;

      HoriBlockX=horiBlockX;
      HoriBlockY=horiBlockY;

      HoriBlockWidth=horiBlockImage.getWidth(null);
      HoriBlockHeight=horiBlockImage.getHeight(null);
    }
    
    public void DrawVertBlock(Graphics g,ImageObserver ImgObs){
      g.drawImage(vertBlockImage,VertBlockX,VertBlockY,ImgObs);
      timer.start();
    }

     public void DrawHoriBlock(Graphics g,ImageObserver ImgObs){
      g.drawImage(horiBlockImage,HoriBlockX,HoriBlockY,ImgObs);
      timer.start();
    }

  public boolean VertBlockCollision(int width, int height, int x, int y) {

     if((VertBlockHeight + VertBlockY > y) && (VertBlockY < height + y)){
      if((VertBlockWidth + VertBlockX > x) && (VertBlockX < width + x)){
        return true;
      }
     }
     return false;
  }   

  public boolean HoriBlockCollision(int width, int height, int x, int y) {

     if((HoriBlockHeight + HoriBlockY > y) && (HoriBlockY < height + y)){
      if((HoriBlockWidth + HoriBlockX > x) && (HoriBlockX < width + x)){
        return true;
      }
     }
     return false;
  }   

  public void actionPerformed(ActionEvent e){

    if(explorer.ExplorerCollision(VertBlockWidth-19,VertBlockHeight,VertBlockX+19, VertBlockY)){
      BlockSound.play();

      VertBlockY+=VelocityY;

      repaint();

     }
     else if(!(explorer.ExplorerCollision(VertBlockWidth-19,VertBlockHeight,VertBlockX+19, VertBlockY))){
        VertBlockX=1320;
        VertBlockY=720;
      }

     if(explorer.ExplorerCollision(HoriBlockWidth-19,HoriBlockHeight,HoriBlockX+19, HoriBlockY)){
      BlockSound.play();

      HoriBlockX+=VelocityX;

      repaint();
     }else if(!(explorer.ExplorerCollision(HoriBlockWidth-19,HoriBlockHeight,HoriBlockX+19, HoriBlockY))){
        HoriBlockX=478;
        HoriBlockY=1022;
     }
       
    }
}
