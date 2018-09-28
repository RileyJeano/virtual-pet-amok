package virtual_pet_amok;

public class Dog extends OrganicPet implements Walkable {

	private int poopRate;
	private int poopLevel;

	public Dog(String name) {
		super(name);
		poopRate = 1;
		poopLevel = 0;
	}

	public Dog(String name, int happiness, int boredom, int health, int hunger, int thirst) {
		super(name, happiness, boredom, health, hunger, thirst);
	}

	@Override
	public void tick() {
		setHealth(healthAlgorithm());
		poopLevel += poopRate;
		poopRate += 1;
		increaseHunger(1);
		increaseThirst(1);
		increaseBoredom(1);
	}

	public int getPoopRate() {
		return poopRate;
	}

	public int getPoopLevel() {
		return poopLevel;
	}

	public void walk() {
		poopRate -= 3;
		increaseHappiness(3);
	}

	public void cleanCage() {
		poopLevel = 0;
	}

	public int healthAlgorithm() {
		return getHealth() - ((getThirst() - 5) - (getHunger() - 3) - (getBoredom() - 10) - (poopLevel))
				+ (getHappiness() * 2);
	}
}
