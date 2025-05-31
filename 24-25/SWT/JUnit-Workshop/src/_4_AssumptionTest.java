import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;

class _4_AssumptionTest {

	/*
	 * Write tests that use assumptions to make sure
	 * tests are only executed when preconditions are fulfilled.
	 *
	 *  - assumeTrue
	 *  - assumeFalse
	 *  - assumeThat
	 */

	private String messageBeforeNoon() {
		if (LocalDateTime.now().getHour() < 12)
			return "Good Morning";
		else
			throw new IllegalStateException("It's not before noon");
	}

	private String messageAfterNoon() {
		if (LocalDateTime.now().getHour() > 12)
			return "Good Evening";
		else
			throw new IllegalStateException("It's not after noon");
	}

	@Test
	void testMessageBeforeNoon() {
		assumeTrue(LocalDateTime.now().getHour() < 12, "Skipping: it's after noon");

		String message = messageBeforeNoon();
		assertEquals("Good Morning", message);
	}

	@Test
	void testMessageAfterNoon() {
		assumeTrue(LocalDateTime.now().getHour() > 12, "Skipping: it's before or exactly noon");

		String message = messageAfterNoon();
		assertEquals("Good Evening", message);
	}

	@Test
	void testAssumeFalse() {
		assumeFalse(LocalDateTime.now().getDayOfWeek().getValue() == 7, "Skipping on Sunday");

		// Run only if it's not Sunday
		assertTrue(true); // trivial test just to show it ran
	}

	@Test
	void testAssumeThat() {
		int hour = LocalDateTime.now().getHour();
		assumeTrue(hour >= 0 && hour < 24, () -> "Hour should be within 0-23, but was: " + hour);

		// Continue only if assumption passes
		assertNotNull(hour);
	}
}
