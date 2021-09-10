package kr.green.game2;

public class Game {
	public static void main(String[] args) {
		Marine marine = new Marine();
		Unit   tank = new Tank();
		Dropship dropship = new Dropship();
		
		Unit[] units = {marine, tank, dropship};
		
		for(Unit unit : units) unit.move(10, 10);

		System.out.println();
		
		for(Unit unit : units) unit.stop();
				
	}
}
