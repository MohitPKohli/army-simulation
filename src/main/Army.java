import java.lang.Math;

public class Army {
	private int numFootSoldiers;
	private int numTanks;
	private int numPlanes;

	public Army() {
		this(0, 0, 0);
	}

	public Army(int numFootSoldiers, int numTanks, int numPlanes) {
		this.numFootSoldiers = numFootSoldiers;
		this.numTanks = numTanks;
		this.numPlanes = numPlanes;
	}

	public boolean isDefeated() {
		return (numFootSoldiers == 0 && numTanks == 0 && numPlanes == 0);
	}

	public int getNumFootSoldiers() {
		return numFootSoldiers;
	}

	public int getNumTanks() {
		return numTanks;
	}
	
	public int getNumPlanes() {
		return numPlanes;
	}

	public void takeDamage(int footSoldiersDamage, int tanksDamage, int planesDamage) {
		numFootSoldiers = Math.max(numFootSoldiers - footSoldiersDamage, 0);
		numTanks = Math.max(numTanks - tanksDamage, 0);
		numPlanes = Math.max(numPlanes - planesDamage, 0);
	}

	public String toString() {
		return numFootSoldiers + " foot soldiers, " + numTanks
		 	    + " tanks, and " + numPlanes + " planes.";

	}
}