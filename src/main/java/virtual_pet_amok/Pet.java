package virtual_pet_amok;

import java.util.Random;

public class Pet {

	private String name;
	private String description;
	private boolean dead = false;
	private int happiness;
	private int boredom;
	private int health;
	private String species;

	public Pet(String name, int happiness, int boredom, int health) {
		this.name = name;
		this.happiness = happiness;
		this.boredom = boredom;
		this.health = health;
		this.description = generateDescription();
	}

	public Pet(String name, String species, String description, int happiness, int boredom, int health) {
		this.name = name;
		this.happiness = happiness;
		this.boredom = boredom;
		this.health = health;
		this.species = species;
		this.description = description;
	}

	public Pet(String name) {
		this.name = name;
		this.happiness = 0;
		this.boredom = 0;
		this.health = 100;
		this.description = generateDescription();

	}

	public Pet(String name, String species) {
		this.name = name;
		this.name = name;
		this.happiness = 0;
		this.boredom = 0;
		this.health = 100;
		this.species = species;
		this.description = generateDescription();
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isGameOver() {
		return dead;
	}

	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}

	public int getHappiness() {
		return happiness;
	}

	public void increaseHappiness(int amount) {
		happiness += amount;
	}

	public int getBoredom() {
		return boredom;
	}

	public void increaseBoredom(int amount) {
		boredom += amount;
	}

	public String getDescription() {

		return description;
	}

	public String generateDescription() {
		String[] list1 = { "with big eared", "with  floppy ears", "with a long tail", "with spots", "with a smile",
				"with stripes", "with big paws", "with a pink nose", "with mismatched eyes" };
		String[] list2 = { "smells like", "tastes like", "looks like", "seems like", "sounds like", "feels like",
				"comes across like", "gives off the impression that", "pretends that" };
		String[] list3 = { "it is really a fish.", "it is the sea foam.", "it has been up to something.",
				"it is really excited to see you.", "it is covered in mud.", "it used to live in the woods.",
				"it knows something personal about you, but won't say what.", "it is plotting something.",
				"it spends way too much on its coffee.", "it enjoys the finer things in life.",
				"it knows how to do trigonometry.", "it can drive stick shift.", "it has more friends than you do.",
				"it knows what its doing with its life.", "it can speak three languages.", "it is the forest floor" };
		Random randNum = new Random();
		int rand1 = randNum.nextInt(list1.length);
		String noun1 = list1[rand1];
		randNum = new Random();
		int rand2 = randNum.nextInt(list2.length);
		String verb = list2[rand2];
		randNum = new Random();
		int rand3 = randNum.nextInt(list3.length);
		String noun2 = list3[rand3];
		return "This " + getSpecies() + " " + noun1 + " " + verb + " like " + noun2;

	}

	public void playWithPet() {
		boredom -= 3;
		happiness += 3;
	}

	public String getSpecies() {
		return species;
	}

	public boolean getDead() {
		return dead;
	}

	public void toggleDeath() {
		dead = !dead;

	}

	public void tick() {

	}

	public void isDead() {
		if (health <= 0) {
			toggleDeath();
		}
	}

	public String displayStats() {
		return "WHHHAAAT";

	}
}