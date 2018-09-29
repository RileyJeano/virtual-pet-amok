package virtual_pet_amok;

import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		VirtualPetShelter shelter = new VirtualPetShelter();

		// make some starter pets
		Cat starterPet1 = new Cat("Spork", "cat");
		Cat starterPet2 = new Cat("Spatula", "cat");
		Dog starterPet3 = new Dog("Poppyseed", "dog");
		RobotPet starterPet4 = new RobotPet("Microwave", "robot cat");
		RobotPet starterPet5 = new RobotPet("Eggbeater", "robot dog");
		shelter.addPet(starterPet1);
		shelter.addPet(starterPet2);
		shelter.addPet(starterPet3);
		shelter.addPet(starterPet4);
		shelter.addPet(starterPet5);

		Scanner input = new Scanner(System.in);

		// Bootup flavor text
		System.out.println("One day, you find yourself wanting to make a difference in the world.");
		System.out.println("While wandering and pondering your true calling, you come across a direlict building.");
		System.out.println("The sign reads \"Max and Riley's Shelter for Abandoned and Feral Pets");
		System.out.println("You go inside to find the director staring at a pen full of straw.");
		System.out.println("He looks you dead in the eyes, hands you the keys to the shelter, and walks out.");
		System.out.println("You are the director now.");

		// Main game Loop
		while (shelter.isOpen()) {
			if (shelter.isEmpty()) {

				System.out.println(
						"Every pet in your shelter has died. As you start to think this might not be the job for you,\rthe police come to your shelter and shut you down. The world's lost and abandoned pets rejoice.");

				shelter.shutDown();
			} else {
				for (Pet currentPet : shelter.getPets()) {
					System.out.println("\r" + currentPet.displayStats());
				}
				// Main choice menu
				shelterActionsMenu(input, shelter);
				shelter.tick();
			}
		}
//		if (shelter.shelterCloses == true) {
//
//			System.out.println(
//					"\nOh no! You're murderous pet rampage has caused the cops to be called. Our once proud shelter has now been closed for rock cruelty.");
//		}

		input.close();
	}

	private static void shelterActionsMenu(Scanner input, VirtualPetShelter shelter) {
		System.out.println("\r");
		System.out.println("What would you like to do? Type a choice:");
		System.out.println("ADD: Take in a new pet from the streets, where abandoned pets loiter in abundance.");
		System.out.println("ADOPT: Put one of your pets up for adoption.");
		System.out.println("FEED: Feed all pets that food.");
		System.out.println("WATER: Give water to all pets that need this particular liquid.");
		System.out.println("OIL: Give oil to all pets that need this particular liquid.");
		System.out.println("WALK: Walk all dogs or automated approximations.");
		System.out.println("PLAY: Play with every pet in the shelter.");
		System.out.println("DOG POOP: clean all dog cages.");
		System.out.println("LITTER BOX: clean the single litter box.");
		String userChoice = input.nextLine().toUpperCase();

		switch (userChoice) {
		case "ADD":
			takeInPet(input, shelter);
			break;

		case "ADOPT":
			System.out.println("Which pet would you like a loving family to adopt?");
			String petToAdopt = input.nextLine();
			if (shelter.getAllPets().containsKey(petToAdopt)) {
				shelter.adoptOut(petToAdopt);
				System.out.println(
						petToAdopt + " was carried away into the night. By a loving family.\r\r... Don't worry... :|");
			} else {
				System.out.println("Nobody named " + petToAdopt + " lives here.");
			}

			break;

		case "FEED":
			// TODO generate a random food each time?
			String[] list1 = { "pet food", "lucky charms", "oranges", "treats", "snails", "grass", "pizza", "lollypops",
					"moral abiguity", "hazelnuts", "pancakes", "paw paws", "dirt", "kit kat bars", "human souls",
					"spagetti", "wizard lizzards" };

			Random randNum = new Random();
			int rand1 = randNum.nextInt(list1.length);
			String food = list1[rand1];

			System.out.println("You break out your enormous bag of " + food);
			shelter.feedAllPets();
			break;

		case "WATER":
			// TODO generate a random drink?
			String[] list2 = { "a pitcher of water", "a glass of lemonade", "a thimble full of tea",
					"30 gallons of coffee", "a pool of pickle juice", "a vial of snail tears", "purrified pizza",
					"4 bottles of champagne", "90 bottles of champagne", "toilet water",
					"apple juice from a lemonade stand", "a thermos of hot coco" };

			Random randNum2 = new Random();
			int rand2 = randNum2.nextInt(list2.length);
			String drink = list2[rand2];
			System.out.println("You come back from the store with " + drink + ". Will it be enough?");
			shelter.waterAllPets();
			break;

		case "OIL":
			String[] list3 = { "olive", "sesame", "motor", "canola", "grapeseed", "avocado", "WD 210 engine" };

			Random randNum3 = new Random();
			int rand3 = randNum3.nextInt(list3.length);
			String oil = list3[rand3];
			System.out.println("You grab your bottle of " + oil + " oil and get to work.");
			shelter.oilAllRobots();
			break;

		case "WALK":
			System.out.println(
					"\"Who wants to go on a walk!?\" you ask excitedly. The cats don't, but you take all the dogs.");
			shelter.walkAllDogs();
			break;

		case "PLAY":
			System.out.println(
					"Using your herculean amounts of compassion, you give each and every pet the attention it deserves.\rEvery pet in the shelter appreciates that you've played with them.");
			shelter.playWithAllPets();
			break;

		case "DOG POOP":
			System.out.println(
					"You pull on your gloves and prepare consider if you should get a plumber to make dog toilets for each cage.");
			System.out.println("No.\rThis is the only way.");
			shelter.cleanAllCages();
			break;

		case "LITTER BOX":
			System.out.println("You clean the one and only litter box. It's gross, but at least there's only one box.");
			shelter.cleanLitterBox();
			break;

		default:
			System.out.println("Invalid choice.");
			break;

		}
	}

	private static void takeInPet(Scanner input, VirtualPetShelter shelter) {
		System.out.println("Please name the animal you will take in:");
		String nameChoice = input.nextLine();
		System.out.println("What kind of animal would you like to add to your shelter? Enter a number.");
		System.out.println("1: Normal Cat");
		System.out.println("2: Normal Dog");
		System.out.println("3: Robot Cat");
		System.out.println("4: Robot Dog");
		String userChoice = input.nextLine();

		Pet newPet = new Cat("Asbestos", "cat",
				"A sickly cat the color of gutter water. It has no teeth. It coughs up smoke.", 0, 4, 20, 5, 6);
		switch (userChoice) {
		case "1":
			newPet = new Cat(nameChoice, "cat");
			break;
		case "2":
			newPet = new Dog(nameChoice, "dog");
			break;
		case "3":
			newPet = new RobotPet(nameChoice, "robot cat");
			break;
		case "4":
			newPet = new RobotPet(nameChoice, "robot dog");
			break;
		default:
			System.out.println("Invalid choice");
			System.out.println("You will adopt a cat involuntarily");
			break;
		}
		shelter.addPet(newPet);
	}

}