package assignment4;

import java.awt.Color;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;

public class CookieClicker {

	public static void main(String[] args) {
		StdDraw.setPenColor(214, 166, 24);
		StdDraw.filledCircle(0.5,0.5,0.3);
		StdDraw.text(0.5, 0.95, "Cookie Clicker!");
		StdDraw.text(0.9, 0.2, "Cookie Counter:");

		int clickPower = 1;
		int powerUpCost = 20;
		double powerUpX = 0.7;
		double powerUpY = 0.9;
		StdDraw.text(powerUpX, powerUpY, "Buy Power-Up: " + powerUpCost + " cookies");

		int idlePower = 1;
		int idlePowerCost = 100;
		double idlePowerX = 0.2;
		double idlePowerY = 0.9;
		StdDraw.text(idlePowerX, idlePowerY, "Buy Power-Up: " + idlePowerCost + " cookies");

		int count = 0;
		for (int numChocChips = 0; numChocChips < 5; numChocChips++) {
			double x = (Math.random() * 0.424) + 0.288;
			double y = (Math.random() * 0.424) + 0.288;
			StdDraw.setPenRadius(0.05);
			StdDraw.setPenColor(81, 52, 29);	
			StdDraw.point(x,y);
		} 
		boolean playingGame = true;
		long previousTime = System.currentTimeMillis();
		while (playingGame) {

			long currentTime = System.currentTimeMillis();
			if (currentTime - previousTime >= 1000) {
				count += idlePower;
				previousTime = currentTime;
				StdDraw.setPenColor(214, 166, 24); 
				StdDraw.filledRectangle(0.9, 0.1, 0.05, 0.05);
				StdDraw.setPenColor(0, 0, 0);
				StdDraw.text(0.9, 0.1, Integer.toString(count));
			}

			if (StdDraw.isMousePressed()) {
				double mouseX = StdDraw.mouseX();
                double mouseY = StdDraw.mouseY();
				if (((mouseX-0.5)*(mouseX-0.5)) + ((mouseY-0.5)*(mouseY-0.5)) <= 0.3*0.3) {
					count += clickPower;
					StdDraw.setPenColor(214, 166, 24); 
					StdDraw.filledRectangle(0.9, 0.1, 0.05, 0.05);
					StdDraw.setPenColor(0, 0, 0);
					StdDraw.text(0.9, 0.1, Integer.toString(count));
				}

				if (mouseX >= powerUpX - 0.1 && mouseX <= powerUpX + 0.1 && mouseY >= powerUpY - 0.03 && mouseY <= powerUpY + 0.03) {
           			if (count >= powerUpCost) {
						count -= powerUpCost;
						clickPower++;
						powerUpCost += 20;
						StdDraw.setPenColor(214, 166, 24); 
						StdDraw.filledRectangle(0.9, 0.1, 0.05, 0.05);
						StdDraw.setPenColor(0, 0, 0);
						StdDraw.text(0.9, 0.1, Integer.toString(count));

						StdDraw.setPenColor(214, 166, 24);
                		StdDraw.filledRectangle(powerUpX, powerUpY, 0.1, 0.03);
                		StdDraw.setPenColor(0, 0, 0);
                		StdDraw.text(powerUpX, powerUpY, "Buy Power-Up: " + powerUpCost + " cookies");
					}
				}

				if (mouseX >= idlePowerX - 0.1 && mouseX <= idlePowerX + 0.1 && mouseY >= idlePowerY - 0.03 && mouseY <= idlePowerY + 0.03) {
           			if (count >= idlePowerCost) {
						count -= idlePowerCost;
						idlePower++;
						idlePowerCost *= 2;
						StdDraw.setPenColor(214, 166, 24); 
						StdDraw.filledRectangle(0.9, 0.1, 0.05, 0.05);
						StdDraw.setPenColor(0, 0, 0);
						StdDraw.text(0.9, 0.1, Integer.toString(count));
						
						StdDraw.setPenColor(214, 166, 24);
                		StdDraw.filledRectangle(idlePowerX, idlePowerY, 0.1, 0.03);
                		StdDraw.setPenColor(0, 0, 0);
                		StdDraw.text(idlePowerX, idlePowerY, "Buy Power-Up: " + idlePowerCost + " cookies");
					}
				}
			}

			StdDraw.pause(80);
		}
		
	}
}
