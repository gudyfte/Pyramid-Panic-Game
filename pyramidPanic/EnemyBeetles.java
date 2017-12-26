package pyramidPanic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class EnemyBeetles extends PyramidPanicGame{     

    private ArrayList<DrawEnemyBeetles> beetle = new ArrayList<>();

    EnemyBeetles() {

       PlaceBeetlesOnMapBackground();

    }


    public void PlaceBeetlesOnMapBackground(){
          for(int i=30;i<=70;i+=40){
            beetle.add(new DrawEnemyBeetles(40+i, 350));
          }

          for(int i=60;i<=240;i+=60){
            beetle.add(new DrawEnemyBeetles(110+i,590));
          }

    }

    public void drawBeetles(Graphics g, ImageObserver ImgObs) {

        int i=0;
        while(i < beetle.size()) {
            beetle.get(i).DrawBeetle(g, ImgObs);
            i++;
        }

    }

    public boolean beetlesCollision(int width, int height, int x, int y) {
        int i=0;
       while(i < beetle.size()) {
            if (beetle.get(i).BeetleCollision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }
}
