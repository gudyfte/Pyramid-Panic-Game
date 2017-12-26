package pyramidPanic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Scarabs extends PyramidPanicGame{     

    private ArrayList<DrawScarabs> scarab=new ArrayList<>();

    Scarabs() {

       PlaceScarabsOnMapBackground();

    }


    public void PlaceScarabsOnMapBackground(){

       scarab.add(new DrawScarabs(950,900));

       scarab.add(new DrawScarabs(1050,900));

       scarab.add(new DrawScarabs(1080,900));

       scarab.add(new DrawScarabs(1110,900));

       scarab.add(new DrawScarabs(1140,900));

       scarab.add(new DrawScarabs(850,460));

       scarab.add(new DrawScarabs(850,500));

       scarab.add(new DrawScarabs(850,540));
    }

    public void drawScarabs(Graphics g, ImageObserver ImgObs) {

        int i=0;
        while(i < scarab.size()) {
            scarab.get(i).DrawScarab(g, ImgObs);
            i++;
        }
    }

     public boolean scarabsCollision(int width, int height, int x, int y) {
        int i=0;
       while(i < scarab.size()) {
            if (scarab.get(i).ScarabCollision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }

}
