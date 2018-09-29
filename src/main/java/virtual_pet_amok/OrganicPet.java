package virtual_pet_amok;

public class OrganicPet extends Pet {
	public int deathDiscription = 0;
	private int hunger;
	private int thirst;

	public OrganicPet(String name, int happiness, int boredom, int health, int hunger, int thirst) {
		super(name, happiness, boredom, health);

		this.hunger = hunger;
		this.thirst = thirst;
	}

	public OrganicPet(String name, String species, String description, int happiness, int boredom, int health,
			int hunger, int thirst) {
		super(name, species, description, happiness, boredom, health);

		this.hunger = hunger;
		this.thirst = thirst;
	}

	public OrganicPet(String name) {
		super(name);
		this.hunger = 5;
		this.thirst = 5;
	}

	public OrganicPet(String name, String species) {
		super(name, species);
		this.hunger = 5;
		this.thirst = 5;
	}

	public int getHunger() {
		return hunger;
	}

	public void increaseHunger(int amount) {
		hunger += amount;
	}

	public int getThirst() {
		return thirst;
	}

	public void increaseThirst(int amount) {
		thirst += amount;
	}

	public void feedPet() {
		hunger -= 3;
	}

	public void waterPet() {
		thirst -= 3;
	}

}