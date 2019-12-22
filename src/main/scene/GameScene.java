package main.scene;

import java.util.ArrayList;

import main.SpaceShooter;
import main.gameObject.Enemy;
import main.gameObject.Laser;
import main.gameObject.Player;
import main.gui.InGameUI;
import main.utils.EnemySpawner;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScene extends Scene{
	public static final String tag_player ="player";
	  public static final String tag_enemy="enemy";
	  
	  
	  
	  public static PImage bg,playerImage,enemyImage,playerLaserImage,enemyLaserImage;
	 
	  public static Player player;
	  public static ArrayList<Laser> lasers;
	  public static ArrayList<Enemy> enemies;
	  public static EnemySpawner spawner;
	  public static InGameUI inGameUI;
	public GameScene(PApplet parent) {
		super(parent);
		
	}
 @Override 
 public void init( ){ 
	   bg=parent.loadImage("res/bg.png");
	   playerImage=parent.loadImage("res/playerShip.png");
	   playerLaserImage=parent.loadImage("res/PlayerLaser.png");
	   enemyImage=parent.loadImage("res/enemyRed5.png");
	   enemyLaserImage=parent.loadImage("res/enemyLaserImage.png");
	   
	   player=new Player(parent,tag_player,playerImage,parent.width/2-playerImage.width/2,parent.height-playerImage.height,1.5f);
	   lasers= new ArrayList<Laser>();
	   enemies=new ArrayList<Enemy>();
	   spawner= new  EnemySpawner(parent,3000,1000,5);
	   
	 inGameUI= new InGameUI(parent);}
 @Override 
 protected  void update(){  player.update();
 
 for(int i=	enemies.size()-1; i>=0; i--){
	 if(enemies.get(i).health<=0){
		 enemies.remove(i);
	 }else{
		 enemies.get(i).update(); 
	 }
 }
	  for(int i=lasers.size()-1; i>=0; i--){
	    	 if(lasers.get(i).health<=0){
	    		 lasers.remove(i);
	    	 }else{
	    		 lasers.get(i).update(); 
	    	 }
 }
  spawner.update();}
 @Override 
 protected void render(){
	 SpaceShooter.wrap(parent,bg,0,0,parent.width,parent.height);
 
 
 
 for(Laser l:lasers)
 	l.render();
 for(Enemy e:enemies)
 	e.render();
   player.render();
   
   inGameUI.render();

   }
}
