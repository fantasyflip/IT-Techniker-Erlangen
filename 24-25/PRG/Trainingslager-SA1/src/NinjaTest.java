public class NinjaTest {
    public static void main(String[] args) {
        int amount = -1;
        String baseName = "ITT56Ninja_";

        // read count from console
        System.out.print("Anzahl der NinjaTurtles: ");
        amount = Integer.parseInt(System.console().readLine());

        NinjaTurtle army [] = new NinjaTurtle[amount];

        for(int i = 0; i<amount; i++){
            army[i] = new NinjaTurtle();
            army[i].setName(baseName + i+1);
            army[i].kaempfen();
            System.out.println(army[i].getName());
        }
    }
}
