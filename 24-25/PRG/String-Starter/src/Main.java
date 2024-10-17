public class Main {
    // https://info-wsf.de/uebungsaufgaben-char-und-strings/
    public static void main(String[] args) {
        //task 2
        task2();
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
}