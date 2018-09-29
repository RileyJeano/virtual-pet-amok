package virtual_pet_amok;

import org.junit.Assert;
import org.junit.Test;

public class PetTest {
	@Test
	public void shouldBeACatOrDog() {
		Pet underTest = new Pet("Hylda", "cat");
		String result = underTest.getSpecies();
		Assert.assertEquals(result, "cat");
	}

	@Test
	public void shouldBeACatDog() {
		Pet underTest = new Pet("Hylda", "catdog");
		String result = underTest.getSpecies();
		Assert.assertEquals(result, "catdog");
	}

	@Test
	public void shouldDie() {
		Pet underTest = new Pet("Hylda", "catdog");
		boolean result = underTest.getDead();
		Assert.assertEquals(false, result);
	}

	@Test
	public void shouldNotDie() {
		Pet underTest = new Pet("Hylda", "catdog");
		underTest.toggleDeath();
		boolean result = underTest.getDead();
		Assert.assertEquals(true, result);
	}

	@Test
	public void shouldPlay() {
		Pet underTest = new Pet("Hylda", 5, 5, 5);
		underTest.playWithPet();
		Assert.assertEquals(2, underTest.getBoredom());
	}

	@Test
	public void shouldDieNow() {
		Pet underTest = new Pet("Hylda", 0, 0, 0);
		underTest.isDead();
		Assert.assertEquals(true, underTest.getDead());
	}

	@Test
	public void shouldHaveSpecies() {
		Pet catTestOne = new Cat("Uno");
		Assert.assertEquals("cat", catTestOne.getSpecies());
	}
}
