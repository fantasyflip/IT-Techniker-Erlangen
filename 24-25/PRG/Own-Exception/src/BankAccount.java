public class BankAccount {
    private double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void printBalance() {
        System.out.println("Aktuelles Guthaben:" + this.balance);
    }

    public void withdraw(double amount) {
        try{

            if (amount > this.balance) {
                throw new CustomException("Fehler: Nicht genügend Guthaben vorhanden! Versucht: " + amount + ", Verfügbar: " + this.balance);
            } else {
                this.balance -= amount;
            }
        } catch (CustomException ce){
            System.out.println(ce.getMessage());
        }
    }
}
