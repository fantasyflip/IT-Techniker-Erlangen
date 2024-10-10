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

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swap the elements
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}
