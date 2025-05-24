import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class _1_FirstTest {

    @Test
    void isPrime() {
        assertTrue(PrimeNumbers.isPrime(7));
        assertFalse(PrimeNumbers.isPrime(4));
        assertTrue(PrimeNumbers.isPrime(13));
        assertFalse(PrimeNumbers.isPrime(1));
        assertFalse(PrimeNumbers.isPrime(0));
    }
}
