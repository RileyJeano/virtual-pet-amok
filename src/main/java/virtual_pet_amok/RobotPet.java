package virtual_pet_amok;

public class RobotPet extends Pet implements Walkable {

	private int rust;

	public RobotPet(String newName) {
		super(newName);
		this.rust = 0;

	}

	public RobotPet(String newName, String species) {
		super(newName, species);
		this.rust = 0;

	}

	public RobotPet(String newName, int happiness, int boredom, int health, int rust) {
		super(newName, happiness, boredom, health);
		this.rust = rust;

	}

	public int getRust() {
		return rust;
	}

	public void oil() {
		rust = rust - 4;
		System.out.println("BOOP");
		// setHealth(getHealth() + 4);
	}

	@Override
	public void tick() {
		setHealth(healthAlgorithm());
		rust++;
		increaseBoredom(1);
	}

	public int healthAlgorithm() {
		return getHealth() - (getBoredom() / 2) - (rust / 2) + (getHappiness());
	}

	public void walk() {
		if (getSpecies().contains("dog")) {
			rust -= 4;
			increaseHappiness(3);
		}
	}

	@Override
	public String displayStats() {
		return getName() + "\r" + getDescription() + "\r|| Happiness: " + getHappiness() + " || Health " + getHealth()
				+ " || Boredom " + getBoredom() + "|| Rust " + rust;

	}

}