package virtual_pet_amok;

import org.junit.Assert;
import org.junit.Test;

public class CatTest {

	@Test
	public void shouldBeFullOfShit() {
		Cat catTestOne = new Cat("Uno");
		Cat catTestTwo = new Cat("Docent");
		int initialPoopLevel = catTestOne.getPoopLevel();
		catTestTwo.tick();
		int laterPoopLevel = catTestOne.getPoopLevel();

		Assert.assertEquals(initialPoopLevel + 1, laterPoopLevel);
	}

	@Test
	public void shouldCleanBox() {
		Cat catTestOne = new Cat("Uno");
		Cat catTestTwo = new Cat("Docent");
		int poopLevel = catTestOne.getPoopLevel();
		catTestTwo.tick();
		catTestOne.tick();
		catTestOne.cleanBox();
		int newPoopLevel = catTestOne.getPoopLevel();
		Assert.assertEquals(poopLevel, newPoopLevel);

	}

	@Test
	public void shouldHaveSpecies() {
		Cat catTestOne = new Cat("Uno");
		Assert.assertEquals("cat", catTestOne.getSpecies());
	}

}
