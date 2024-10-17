public class Main {
    // https://info-wsf.de/uebungsaufgaben-char-und-strings/
    public static void main(String[] args) {
        //task 2
        //task2();

        //task 3
        task3();
    }

    public static void task2(){
        String input = new String("Das ist der Input Text.");
        String charToCount = new String("s");

        boolean noApperanceLeft = false;
        int appearanceCount = 0;
        do {
            int firstAppearance = input.indexOf(charToCount);

            if(firstAppearance == -1){
                noApperanceLeft = true;
            } else {
                appearanceCount++;
                input = input.substring(firstAppearance+1);
            }
        } while(noApperanceLeft == false);

        System.out.println("Das Zeichen '" + charToCount + "' kommt " + appearanceCount + " mal vor.");

    }

    public static void task3(){
        String input = new String("Gartenzaun");

        String result = new String();

        if(input.length() > 3){
            String substring = input.substring(0,input.length()-3);
            String upperCaseLetters = input.substring(input.length()-3);

            result = substring + upperCaseLetters.toUpperCase();
        } else {
            result = input.toUpperCase();
        }

        System.out.println(result);
    }
}