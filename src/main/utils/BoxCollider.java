package main.utils;

import processing.core.PApplet;
import processing.core.PVector;

public class BoxCollider {
   PApplet parent; 
   PVector pos;
   PVector size;
   
   public BoxCollider(PApplet parent,PVector pos,PVector size){
	   this.pos=pos;
	   this.size=size;
   }
   public boolean isCollided(BoxCollider b){
	   return(pos.x<b.pos.x+b.size.x
			   && pos.x+size.x>b.pos.x
			   && pos.y<b.pos.y+b.size.y
			   &&pos.y+size.y>b.pos.y);	      
   }
   //çarpışıp,çarpışmadığını kontrol ettik.//
   public void moveCollider(PVector pos){
	   this.pos=pos;
	   
   }
   public void showCollider(){
	   parent.push();
	   parent.stroke(0,255,0);
	   parent.noFill();
	   parent.rect(pos.x,pos.y,size.x,size.y);
	   //
       parent.pop();
   }
   
 
 
 
 
}
