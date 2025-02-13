public class BankTest {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(200.0);

        ba.printBalance();
        ba.withdraw(210.0);

        ba.printBalance();
        ba.withdraw(100.0);

        ba.printBalance();
        ba.withdraw(100.0);

        ba.printBalance();
    }
}
