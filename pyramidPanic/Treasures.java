package pyramidPanic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Treasures extends PyramidPanicGame{     

    private ArrayList<DrawTreasures> treasure1 = new ArrayList<>();
    private ArrayList<DrawTreasures> treasure2=new ArrayList<>();

    Treasures() {

       PlaceTreasuresOnMapBackground();

    }


    public void PlaceTreasuresOnMapBackground(){
       int BorderX=1476;
       int BorderY=1156;

        int i=0;
        while(i<BorderY/31){

         for(int j=-710;j<=-110;j+=30){
            treasure1.add(new DrawTreasures(BorderX/2+j, i * (BorderY)+1060));
          }


         for(int j=-20;j<=280;j+=30){
            treasure2.add(new DrawTreasures(BorderX/2+j, i * (BorderY)+1000));
          }

           for(int j=363;j<=663;j+=30){
           
            treasure1.add(new DrawTreasures(i*(BorderY)-528,BorderX/2-j));
            treasure1.add(new DrawTreasures(i*(BorderY)-558,BorderX/2-j));
            treasure1.add(new DrawTreasures(i*(BorderY)-588,BorderX/2-j));
            treasure2.add(new DrawTreasures(i*(BorderY)-618,BorderX/2-j));
            treasure2.add(new DrawTreasures(i*(BorderY)-648,BorderX/2-j));
            treasure2.add(new DrawTreasures(i*(BorderY)-168,BorderX/2-j));
            treasure1.add(new DrawTreasures(i*(BorderY)-138,BorderX/2-j));
            treasure2.add(new DrawTreasures(i*(BorderY)-108,BorderX/2-j));
            treasure2.add(new DrawTreasures(i*(BorderY)-78,BorderX/2-j));
           }

           for(int j=-710;j<=580;j+=30){
             treasure1.add(new DrawTreasures(BorderX/2+j, i * (BorderY)+620));
           }

         i++;
       }

    }

    public void drawTreasures(Graphics g, ImageObserver ImgObs) {

        int i=0;
        while(i < treasure1.size()) {
            treasure1.get(i).DrawTreasure1(g, ImgObs);
            i++;
        }

        int j=0;
        while(j < treasure2.size()) {
            treasure2.get(j).DrawTreasure2(g, ImgObs);
            j++;
        }

    }

    public boolean treasure1Collision(int width, int height, int x, int y) {
        int i=0;
       while(i < treasure1.size()) {
            if (treasure1.get(i).Treasure1Collision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }

    public boolean treasure2Collision(int width, int height, int x, int y) {
        int i=0;
       while(i < treasure2.size()) {
            if (treasure2.get(i).Treasure2Collision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }

}
