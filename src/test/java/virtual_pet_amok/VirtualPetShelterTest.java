package virtual_pet_amok;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void shouldAddPet() {
		Dog test = new Dog("Rover");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(test);
		Assert.assertEquals(false, underTest.isEmpty());
	}

	@Test
	public void shouldAddPetAndFeedIt() {
		Dog test = new Dog("Rover", 5, 5, 5, 5, 5);
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(test);
		underTest.feedAllPets();
		Assert.assertEquals(2, test.getHunger());
	}

	@Test
	public void shouldAddTwoPetsToAMapThenFeedThemBothAtTheSameTime() {
		Cat pet1 = new Cat("Pebbill", 5, 5, 5, 5, 5);
		Cat pet2 = new Cat("Marbill", 5, 5, 5, 5, 5);
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.feedAllPets();
		Assert.assertEquals(2, pet1.getHunger());

	}

	@Test
	public void generatesAndAddsPetShould() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		String species = "cat";
		String userName = "sparkles";
		boolean botChoice = false;
		underTest.generatePet(userName, species, botChoice);
		Cat sparkles = (Cat) underTest.getPet("sparkles");
		sparkles.cleanBox();

	}

	@Test
	public void shouldAddTwoPetsToAMapThenWaterThemBothAtTheSameTime() {
		OrganicPet pet1 = new OrganicPet("Pebbill");
		OrganicPet pet2 = new OrganicPet("Marbill");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.waterAllPets();
		Assert.assertEquals(2, pet1.getThirst());

	}

	@Test
	public void shouldAddTwoPetsToAMapThenPlayThemBothAtTheSameTime() {
		OrganicPet pet1 = new OrganicPet("Pebbill", 5, 5, 5, 5, 5);
		OrganicPet pet2 = new OrganicPet("Marbill", 5, 5, 5, 5, 5);
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.playWithAllPets();
		Assert.assertEquals(2, pet1.getBoredom());
	}

	// TODO why is this working??????????
//	@Test
//	public void shouldIntakeHomelessPet() {
//		VirtualPetShelter underTest = new VirtualPetShelter();
//		underTest.takeIn("Shellby");
//		Map<String, Pet> test = underTest.getAllPets();
//		Assert.assertEquals(false, test.isEmpty());
//	}
//
//	@Test
//	public void shouldAdoptOut() {
//		VirtualPetShelter underTest = new VirtualPetShelter();
//		underTest.takeIn("Cuddles");
//		underTest.adoptOut("Cuddles");
//		Map<String, Pet> test = underTest.getAllPets();
//		Assert.assertEquals(true, test.isEmpty());
//
//	}

//	@Test
//	public void shouldBeOpen() {
//		VirtualPetShelter underTest = new VirtualPetShelter();
//		for (int i = 0; i <= 15; i++) {
//			underTest.takeIn("Cuddles");
//			for (int j = 0; j <= 15; j++) {
//				underTest.tick();
//			}
//		}
//		underTest.tick();
//		boolean actual = underTest.isOpen();
//		Assert.assertEquals(false, actual);
//	}

	@Test
	public void shouldRemoveAPetThatsDied() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		OrganicPet pet1 = new OrganicPet("Cuddles");
		OrganicPet pet2 = new OrganicPet("Checkers");
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.tick();
		Assert.assertEquals(true, underTest.isEmpty());

	}

	@Test
	public void shouldNotRemoveAPetYouDontHave() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		OrganicPet pet1 = new OrganicPet("Cuddles");
		OrganicPet pet2 = new OrganicPet("Checkers");
		underTest.addPet(pet1);
		underTest.addPet(pet2);

		underTest.adoptOut("foo");

		Assert.assertEquals(2, underTest.getAllPets().size());
	}

	@Test
	public void shouldRemoveDeadPet() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		OrganicPet pet = new OrganicPet("Sandy");
		underTest.addPet(pet);
		pet.feedPet();
		underTest.tick();
		Assert.assertEquals(0, underTest.getAllPets().size());

	}
}