import java.util.Random;

public class Battle {
	private Army army1, army2;

	public Battle(Army army1, Army army2) {
		this.army1 = army1;
		this.army2 = army2;
	}

	public boolean isFinished() {
		return (army1.isDefeated() || army2.isDefeated());
	}

	public void step() {
		if (isFinished())
			return;
		calculateDamage();
	}

	private void calculateDamage() {
		Random r = new Random();
		double e1 = 0.5 + r.nextDouble();
		double footSoldierDamage1 = 0.1 * army2.getNumFootSoldiers() + 2 * army2.getNumTanks() + 3 * army2.getNumPlanes();
		double tankDamage1 = 0.01 * army2.getNumFootSoldiers() + 0.25 * army2.getNumTanks() + 0.2 * army2.getNumPlanes();
		double planeDamage1 = 0.01 * army2.getNumFootSoldiers() + 0.1 * army2.getNumTanks() + 0.3 * army2.getNumPlanes();

		double e2 = 0.5 + r.nextDouble();
		double footSoldierDamage2 = 0.1 * army1.getNumFootSoldiers() + 2 * army1.getNumTanks() + 3 * army1.getNumPlanes();
		double tankDamage2 = 0.01 * army1.getNumFootSoldiers() + 0.25 * army1.getNumTanks() + 0.2 * army1.getNumPlanes();
		double planeDamage2 = 0.01 * army1.getNumFootSoldiers() + 0.1 * army1.getNumTanks() + 0.3 * army1.getNumPlanes();

		army1.takeDamage((int)(e1 * footSoldierDamage1), (int)(e1 * tankDamage1), (int)(e1 * planeDamage1));
		army2.takeDamage((int)(e2 * footSoldierDamage2), (int)(e2 * tankDamage2), (int)(e2 * planeDamage2));

	}

	public String toString() {
		return "Army 1 has " + army1 + "\n"
			    + "Army 2 has " + army2;
	}
}