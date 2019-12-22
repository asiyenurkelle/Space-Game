
package main.gameObject;

import main.SpaceShooter;
import main.scene.GameScene;
import main.utils.BoxCollider;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends GameObject {
	 public float speed;
	 public float cooldown = 100;
	 //cooldown iki ate� aras�ndaki beklemes�remiz ardarda ate� etmememsi i�in.//
	 public float leftTime;
	 public float level;

	public Player(PApplet parent, String tag, PImage img, float x, float y, float speed) {
		super(parent, tag, new PVector(x, y), img, 5);
		this.speed = speed;
         level=1;
		collider = new BoxCollider(parent, pos, new PVector(img.width, img.height));
		leftTime = 0;
	}

	@Override
	public void update() {
		if (health <= 0)
			PApplet.println("Died!!");

		if (leftTime > 0)
			leftTime -= SpaceShooter.deltaTime;
		

		move();

		if (SpaceShooter.keys[4])
			shoot();
		
	}

	public void move() {
		if (SpaceShooter.keys[0])
			pos.y -= speed * SpaceShooter.deltaTime;
		// hareket ederken h�z*zaman kadar yer de�i�tiririz.Y'i yerde�i�tirme kadar azaltt�k.//
		if (SpaceShooter.keys[2])
			pos.y += speed * SpaceShooter.deltaTime;
		if (SpaceShooter.keys[1])
			pos.x -= speed * SpaceShooter.deltaTime;
		if (SpaceShooter.keys[3])
			pos.x += speed * SpaceShooter.deltaTime;

		if (pos.x < 0)
			pos.x = 0;
		else if (pos.x + img.width > parent.width)
			pos.x = parent.width - img.width;

		if (pos.y < 0)
			pos.y = 0;
		else if (pos.y + img.height > parent.height)
			pos.y = parent.height - img.height;
// karakterin ekranda durmas�n� sa�lad�k ekran�n s�n�rlar�n� a�mamas� i�in.//

		collider.moveCollider(pos);
		for (Laser l : GameScene.lasers) {
			if (collider.isCollided(l.collider) && l.tag != tag) {
				health -= l.damage;
				l.health--;
			}
		}
	}

	public void shoot() {
		if (leftTime <= 0) {
			Laser laser = new Laser(parent, tag, GameScene.playerLaserImage,
					pos.x + img.width / 2 - GameScene.playerLaserImage.width / 2,
					pos.y - GameScene.playerLaserImage.height * 0.75f, -2);
			GameScene.lasers.add(laser);
			leftTime = cooldown;
		}
	}
}