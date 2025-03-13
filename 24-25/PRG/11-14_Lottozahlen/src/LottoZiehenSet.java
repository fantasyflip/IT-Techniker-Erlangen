import java.util.*;
import java.security.SecureRandom;

public class LottoZiehenSet {
    //TreeSet
    public static void main(String[] args) {
        Collection<Integer> numbers = new TreeSet<Integer>();
        SecureRandom secureRandom = new SecureRandom();
        int superNumber = secureRandom.nextInt(50);

        while(numbers.size()< 6){
            numbers.add(secureRandom.nextInt(50));
        }

        Iterator<Integer> iterator = numbers.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            System.out.println("Number " + index + ": " + iterator.next());
            index++;
        }

        System.out.println("Super Number: " + superNumber);
    }
}
