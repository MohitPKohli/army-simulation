import java.util.Random;

/**
 * The Battle class represents a turn based battle between two armies using
 * discretized versions of Lanchaster's equations. Each Battle is only complete
 * when an army is completely destroyed. 
 * @author  Mohit Kohli
 * @version 1.0, May 2017
 */
public class Battle {
	private Army army1, army2;

	/**
	  * Constructor.
	  * 
	  * @param army1 (required) Army object representing first army. 
	  * @param army2 (required) Army object representing second army.
	  */
	public Battle(Army army1, Army army2) {
		this.army1 = army1;
		this.army2 = army2;
	}

	/**
	 * Returns boolean that describes whether the battle is finished or not.
	 *
	 * @return true if either of the armies are defeated
	 */
	public boolean isFinished() {
		return (army1.isDefeated() || army2.isDefeated());
	}

	/**
	 * Does one turn of the battle between the two armies. Uses the
	 * discretized version of Lanchaster's equations to inflict damage on
	 * each of the armies based on the current state.
	 * <p>
	 * Does nothing if the battle is already finished.
	 */
	public void step() {
		if (isFinished())
			return;
		calculateDamage();
	}

	/**
	 * Calculates and inflicts the damage on both armies using discretized versions
	 * of Lanchaster's equations.
	 * <p>
	 * Important: Neither army attacks first, because the calculations assume that both
	 * armies attack at the same time all at once.
	 */
	private void calculateDamage() {
		Random r = new Random();
		double e1 = 0.5 + r.nextDouble();
		double footSoldierDamage1 = 0.1 * army2.getNumFootSoldiers() + 2 * army2.getNumTanks() + 3 * army2.getNumPlanes();
		double tankDamage1 = 0.001 * army2.getNumFootSoldiers() + 0.25 * army2.getNumTanks() + 0.2 * army2.getNumPlanes();
		double planeDamage1 = 0.001 * army2.getNumFootSoldiers() + 0.1 * army2.getNumTanks() + 0.3 * army2.getNumPlanes();

		double e2 = 0.5 + r.nextDouble();
		double footSoldierDamage2 = 0.1 * army1.getNumFootSoldiers() + 2 * army1.getNumTanks() + 3 * army1.getNumPlanes();
		double tankDamage2 = 0.001 * army1.getNumFootSoldiers() + 0.25 * army1.getNumTanks() + 0.2 * army1.getNumPlanes();
		double planeDamage2 = 0.001 * army1.getNumFootSoldiers() + 0.1 * army1.getNumTanks() + 0.3 * army1.getNumPlanes();

		army1.takeDamage((int)(e1 * footSoldierDamage1 + 0.9), (int)(e1 * tankDamage1 + 0.75), (int)(e1 * planeDamage1 + 0.7));
		army2.takeDamage((int)(e2 * footSoldierDamage2 + 0.9), (int)(e2 * tankDamage2 + 0.75), (int)(e2 * planeDamage2 + 0.7));

	}

	/**
	 * Converts the Battle object to String format by returning the statistics
	 * of both armies.
	 *
	 * @return the String representation of the Battle object.
	 */
	public String toString() {
		return "Army 1 has " + army1 + "\n"
			    + "Army 2 has " + army2;
	}
}