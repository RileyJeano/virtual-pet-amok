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

	public boolean isDead() {
		return getDead();
	}

	public void oil() {
		setHealth(getHealth() + 4);
	}

	@Override
	public void tick() {
		setHealth(healthAlgorithm());
		increaseBoredom(1);
	}

	public int healthAlgorithm() {
		return getHealth() - ((getBoredom() - 5) - (rust - 5)) + (getHappiness());
	}

	public void walk() {
		if (getSpecies().equals("dog")) {
			rust -= 4;
			increaseHappiness(3);
		}
	}

}
