public class Army {
	private int numFootSoldiers;
	private int numTanks;
	private int numPlanes

	public Army() {
		this(0, 0, 0);
	}

	public Army(int numFootSoldiers, int numTanks, int numPlanes) {
		this.numFootSoldiers = numFootSoldiers;
		this.numTanks = numTanks;
		this.numPlanes = numPlanes;
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

	public void setNumFootSoldiers(numFootSoldiers) {
		this.numFootSoldiers = numFootSoldiers;
	}

	public void setNumTanks(numTanks) {
		this.numTanks = numTanks;
	}

	public void setNumPlanes(numPlanes) {
		this.numPlanes = numPlanes;
	}