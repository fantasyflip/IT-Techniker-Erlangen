import java.util.stream.LongStream;

public class PrimeNumbers {

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        return LongStream.range(2, (long) Math.sqrt(n) + 1)
                .noneMatch(i -> n % i == 0);
    }

}
