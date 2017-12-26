package pyramidPanic;

import pyramidPanic.GameKeyControls.KeyboardEvents;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.Graphics2D;

public class Explorer extends PyramidPanicGame implements Observer {

    private BufferedImage ExplorerImage;

    int ExplorerWidth, ExplorerHeight;

    int ExplorerX, ExplorerY;

    int ExplorerLifeValue=1;

    int scores = 0;

    int ExplorerLivesNum = 3; 

    private int ExplorerSpeedX = 0, ExplorerSpeedY = 0;

    Explorer(BufferedImage explorerImage,int explorerX,int explorerY) {

        ExplorerImage=explorerImage;
        
        ExplorerWidth = ExplorerImage.getWidth()/4;
        ExplorerHeight = ExplorerImage.getHeight();
        
        ExplorerX=explorerX;
        ExplorerY=explorerY;

    }

    public void DrawExplorer(Graphics g, ImageObserver ImgObs,int explorerX,int explorerY) {

        int ExplorerImgX=ExplorerWidth;
        int ExplorerImgY=0;
        int ExplorerImgW=ExplorerWidth;
        int ExplorerImgH=ExplorerHeight;

        if (ExplorerLifeValue >= 1) {

            g.drawImage(ExplorerImage.getSubimage(ExplorerImgX, ExplorerImgY, ExplorerImgW, ExplorerImgH), ExplorerX, ExplorerY, ImgObs);

            if(IsSwordActive)
              g.drawImage(LightImage,ExplorerX-80,ExplorerY-70,ImgObs);

            if((ExplorerX<670 && ExplorerY>10 && ExplorerY<=640) || (ExplorerX> 70 && ExplorerY >=640 && ExplorerY<=670))
                   ScorpionSound.play();

            if(ExplorerX>=70 && ExplorerX <=350 && ExplorerY>=350 && ExplorerY<=1070)
               BeetleSound.play();

            if(ExplorerY>=1060 && ExplorerX>=670)
              IsGameFinish=true;
        }
        else if (ExplorerLivesNum >= 1 && ExplorerLifeValue < 1) {
                
               ExplorerDie(g,ImgObs,explorerX,explorerY);

        } else {
            ExplorerDieSound.play();
            IsFail=true;
            IsGameFinish = true;
        }
    }

    public void ExplorerDie(Graphics g,ImageObserver ImgObs,int explorerX,int explorerY){

      if(ExplorerLivesNum >= 1 && ExplorerLifeValue < 1){

                ExplorerDieSound.play();

               try{
                ExplorerImage=GetBufferedImageResource("Pictures/Explorer_down_strip4.png");
               }catch(Exception e){}

               ExplorerWidth=ExplorerImage.getWidth()/4;
               ExplorerHeight=ExplorerImage.getHeight();

                ExplorerLivesNum-=1;

                ExplorerLifeValue=1;
                
               ExplorerX=explorerX;
               ExplorerY=explorerY;
           
      }
   }

    public boolean ExplorerCollision(int width, int height, int x, int y) {

        if((ExplorerHeight + ExplorerY > (y+6)) && (ExplorerY < (height-16) + (y+6))){
          if((ExplorerWidth + ExplorerX > (x+6)) && (ExplorerX < (width-11) + (x+6))){
            return true;
          }
        }
        return false;
      
    }

    public void ExplorerMovement() {

      if((!(walls.wall1Collision(ExplorerWidth,ExplorerHeight,ExplorerSpeedX+ExplorerX, ExplorerY))) &&  (!(walls.wall2Collision(ExplorerWidth,ExplorerHeight,ExplorerSpeedX+ExplorerX, ExplorerY))) && (ExplorerSpeedX + ExplorerX > 0) && (ExplorerSpeedX + ExplorerX < 1404)){

        ExplorerX=ExplorerX + ExplorerSpeedX;
      }

      if((!(walls.wall2Collision(ExplorerWidth,ExplorerHeight,ExplorerX,ExplorerSpeedY+ExplorerY))) && (!(walls.wall2Collision(ExplorerWidth,ExplorerHeight,ExplorerX, ExplorerSpeedY+ExplorerY))) && (ExplorerSpeedY + ExplorerY > 0) && (ExplorerY + ExplorerSpeedY < 1074)){

        ExplorerY=ExplorerY+ExplorerSpeedY;
      }

      if (sword.SwordCollision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {

                   IsSwordActive=true;
                }
          
      }
      else if(treasures.treasure1Collision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {
                    scores += 10;
                   TreasureSound.play();
                }

      }
       else if(treasures.treasure2Collision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {

                    scores += 10;
                    TreasureSound.play();

                }
       }

      else if(beetles.beetlesCollision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {

                    ExplorerLifeValue =ExplorerLifeValue - 1;
                   
                }
     }

     else if(mummies.vertMummiesCollision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
              if (ExplorerLifeValue > 0) {
                    if(IsSwordActive || (IsScarabActive)){

                     if(IsSwordActive)
                       IsScarabActive=false;
                    
                    }
                    else{

                     ExplorerLifeValue =ExplorerLifeValue - 1;

                   }
            }
     }

     else if(mummies.horiMummiesCollision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {
                    if(IsSwordActive || (IsScarabActive)){

                     if(IsSwordActive)
                       IsScarabActive=false;
                    
                   }
                   else{
                    ExplorerLifeValue =ExplorerLifeValue - 1;

                   }
             }
     }

     else if(scorpions.scorpionsCollision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {
                    ExplorerLifeValue =ExplorerLifeValue - 1;
                   
                }
     }

     else if(scarabs.scarabsCollision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {
                    ScarabNum+=1;
                    IsScarabActive=true;
                }
     }

     else if(potions.potionsCollision(ExplorerWidth-21, ExplorerHeight, 21+ExplorerX, ExplorerY)) {
            
                if (ExplorerLifeValue > 0) {
                    ExplorerLivesNum+=1;
                }
       }
    }

    public void UseControls(Object event){

        KeyboardEvents Key_event = (KeyboardEvents) event;

        if (Key_event.KeyEventType < 2) {

            KeyEvent ke = (KeyEvent) Key_event.events;
          
            if (Controls.get(ke.getKeyCode()).equals("left")) {

               ExplorerSpeedX = Key_event.KeyEventType * -6;

               try{
                  ExplorerImage=GetBufferedImageResource("Pictures/Explorer_left_strip4.png");
               }catch(Exception e){}

               ExplorerWidth = ExplorerImage.getWidth()/4;
               ExplorerHeight = ExplorerImage.getHeight();

            } 

            if (Controls.get(ke.getKeyCode()).equals("right")) {

                ExplorerSpeedX = Key_event.KeyEventType * 6;

                try{
                   ExplorerImage=GetBufferedImageResource("Pictures/Explorer_right_strip4.png");
                }catch(Exception e){}

               ExplorerWidth = ExplorerImage.getWidth()/4;
               ExplorerHeight = ExplorerImage.getHeight();
 
            } 

            if (Controls.get(ke.getKeyCode()).equals("up")) {

                ExplorerSpeedY = Key_event.KeyEventType * -6;

                try{
                    ExplorerImage=GetBufferedImageResource("Pictures/Explorer_up_strip4.png");
                }catch(Exception e){}

                ExplorerWidth = ExplorerImage.getWidth()/4;
                ExplorerHeight = ExplorerImage.getHeight();

            } 

           if (Controls.get(ke.getKeyCode()).equals("down")) {

                ExplorerSpeedY = Key_event.KeyEventType * 6;

                   try{
                        ExplorerImage=GetBufferedImageResource("Pictures/Explorer_down_strip4.png");
                   }catch(Exception e){}

                  ExplorerWidth = ExplorerImage.getWidth()/4;
                  ExplorerHeight = ExplorerImage.getHeight();

            }
            
        }
    }

    public void update(Observable obs, Object events) {

       UseControls(events);
    }

}
