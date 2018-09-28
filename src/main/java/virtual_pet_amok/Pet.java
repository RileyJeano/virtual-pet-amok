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

	public Pet(String name) {
		this.name = name;
		this.happiness = 0;
		this.boredom = 0;
		this.health = 100;
		this.description = generateDescription();
		this.species = generateSpecies();
	}

	private String generateSpecies() {
		String[] speciesList = { "dog", "cat" };
		int rand = (int) Math.random() * speciesList.length;
		String species = speciesList[rand];
		return species;
	}

	public Pet(String name, String species) {
		this.name = name;
		this.name = name;
		this.happiness = 0;
		this.boredom = 0;
		this.health = 100;
		this.description = generateDescription();
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

	// TODO this doesn't make sense
	public String generateDescription() {
		String[] list1 = { "smooth pebble", "skipping stone", "mossy boulder", "solid rock", "shambling pile of gravel",
				"crumbling slab of stone", "hefty boulder", "stony tablet", "solid edifice" };
		String[] list2 = { "smells", "tastes", "looks", "seems", "sounds", "feels", "comes across",
				"gives off the impression", "pretends" };
		String[] list3 = { "it was a president in a past life. Maybe Abraham Lincoln.", "the sea breeze.",
				"it once took part in a landslide.", "it yearns to be free.",
				"it taught itself how to walk. And run. Quickly.", "it used to live in Hollywood.",
				"it knows something personal about you, but won't say what.",
				"it learned how to cook really nice meals, but never does.", "it spends way too much on its coffee.",
				"it enjoys the finer things in life.", "it knows how to do trigonometry.", "it can drive stick shift.",
				"it has more friends than you do.", "it was skipped across many lakes as a child", "a riddle",
				"the sidewalk after a rainstorm" };
		Random randNum = new Random();
		int rand1 = randNum.nextInt(list1.length);
		String noun1 = list1[rand1];
		randNum = new Random();
		int rand2 = randNum.nextInt(list2.length);
		String verb = list2[rand2];
		randNum = new Random();
		int rand3 = randNum.nextInt(list3.length);
		String noun2 = list3[rand3];
		return "This " + noun1 + " " + verb + " like " + noun2;
	}

	public void playWithPet() {
		boredom -= 3;
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

	public boolean isDead() {
		return dead;
	}

}