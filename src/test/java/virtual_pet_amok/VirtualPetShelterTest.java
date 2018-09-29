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

	@Test
	public void shouldRemoveAPetThatsDied() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		OrganicPet pet1 = new OrganicPet("Sandy", 0, 0, 0, 0, 0);
		OrganicPet pet2 = new OrganicPet("Checkers", 0, 0, 0, 0, 0);
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
		OrganicPet pet = new OrganicPet("Sandy", 0, 0, 0, 0, 0);
		underTest.addPet(pet);
		underTest.tick();
		Assert.assertEquals(0, underTest.getAllPets().size());

	}

	@Test
	public void shouldShutShelterDown() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.shutDown();
		Assert.assertEquals(false, underTest.isOpen());
	}

}