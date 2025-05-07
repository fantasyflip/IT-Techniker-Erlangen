public class BankAccount {
    private double balance;

    // NoNegativeInitialBalance ist eine Kindklasse von Exception und NICHT von RuntimeException.
    // Das bedeutet, dass diese Ausnahme explizit in der Methodensignatur deklariert werden muss und
    // vom aufrufenden Code entweder gefangen oder weiter geworfen werden muss.
    public BankAccount(double balance) throws NoNegativeInitialBalance {
        if(balance < 0) {
            // Werfen der Exception
            throw new NoNegativeInitialBalance("Ein Konto muss zur Erstellung gedeckt sein.");
        }
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void printBalance() {
        System.out.println("Aktuelles Guthaben:" + this.balance);
    }

    // ExceedWithdrawl ist eine Kindklasse von RuntimeException.
    // Das bedeutet, dass diese Ausnahme eine "unchecked exception" ist und nicht explizit
    // in der Methodensignatur deklariert werden muss, aber sie kann dennoch gefangen werden.
    public void withdraw(double amount) {
        try{

            if (amount > this.balance) {
                // Werfen der Exception
                throw new ExceedWithdrawl("Fehler: Nicht genügend Guthaben vorhanden! Versucht: " + amount + ", Verfügbar: " + this.balance);
            } else {
                this.balance -= amount;
            }
        } catch (ExceedWithdrawl ce){
            System.out.println(ce.getMessage());
        }
    }
}