package virtual_pet_amok;

import org.junit.Assert;
import org.junit.Test;

public class RobotPetTest {

	@Test
	public void shouldOil() {
		RobotPet underTest = new RobotPet("Pete", 5, 5, 5, 5);
		underTest.oil();
		int expected = underTest.getHealth();
		Assert.assertEquals(9, expected);
	}

	@Test
	public void shouldWalk() {
		RobotPet underTest = new RobotPet("Pete", "dog");
		int initialRust = underTest.getRust();
		underTest.walk();
		int expected = underTest.getRust();
		Assert.assertEquals(initialRust - 4, expected);
	}

	@Test
	public void shouldHealth() {
		RobotPet underTest = new RobotPet("Fido");
		underTest.tick();
		Assert.assertEquals(100, underTest.getHealth());
	}

}
