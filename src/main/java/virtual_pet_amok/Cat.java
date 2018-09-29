package virtual_pet_amok;

public class Cat extends OrganicPet {
	private static int poopLevel;
	private final int POOP_RATE = 1;

	public Cat(String name) {
		super(name);
		setSpecies("cat");
	}

	public Cat(String name, String species) {
		super(name, species);
	}

	public Cat(String name, int happiness, int boredom, int health, int hunger, int thirst) {
		super(name, happiness, boredom, health, hunger, thirst);
	}

	@Override
	public void tick() {
		setHealth(healthAlgorithm());
		poopLevel += POOP_RATE;
		increaseHunger(1);
		increaseThirst(1);
		increaseBoredom(1);
	}

	public int getPoopLevel() {
		return poopLevel;
	}

	public void cleanBox() {
		poopLevel = 0;
	}

	public int healthAlgorithm() {
		return getHealth() - ((getThirst() - 5) - (getHunger() - 3) - (getBoredom() - 10) - (poopLevel))
				+ (getHappiness() * 2);
	}

	@Override
	public String displayStats() {
		return getName() + "\r" + getDescription() + "\r|| Happiness: " + getHappiness() + " ||Health " + getHealth()
				+ " ||Boredom " + getBoredom() + "\r|| Hunger " + getHunger() + " || Thirst " + getThirst()
				+ " || Poop Level " + poopLevel;

	}
}
