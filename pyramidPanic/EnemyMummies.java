package pyramidPanic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class EnemyMummies extends PyramidPanicGame{    
 
    private ArrayList<DrawEnemyMummies> vertMummy=new ArrayList<>();
    private ArrayList<DrawEnemyMummies> horiMummy=new ArrayList<>();

    EnemyMummies() {

       PlaceMummiesOnMapBackground();

    }

    public void PlaceMummiesOnMapBackground(){

         for(int i=30;i<=470;i+=40){
            vertMummy.add(new DrawEnemyMummies(500 + i, 900));
         }

       for(int i=40;i<=120;i+=40){
        horiMummy.add(new DrawEnemyMummies(HoriMummyImage,800,420+i));
       }

    }

    public void drawMummies(Graphics g, ImageObserver ImgObs) {

        int i=0;
        while(i < vertMummy.size()) {
            vertMummy.get(i).DrawVertMummy(g, ImgObs);
            i++;
        }

         int j=0;
        while(j < horiMummy.size()) {

            horiMummy.get(j).DrawHoriMummy(g, ImgObs);
            j++;
        }


    }

      public boolean vertMummiesCollision(int width, int height, int x, int y) {
        int i=0;
       while(i < vertMummy.size()) {
            if (vertMummy.get(i).VertMummyCollision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }

      public boolean horiMummiesCollision(int width, int height, int x, int y) {
        int i=0;
       while(i < horiMummy.size()) {
            if (horiMummy.get(i).HoriMummyCollision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }

}
