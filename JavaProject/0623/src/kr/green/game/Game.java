package kr.green.game;

public class Game {
	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank   tank = new Tank();
		Dropship dropship = new Dropship();
		
		marine.stop();
		tank.stop();
		dropship.stop();
				
	}
}
