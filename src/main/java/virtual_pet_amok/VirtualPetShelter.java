package virtual_pet_amok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {
	private Map<String, Pet> pets = new HashMap<String, Pet>();
	private int deaths = 0;
	private boolean open = true;
	public boolean shelterCloses = false;
	public int deathDecision = 0;
	public String deadName = "";

	public void addPet(Pet newPet) {
		pets.put(newPet.getName(), newPet);
	}

	public void feedAllPets() {
		for (Pet currentPet : getPets()) {
			if (currentPet instanceof OrganicPet) {
				((OrganicPet) currentPet).feedPet();
			}
		}
	}

	public void waterAllPets() {
		for (Pet currentPet : getPets()) {
			if (currentPet instanceof OrganicPet) {
				((OrganicPet) currentPet).waterPet();
			}
		}
	}

	public void playWithAllPets() {
		for (Pet currentPet : getPets()) {
			currentPet.playWithPet();
		}
	}

	public void takeIn(String name) {
		Pet newPet = new Pet(name);
		addPet(newPet);
	}

	public Map<String, Pet> getAllPets() {
		return pets;
	}

	public void adoptOut(String petName) {
		pets.remove(petName);
	}

	public Pet getPet(String petName) {

		return pets.get(petName);

	}

	public void playWithPet(String petName) {

		getPet(petName).playWithPet();

	}

	// walk all dogs
	public void walkAllDogs() {
		for (Pet currentPet : getPets()) {
			if (currentPet instanceof Walkable) {
				((Walkable) currentPet).walk();

			}
		}
	}

	// clean a dog cage
	public void cleanAllCages() {
		for (Pet currentPet : getPets()) {
			if (currentPet instanceof Dog) {
				((Dog) currentPet).cleanCage();

			}
		}
	}

	// clean the litter boxes
	public void cleanLitterBox() {
		for (Pet currentPet : getPets()) {
			if (currentPet instanceof Cat) {
				((Cat) currentPet).cleanBox();

			}
		}
	}

	// oil all robots
	public void oilAllRobots() {
		for (Pet currentPet : getPets()) {
			if (currentPet instanceof RobotPet) {
				((RobotPet) currentPet).oil();
				System.out.println("AHHH BOOP");

			}
		}
	}

	public void tick() {

		List<String> deadList = new ArrayList<String>();
		deathDecision = 0;
		for (Entry<String, Pet> currentPet : pets.entrySet()) {
			if (deaths > 10) {
				open = false;
				shelterCloses = true;
			}

			currentPet.getValue().tick();
			currentPet.getValue().isDead();
			if (currentPet.getValue().getDead() == true) {
				deaths++;
				deadList.add(currentPet.getKey());
				deadName = currentPet.getValue().getName();
				System.out.println("Oh nooooo " + deadName + " has died! You monster!");

			}
		}
		for (String deadPet : deadList) {
			pets.remove(deadPet);

		}

	}

	public String deadName() {
		return deadName;
	}

	public boolean isOpen() {
		return open;
	}

	public boolean isEmpty() {
		return pets.isEmpty();
	}

	public Collection<Pet> getPets() {
		return pets.values();
	}

	public void generatePet(String name, String species, boolean robotitude) {
		if (robotitude) {
			RobotPet pet = new RobotPet(name, species);
			addPet(pet);
		} else {
			if (species.equalsIgnoreCase("cat")) {
				Cat pet = new Cat(name);
				addPet(pet);
				// make a cat
			} else {
				// make a dog
				Dog pet = new Dog(name);
				addPet(pet);
			}
		}

	}

	public void shutDown() {
		open = false;
	}

}