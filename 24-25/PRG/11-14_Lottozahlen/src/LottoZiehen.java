import java.util.*;
import java.security.SecureRandom;

public class LottoZiehen {
    //ArrayList
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        SecureRandom secureRandom = new SecureRandom();
        int superNumber = secureRandom.nextInt(50);

        while (numbers.size() < 6) {
            int randomNumber = secureRandom.nextInt(50);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        numbers.sort(null);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers.get(i));
        }

        System.out.println("Super Number: " + superNumber);
    }
}
