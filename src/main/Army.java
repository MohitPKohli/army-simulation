import java.lang.Math;

/**
 * The Army class represents an army with variable amounts of foot soldiers, tanks,
 * and planes. 
 * @author  Mohit Kohli
 * @version 1.0, May 2017
 */
public class Army {
	private int numFootSoldiers;
	private int numTanks;
	private int numPlanes;

	/**
	  * Constructor.
	  * 
	  * @param numFootSoldiers (required) The int number of foot soldiers in the army. 
	  * @param numTanks (required) The int number of tanks in the army.
	  * @param numPlanes (required) The int number of planes in the army.
	  */
	public Army(int numFootSoldiers, int numTanks, int numPlanes) {
		this.numFootSoldiers = numFootSoldiers;
		this.numTanks = numTanks;
		this.numPlanes = numPlanes;
	}

	/**
	 * Returns boolean that describes whether the army is defeated or not. This function
	 * assumes that an army is defeated only if it has 0 of each unit.
	 *
	 * @return true if the army is defeated
	 */
	public boolean isDefeated() {
		return (numFootSoldiers == 0 && numTanks == 0 && numPlanes == 0);
	}

	/**
	 * @return current number of foot soldiers
	 */
	public int getNumFootSoldiers() {
		return numFootSoldiers;
	}

	/**
	 * @return current number of tanks
	 */
	public int getNumTanks() {
		return numTanks;
	}
	
	/**
	 * @return current number of planes
	 */
	public int getNumPlanes() {
		return numPlanes;
	}

	/**
	  * Deals damage to the army in terms of net loss for each unit.
	  * 
	  * @param footSoldiersDamage (required) The int number of foot soldiers the army loses. 
	  * @param tanksDamage (required) The int number of tanks the army loses.
	  * @param planesDamage (required) The int number of planes the army loses.
	  */
	public void takeDamage(int footSoldiersDamage, int tanksDamage, int planesDamage) {
		numFootSoldiers = Math.max(numFootSoldiers - footSoldiersDamage, 0);
		numTanks = Math.max(numTanks - tanksDamage, 0);
		numPlanes = Math.max(numPlanes - planesDamage, 0);
	}

	/**
	 * Converts the Army object to String format by returning the amounts of each
	 * unit that the army has.
	 *
	 * @return the String representation of the Battle object.
	 */
	public String toString() {
		return numFootSoldiers + " foot soldiers, " + numTanks
		 	    + " tanks, and " + numPlanes + " planes.";

	}
}