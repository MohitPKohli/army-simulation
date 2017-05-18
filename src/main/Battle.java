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
		if isFinished()
			return;
		calculateDamage(army1, army2);
	}

	private void calculateDamage(Army a1, Army a2) {
		
	}
}