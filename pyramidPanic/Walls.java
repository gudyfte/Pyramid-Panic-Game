package pyramidPanic;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Walls extends PyramidPanicGame{     

    private ArrayList<DrawWalls> wall1 = new ArrayList<>();
    private ArrayList<DrawWalls> wall2=new ArrayList<>();

    Walls() {

       PlaceWallsOnMapBackground();

    }


    public void PlaceWallsOnMapBackground(){
       int BorderX=1476;
       int BorderY=1156;

        int i=0;
        while(i<BorderY/31){

            wall1.add(new DrawWalls(BorderX/2+624, i * (BorderY/36)));

            wall1.add(new DrawWalls(BorderX/2-737, i * (BorderY/36)));

          for(int j=-710;j<=-110;j+=30){
            wall1.add(new DrawWalls(BorderX/2+j, i * (BorderY)));
            wall1.add(new DrawWalls(BorderX/2+j, i * (BorderY)+1083));
          }


         for(int j=-20;j<=640;j+=30){
            wall1.add(new DrawWalls(BorderX/2+j, i * (BorderY)));
            wall1.add(new DrawWalls(BorderX/2+j, i * (BorderY)+1083));
          }

          for(int j=-560;j<=190;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY) + 407 ));
          }

          for(int j=-260;j<=550;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+720));
          }

          for(int j=-555;j<=-375;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+530));
          }

          for(int j=-555;j<=-435;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+470));
          }

          for(int j=240;j<=300;j+=30){
           
           wall2.add(new DrawWalls(i*(BorderY)-793,BorderX/2-j));
           
          }

          for(int j=363;j<=663;j+=30){
           
           wall2.add(new DrawWalls(i*(BorderY)-498,BorderX/2-j));
           wall2.add(new DrawWalls(i*(BorderY)-438,BorderX/2-j));
           wall2.add(new DrawWalls(i*(BorderY)-408,BorderX/2-j));
           wall2.add(new DrawWalls(i*(BorderY)-348,BorderX/2-j));
           wall2.add(new DrawWalls(i*(BorderY)-288,BorderX/2-j));
           wall2.add(new DrawWalls(i*(BorderY)-228,BorderX/2-j));
           wall2.add(new DrawWalls(i*(BorderY)-198,BorderX/2-j));
          }

           for(int j=-255;j<=-75;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+530));
          }
          for(int j=-255;j<=-225;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+500));
          }
          for(int j=-255;j<=-195;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+470));
          }
          for(int j=-135;j<=-105;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+470));
          }

           for(int j=-135;j<=-135;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+500));
          }

           for(int j=153;j<=303;j+=30){
              wall2.add(new DrawWalls(i*(BorderY)-408,BorderX/2-j));
           }

           for(int j=41;j<=431;j+=30){
            wall2.add(new DrawWalls(BorderX/2+j, i * (BorderY)+585));
          }

          for(int j=-253;j<=13;j+=30){
          
           wall2.add(new DrawWalls(i*(BorderY)-678,BorderX/2-j));
          }
         i++;
       }

    }

    public void drawWalls(Graphics g, ImageObserver ImgObs) {

        int i=0;
        while(i < wall1.size()) {
            wall1.get(i).DrawWall1(g, ImgObs);
            i++;
        }

        int j=0;
        while(j < wall2.size()) {
            wall2.get(j).DrawWall2(g, ImgObs);
            j++;
        }
    }

    public boolean wall1Collision(int width, int height, int x, int y) {
        int i=0;
       while(i < wall1.size()) {
            if (wall1.get(i).Wall1Collision(width, height, x, y)) {
            
                return true;
            }
          i++;
        }
        return false;
    }

    public boolean wall2Collision(int width, int height, int x, int y) {
       int i=0;
       while(i < wall2.size()) {
            if (wall2.get(i).Wall2Collision(width, height, x, y)) {
            
                return true;
            }
            i++;
        }
        return false;
   }

}
