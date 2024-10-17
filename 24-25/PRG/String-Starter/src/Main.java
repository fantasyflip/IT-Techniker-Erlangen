public class Main {
    // https://info-wsf.de/uebungsaufgaben-char-und-strings/
    public static void main(String[] args) {
        //task 2
        task2();

        System.out.println();

        //task 3
        task3();
        System.out.println();

        //task 10
        task10();
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

        System.out.println("Aus '" + input + "' wird '" + result + "'");
    }

    public static void task10(){
        String sentence = new String("Das ist ein Satz der keinen Sinn macht.");
        String password = pwdGenerator(sentence);
        System.out.println("Aus dem Satz '" + sentence + "' wird das Passwort '" + password + "' generiert.");
    }

    public static String pwdGenerator(String sentence){
        String password = new String();

        String separator = new String(" ");

        boolean noSeparatorLeft = false;
        int wordCount = 0;
        do {
            char charToAppend;
            String word = new String();
            int firstSeparator = sentence.indexOf(separator);

            wordCount++;

            if(firstSeparator == -1){
                noSeparatorLeft = true;
                word = sentence;
            } else {
                word = sentence.substring(0, firstSeparator);
            }

            if(wordCount % 2 == 0){
                charToAppend = word.charAt(0);
            } else {
                charToAppend = word.charAt(word.length()-1);
            }

            password += charToAppend;

            sentence = sentence.substring(firstSeparator+1);



        } while(noSeparatorLeft == false);

        return wordCount + password;
    }
}