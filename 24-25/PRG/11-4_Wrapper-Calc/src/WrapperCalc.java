import java.util.Scanner;
import java.lang.Integer;
import java.lang.Character;

public class WrapperCalc {
    public static Integer getNumber(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        String numner = sc.nextLine();
        return Integer.parseInt(numner);
    }
    public static void main (String[] args) {
        // Take three user inputs: number, character, number
        Scanner sc = new Scanner(System.in);

        int number1 = getNumber();
        System.out.println("Enter operation: ");
        String operation = sc.next();
        int number2 = getNumber();

        Integer result;

        switch(operation){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            default: {
                System.out.println("Invalid operation");
                return;
            }
        }

        System.out.println("Result: " + result);



    }
}
