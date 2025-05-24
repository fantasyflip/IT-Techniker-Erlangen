import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _3_AssertionTest {

	private boolean truism() {
		return true;
	}

	private void throwing() {
		throw new RuntimeException("Because I can!");
	}

	// --- Basic Assertions ---
	@Test
	void testBasicTruthAssertions() {
		assertTrue(truism());
		assertTrue(() -> truism(), "Should be true");

		assertFalse(() -> false, () -> "Expected false but got true");
	}

	@Test
	void testNullAssertions() {
		String a = null;
		String b = "not null";

		assertNull(a);
		assertNull(a, "Should be null");
		assertNull(a, () -> "Lazy message: a should be null");

		assertNotNull(b);
		assertNotNull(b, "Should not be null");
		assertNotNull(b, () -> "Lazy message: b should not be null");
	}

	@Test
	void testEqualityAssertions() {
		assertEquals(42, 40 + 2);
		assertNotEquals(42, 43);
	}

	@Test
	void testSamenessAssertions() {
		String x = "hello";
		String y = x;
		String z = new String("hello");

		assertSame(x, y);        // same reference
		assertNotSame(x, z);     // different object, even if equal content
	}

	// --- Collection Assertions ---
	@Test
	void testArrayEquals() {
		int[] expected = {1, 2, 3};
		int[] actual = {1, 2, 3};
		assertArrayEquals(expected, actual);
	}

	@Test
	void testIterableEquals() {
		List<String> expected = Arrays.asList("a", "b", "c");
		List<String> actual = Arrays.asList("a", "b", "c");
		assertIterableEquals(expected, actual);
	}

	// --- Advanced Assertions ---
	@Test
	void testAssertThrows() {
		Exception exception = assertThrows(RuntimeException.class, this::throwing);
		assertEquals("Because I can!", exception.getMessage());
	}

	@Test
	void testAssertTimeout() {
		assertTimeout(Duration.ofMillis(100), () -> {
			// Simulate something fast
			Thread.sleep(50);
		});
	}

	@Test
	void testAssertTimeoutPreemptively() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(50);
		});
	}

	@Test
	void testAssertAll() {
		String str = "Jupiter";
		assertAll(
				() -> assertTrue(str.startsWith("J")),
				() -> assertTrue(str.endsWith("r")),
				() -> assertEquals(7, str.length())
		);
	}

	@Test
	void testFailManually() {
		if (!truism()) {
			fail("This should never happen");
		}
	}
}
