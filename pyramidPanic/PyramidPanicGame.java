package pyramidPanic;

import pyramidPanic.GameKeyControls.KeyboardControl;
import pyramidPanic.GameKeyControls.KeyboardEvents;

import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.util.Observable;

public class PyramidPanicGame extends JApplet implements Runnable {

    static HashMap<Integer,String> Controls = new HashMap<>();

    static boolean IsGameFinish= false;

    static boolean IsSwordActive=false;

    private int BorderX = 1474, BorderY = 1154; 
  
    ImageObserver imgObs;

    private BufferedImage image1, image2;

    private Thread thread;

    private KeyboardEvents event;

    private KeyboardControl KeyCon;

    static MapBackground background;

    static Explorer explorer; 

    static Walls walls;
 
    private AudioClip GameMusic;

    private Image backgroundImage;

    private BufferedImage ExplorerImage;

    static AudioClip ExplorerDieSound;

    private AudioClip GameOverMusic;

    static Image WallImage1, WallImage2;

    private int ViewWindowX;
    private int ViewWindowY;

    private int ScreenWidth=648;
    private int ScreenHeight=601;

    static Image TreasureImage1;
    static Image TreasureImage2;

    static Treasures treasures;

    static Image LightImage;

    static BufferedImage BeetleImage;

    static EnemyBeetles beetles;

    private Image PanelImage;

    private Image LiveImage;

    static Image ScarabImage;

    static BufferedImage VertMummyImage,HoriMummyImage;

    private Image SwordImage;

    static Sword sword;

    static EnemyMummies mummies;

    static BufferedImage ScorpionImage;

    static EnemyScorpions scorpions;

    static Image CongratulationImage;

    static AudioClip TreasureSound;

    static AudioClip ScorpionSound;

    static AudioClip BeetleSound;

    static boolean IsScarabActive=false;

    static Scarabs scarabs;

    static int ScarabNum=0;

    static Image PotionImage;

    static Potions potions;

    static Image VertBlockImage;

    static Image HoriBlockImage;

    static AudioClip BlockSound;

    static Blocks VertBlock,HoriBlock;

    static boolean IsFail=false;

    public static void main(String[] args) {

     PyramidPanicGame game = new PyramidPanicGame();

     game.CompileProgram();

     JFrame frame = new JFrame("Pyramid Panic");
        
     frame.getContentPane().add("Center", game);

     frame.pack();

     Dimension dimension=new Dimension(648,601);

     frame.setSize(dimension);

     frame.setVisible(true);

     frame.setResizable(false);

     game.GameMusicStart();
    	
     frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e)
        {
                    System.exit(0);
        }
    });

   }

    public void CompileProgram() {

        UploadResources();

        background=new MapBackground(backgroundImage);

        int ExplorerX=670;
        int ExplorerY=10;

        explorer = new Explorer(ExplorerImage,ExplorerX,ExplorerY);

        walls=new Walls();

        treasures=new Treasures();

        beetles=new EnemyBeetles();

        mummies=new EnemyMummies();

        scorpions=new EnemyScorpions();

        scarabs=new Scarabs();

        sword=new Sword(SwordImage,1000,900);

        potions=new Potions();

        VertBlock=new Blocks(VertBlockImage,1320,720);
        HoriBlock=new Blocks(478,1022,HoriBlockImage);

        setBackground(Color.WHITE);

        this.setFocusable(true);
 
        event = new KeyboardEvents();

        event.addObserver(explorer);

        addKeyListener(new KeyboardControl(event));

        getControls();
    }

    public void UploadResources(){

        backgroundImage=GetResource("Pictures/Background2.png");

        WallImage1 = GetResource("Pictures/Wall1.png");
        WallImage2=GetResource("Pictures/Wall2.png");

         try{
          BeetleImage = GetBufferedImageResource("Pictures/Beetle_down_strip4.png");
        }catch(Exception e){}
        

       try{
	ExplorerImage = GetBufferedImageResource("Pictures/Explorer_down_strip4.png");
       }catch(Exception e){}
       
        GameMusic=GetAudioResource("Pictures/Music.mid");

        ExplorerDieSound=GetAudioResource("Pictures/Die.wav");

        GameOverMusic=GetAudioResource("Pictures/Game over.wav");

     TreasureImage1=GetResource("Pictures/Treasure1.png");
     TreasureImage2=GetResource("Pictures/Treasure2.png");

      try{
	ScorpionImage = GetBufferedImageResource("Pictures/Scorpion_right_strip4.png");
       }catch(Exception e){}

      LightImage=GetResource("Pictures/Light.png");

     PanelImage=GetResource("Pictures/Panel.png");

     LiveImage=GetResource("Pictures/Lives.png");

     ScarabImage=GetResource("Pictures/Scarab.png");

    
       try{
	VertMummyImage = GetBufferedImageResource("Pictures/Mummy_down_strip4.png");
       }catch(Exception e){}

     try{
	HoriMummyImage = GetBufferedImageResource("Pictures/Mummy_right_strip4.png");
       }catch(Exception e){}

     SwordImage=GetResource("Pictures/Sword.png");

     CongratulationImage=GetResource("Pictures/Congratulation.png");

     TreasureSound=GetAudioResource("Pictures/Treasure.wav");

     ScorpionSound=GetAudioResource("Pictures/Scorpion.wav");

     BeetleSound=GetAudioResource("Pictures/Beetle.wav");

     PotionImage=GetResource("Pictures/Potion.png");

     VertBlockImage=GetResource("Pictures/Block_vert.png");

     HoriBlockImage=GetResource("Pictures/Block_hor.png");

     BlockSound=GetAudioResource("Pictures/Block.wav");
   }

   public void getControls(){

       Controls.put(KeyEvent.VK_LEFT, "left");
        Controls.put(KeyEvent.VK_UP, "up");
        Controls.put(KeyEvent.VK_DOWN, "down");
      Controls.put(KeyEvent.VK_RIGHT, "right");
     
   }

    private AudioClip GetAudioResource(String FileName) {
        
        return newAudioClip(PyramidPanicGame.class.getResource(FileName));
    }

    public void GameMusicStart() {
        GameMusic.loop();
       
        thread=new Thread(this);
        
        thread.start();
    }

    @Override
    public void run() {
        
        if(thread==Thread.currentThread()){
         do{
            repaint();
            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
                
               System.out.println(e);
            }
         }while(thread==Thread.currentThread());
       }
    }

    public void paint(Graphics g) {

        int BorderWidth=1474;
        int BorderHeight=1154;

        Graphics2D page = BuildGraphicPage(BorderWidth, BorderHeight);
        Graphics2D outPage = BuildOuterGraphicPage(BorderWidth, BorderHeight);

        RenewPlayGame(page,imgObs,BorderWidth, BorderHeight);

        page.dispose();

        if(IsGameFinish){
          g.drawImage(image1,0,0,imgObs);
       }
        else{

           GetViewWindow();
 
            BufferedImage WindowImage=image1.getSubimage(ViewWindowX, ViewWindowY, (int)(ScreenWidth/2+398), (ScreenHeight -21));
            outPage.drawImage(WindowImage, 0, 0, imgObs);

          outPage.drawImage(PanelImage,1,540,imgObs);  

          for(int i=0;i<explorer.ExplorerLivesNum;i++){
              if(i==0){
               outPage.drawImage(LiveImage,80,540,imgObs);
              }else if(i==1){
               outPage.drawImage(LiveImage,110,540,imgObs);
              }
              else if(i==2){
                outPage.drawImage(LiveImage,140,540,imgObs);
              }else if(i==3){
                outPage.drawImage(LiveImage,170,540,imgObs);
              }else if(i==4){
                outPage.drawImage(LiveImage,200,540,imgObs);
              }
            }

           outPage.drawImage(ScarabImage,250,540,imgObs); 

           outPage.setFont(new Font("sans-serif", Font.BOLD, 20));

            outPage.setColor(Color.yellow);

            outPage.drawString(ScarabNum + "", getSize().width / 4 + 150, 565);

            outPage.setFont(new Font("sans-serif", Font.BOLD, 20));

            outPage.setColor(Color.yellow);

            outPage.drawString(explorer.scores + "", getSize().width / 4 + 400, 565);

            outPage.dispose();

            g.drawImage(image2, 0, 0, imgObs);

        }

    }

    public void GetViewWindow(){
      ViewWindowX = 30 + explorer.ExplorerX - (int)(ScreenWidth / 4 + 48);
            if (ViewWindowX < 0) {
                ViewWindowX=0;
                
            } 
            else if (BorderX < (int)(ScreenWidth/2 + 398) + ViewWindowX) {
               ViewWindowX = BorderX - (int)(ScreenWidth/2 + 398) ;
            }

            ViewWindowY = 100 + explorer.ExplorerY - (int)(ScreenHeight/2 -10) ;
            if (ViewWindowY < 0) {
                ViewWindowY=0;
            } 
            else if (BorderY < ScreenHeight - 21 + ViewWindowY) {
               ViewWindowY= BorderY - (ScreenHeight -21);
            }
    }

    public Graphics2D BuildOuterGraphicPage(int width, int height) {
        Graphics2D page = null;
        if (image2 == null || image2.getHeight() != height || image2.getWidth() != width) {
            
           image2 = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
           
        }
        page = image2.createGraphics();
        page.setBackground(getBackground());
       
        page.clearRect(0, 0, width, height);
        return page;
    }

    public Graphics2D BuildGraphicPage(int width, int height) { 
        Graphics2D page = null;
        if (image1 == null || image1.getHeight() != height || image1.getWidth() != width) {
           
            image1 = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        }
        page = image1.createGraphics();
        page.setBackground(getBackground());

        page.clearRect(0, 0, width, height);
        return page;
    }

    public void RenewPlayGame(Graphics2D gd,ImageObserver ImgObs,int width, int height) {
      
        if(IsGameFinish){

            FinishGame(gd,ImgObs);
        }
        else{

            background.DrawBackground(gd, ImgObs);

            walls.drawWalls(gd, ImgObs);

            treasures.drawTreasures(gd,ImgObs);

            beetles.drawBeetles(gd,ImgObs);

            mummies.drawMummies(gd,ImgObs);

            scorpions.drawScorpions(gd,ImgObs);

            scarabs.drawScarabs(gd,ImgObs);

            VertBlock.DrawVertBlock(gd,ImgObs);
            HoriBlock.DrawHoriBlock(gd,ImgObs);

            explorer.ExplorerMovement();
            explorer.DrawExplorer(gd, ImgObs,670,10);

          sword.DrawSword(gd,ImgObs);

          potions.drawPotions(gd,ImgObs);

        } 

    }


    public void FinishGame(Graphics2D gd,ImageObserver ImgObs){
      GameMusic.stop();
      GameOverMusic.play();
                     
      Font font = new Font("Garamond", Font.BOLD, 48);
      gd.setFont(font);

      String Result="";

      if(IsFail){
         background.DrawBackground(gd, ImgObs);

         Result="You Fail the game";

         Rectangle2D rd = font.getStringBounds(Result, gd.getFontRenderContext());

         gd.setPaint(Color.WHITE);

         int StringX=(int) ((getWidth() - rd.getWidth()) / 2);
         int StringY=(int)((getHeight() - rd.getHeight()) / 2 + (-rd.getY()));

         gd.drawString(Result, StringX, StringY);
      }
      else{
         background.DrawBackground(gd, ImgObs);

         gd.drawImage(CongratulationImage,100,200,ImgObs);
      }

    }

    public Image GetResource(String ResourceName) {
       
        Image image;

        image = getToolkit().getImage(PyramidPanicGame.class.getResource(ResourceName));

        try {
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(image, 0);
            mt.waitForID(0);
        } catch (Exception e) {
            
           System.out.println(e);
        }

        return image;
    }

    public BufferedImage GetBufferedImageResource(String ImageName) throws IOException {
       
        BufferedImage img = ImageIO.read(PyramidPanicGame.class.getResource(ImageName));
        try {
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(img, 0);
            mt.waitForID(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        return img;
    }

}
