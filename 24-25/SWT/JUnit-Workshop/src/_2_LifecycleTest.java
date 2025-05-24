import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class _2_LifecycleTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println(">>> @BeforeAll: Executed once before all tests.");
	}

	@AfterAll
	static void afterAll() {
		System.out.println(">>> @AfterAll: Executed once after all tests.");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("  > @BeforeEach: Executed before each test.");
	}

	@AfterEach
	void afterEach() {
		System.out.println("  > @AfterEach: Executed after each test.");
	}

	@Test
	void testOne() {
		System.out.println("    - Executing testOne");
		assertTrue(true);
	}

	@Test
	void testTwo() {
		System.out.println("    - Executing testTwo");
		assertEquals(2, 1 + 1);
	}
}
