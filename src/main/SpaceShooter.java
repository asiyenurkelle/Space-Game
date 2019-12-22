package main;

import main.scene.GameScene;
import processing.core.PApplet;
import processing.core.PImage;


public class SpaceShooter extends PApplet{
  public static void main(String[] args) {
	PApplet.main("main.SpaceShooter");
}
  public void settings(){
	  size(1366,768);
  }
  public static float deltaTime;
  float t1,t2;
  //t1 baþlangýç saniyemiz,22 bitiþ saniyemiz.//
  
  
  GameScene gameScene;
  
  public void setup(){
    size(1366,768);
     
    gameScene=new GameScene(this);
    gameScene.init();
    
    gameScene.updateFrame();
    
    t1=millis();
  }
 
  public void draw() {
    background(0);
    t2=millis();
    deltaTime=(t2-t1);
  
     gameScene.updateFrame();
    t1=millis();
  }

  public static void wrap(PApplet parent,PImage img, float x1, float y1, float x2, float y2){
      for(float x=x1; x<x2; x+=img.width){
        for (float y=y1; y<y2; y+=img.height){
        	parent.image(img,x,y);
        }
      }
  }
  //wrap fonksiyonuyla arkaplaný deðerleri her seferinde with with artýrarak,resmin tekrar edip ekraný kaplamasýný saðladýk.//
 public static boolean [] keys= new boolean[5];

  public void keyPressed(){
      if(key=='w'|| key == 'w' || keyCode==UP) keys[0]=true;
      if(key=='a'|| key == 'A' || keyCode==LEFT) keys[1]=true;
      if(key=='s'|| key == 'S' || keyCode==DOWN) keys[2]=true;
      if(key=='d'|| key == 'D' || keyCode==RIGHT) keys[3]=true;
      if(key== ' ') keys[4]=true;
  }
  public void keyReleased(){
      if(key=='w'|| key == 'w' || keyCode==UP) keys[0]=false;
      if(key=='a'|| key == 'A' || keyCode==LEFT) keys[1]=false;
      if(key=='s'|| key == 'S' || keyCode==DOWN) keys[2]=false;
      if(key=='d'|| key == 'D' || keyCode==RIGHT) keys[3]=false;
      if(key== ' ') keys[4]=false;
 }
}
