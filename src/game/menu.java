package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle resumeButton = new Rectangle(Game.WIDTH + 120, 150, 100, 50);
	public Rectangle inventoryButton = new Rectangle(Game.WIDTH + 120, 250, 100, 50);
	public Rectangle statsButton = new Rectangle(Game.WIDTH + 120, 350, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH + 120, 450, 100, 50);
	
     public void render(Graphics g){
    	 Graphics2D g2d = (Graphics2D) g;
    	 
    	 Font fnt0 = new Font("arial", Font.BOLD, 50);
    	 g.setFont(fnt0);
    	 g.setColor(Color.white);
    	 g.drawString("Wrath of the Ascendant", Game.WIDTH / 2, 100);
    	 
    	 Font fnt1 = new Font("arial", Font.BOLD, 30);
    	 g.setFont(fnt1);
    	 g.drawString("Resume", resumeButton.x + 19, resumeButton.y + 30);
    	 g2d.draw(resumeButton);
    	 g.drawString("Inventory", inventoryButton.x + 19, inventoryButton.y + 30);
    	 g2d.draw(inventoryButton);
    	 g.drawString("Stats", statsButton.x + 19, statsButton.y + 30);
    	 g2d.draw(statsButton);
    	 g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
    	 g2d.draw(quitButton);
     }
}
