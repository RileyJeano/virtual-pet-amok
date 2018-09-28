package virtual_pet_amok;

import org.junit.Assert;
import org.junit.Test;

public class OrganicPetTest {

	@Test
	public void shouldHaveName() {
		Pet underTest = new OrganicPet("Stoney");
		String name = underTest.getName();
		Assert.assertEquals("Stoney", name);

	}

	@Test
	public void shouldHaveHunger() {
		OrganicPet underTest = new OrganicPet("Stoney");
		int test = underTest.getHunger();
		Assert.assertEquals(5, test);
	}

	@Test
	public void shouldHaveThirst() {
		OrganicPet underTest = new OrganicPet("Stoney");
		int test = underTest.getThirst();
		Assert.assertEquals(5, test);
	}

	@Test
	public void shouldHaveRestlessness() {
		Pet underTest = new OrganicPet("Stoney");
		int test = underTest.getBoredom();
		Assert.assertEquals(0, test);
	}

	@Test
	public void shouldHaveADescription() {
		Pet underTest = new OrganicPet("Metamorph", 0, 0, 0, 0, 0);
		Assert.assertNotEquals(null, underTest.getDescription());
	}

	@Test
	public void shouldGenerateRandomDescription() {
		Pet underTest = new OrganicPet("Rocky Horror");
		Assert.assertNotEquals("", underTest.getDescription());
	}

	@Test
	public void shouldGenerateAnotherDescription() {
		Pet underTest = new OrganicPet("Rocky Horror");
		Assert.assertNotEquals(null, underTest.getDescription());
	}

	@Test
	public void shouldFeedPet() {
		OrganicPet underTest = new OrganicPet("Pettie", 5, 5, 5, 5, 5);
		int initialHunger = underTest.getHunger();
		underTest.feedPet();
		int newHunger = underTest.getHunger();
		Assert.assertEquals(initialHunger - 3, newHunger);
	}

	@Test
	public void shouldWaterPet() {
		OrganicPet underTest = new OrganicPet("Pettie", 5, 5, 5, 5, 5);
		int initialHunger = underTest.getThirst();
		underTest.waterPet();
		int newHunger = underTest.getThirst();
		Assert.assertEquals(initialHunger - 3, newHunger);
	}

}