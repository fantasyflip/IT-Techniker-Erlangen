// Durch das "final" wird festgelegt, dass die Klasse "Privatpatient" nicht weiter vererbt werden kann.
// Eine Klassendefinition wie
// public class VIPPatient extends Privatpatient {...}
// wäre also nicht möglich.
// Ebenso können auch Methoden vom überschreiben geschützt werden, indem sie in der Elternklasse mit
// einem "final" versehen werden, können sie in Subklassen nicht überschrieben werden.
// Zur Info: "final" sorgt bei Variablen dafür, dass die Werte zu Konstanten werden.
public final class Privatpatient extends Patient {
    /**
     * Konstruktor für Privatpatient.
     * Muss "throws PraxisVollException" deklarieren, weil der Aufruf von super()
     * im Elternkonstruktor eine solche checked exception werfen kann und diese hier
     * weitergegeben wird. Siehe Patient
     */
    public Privatpatient(String name, String vorname, int alter) throws PraxisVollException{
        // super: Siehe Kassenpatient
        super(name, vorname, alter);
    }

    public void printAbrechnung(){
        System.out.println("Abrechnung: " + "ABC");
    }
}
