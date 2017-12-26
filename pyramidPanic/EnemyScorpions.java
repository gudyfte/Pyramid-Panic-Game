package pyramidPanic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class EnemyScorpions extends PyramidPanicGame{     

    private ArrayList<DrawEnemyScorpions> scorpion=new ArrayList<>();

    EnemyScorpions() {

       PlaceScorpionsOnMapBackground();

    }


    public void PlaceScorpionsOnMapBackground(){

          for(int i=-140;i<=70;i+=30){
            scorpion.add(new DrawEnemyScorpions(190, 290+i));
          }

         for(int i=40;i<=70;i+=30){
          scorpion.add(new DrawEnemyScorpions(500,600+i));
         }
          
    }

    public void drawScorpions(Graphics g, ImageObserver ImgObs) {

        int i=0;
        while(i < scorpion.size()) {
            scorpion.get(i).DrawScorpion(g, ImgObs);
            i++;
        }

    }

      public boolean scorpionsCollision(int width, int height, int x, int y) {
        int i=0;
       while(i < scorpion.size()) {
            if (scorpion.get(i).ScorpionCollision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }

}
