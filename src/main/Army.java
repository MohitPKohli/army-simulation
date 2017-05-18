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

	public void setNumFootSoldiers(int numFootSoldiers) {
		this.numFootSoldiers = numFootSoldiers;
	}

	public void setNumTanks(int numTanks) {
		this.numTanks = numTanks;
	}

	public void setNumPlanes(int numPlanes) {
		this.numPlanes = numPlanes;
	}

	public String toString() {
		return "Army has: " + numFootSoldiers + " foot soldiers, " + numTanks
		 	    + " tanks, and " + numPlanes + " planes.";

	}
}