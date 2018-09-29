package virtual_pet_amok;

import org.junit.Assert;
import org.junit.Test;

public class DogTest {

	@Test
	public void shouldHaveHealth() {
		Dog underTest = new Dog("Fido");
		int test = underTest.getHealth();
		Assert.assertEquals(100, test);
	}

	@Test
	public void walkingADogShouldReduceItsShitRate() {
		Dog underTest = new Dog("Fido");
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int initialPoopRate = underTest.getPoopRate();
		underTest.walk();
		int newPoopRate = underTest.getPoopRate();
		Assert.assertEquals(initialPoopRate - 3, newPoopRate);
	}

	@Test
	public void shouldPoopAtItsPoopRate() {
		Dog underTest = new Dog("Fido");
		underTest.tick();
		int poopLevel = underTest.getPoopLevel();
		underTest.tick();
		int newPoopLevel = underTest.getPoopLevel();
		underTest.cleanCage();
		int finalPoopLevel = underTest.getPoopLevel(); // which should be 0 since we just cleaned
		Assert.assertEquals(3 - finalPoopLevel, newPoopLevel);

	}

	@Test
	public void walkingADogShouldMakeItHappier() {
		Dog underTest = new Dog("Fido");
		int initialHappiness = underTest.getHappiness();
		underTest.walk();
		int actual = underTest.getHappiness();
		Assert.assertEquals(initialHappiness + 3, actual);

	}

	@Test
	public void tickShouldAddHunger() {
		Dog underTest = new Dog("Fido");
		int initialLevel = underTest.getHunger();
		underTest.tick();
		int finalLevel = underTest.getHunger();
		Assert.assertEquals(initialLevel + 1, finalLevel);
	}

	@Test
	public void tickShouldAddThirst() {
		Dog underTest = new Dog("Fido");
		int initialLevel = underTest.getThirst();
		underTest.tick();
		int finalLevel = underTest.getThirst();
		Assert.assertEquals(initialLevel + 1, finalLevel);
	}

	@Test
	public void tickShouldAddBoredom() {
		Dog underTest = new Dog("Fido");
		int initialLevel = underTest.getBoredom();
		underTest.tick();
		int finalLevel = underTest.getBoredom();
		Assert.assertEquals(initialLevel + 1, finalLevel);
	}

	// health test was tested on a dog but applies to both cat and dog
	@Test
	public void shouldHealth() {
		Dog underTest = new Dog("Fido");
		underTest.tick();
		Assert.assertEquals(92, underTest.getHealth());
	}

	@Test
	public void shouldHaveSpecies() {
		Dog dogTestOne = new Dog("Uno");
		Assert.assertEquals("dog", dogTestOne.getSpecies());
	}

}
