package pyramidPanic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Potions extends PyramidPanicGame{     

    private ArrayList<DrawPotions> potion = new ArrayList<>();

    Potions() {

       PlacePotionsOnMapBackground();

    }


    public void PlacePotionsOnMapBackground(){

            potion.add(new DrawPotions(1100, 500));
            potion.add(new DrawPotions(70,350));

    }

    public void drawPotions(Graphics g, ImageObserver ImgObs) {

        int i=0;
        while(i < potion.size()) {
            potion.get(i).DrawPotion(g, ImgObs);
            i++;
        }

    }

    public boolean potionsCollision(int width, int height, int x, int y) {
        int i=0;
       while(i < potion.size()) {
            if (potion.get(i).PotionCollision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }
}
