import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int numbers [] = new int[5];
        numbers[0] = 10;
        numbers[1] = 23;
        numbers[2] = 456;
        numbers[3] = 4;
        numbers[4] = 15;

        System.out.println("Ausgabe ohne Sortierung:");

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

        System.out.println();

        System.out.println("Ausgabe Rückwärts");

        for(int i = numbers.length - 1; i >= 0; i--){
            System.out.println(numbers[i]);
        }

        System.out.println();

        System.out.println("Ausgabe mit Sortierung");

        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}
