public class Fahrzeug {
    private final String Kennzeichen;
    private final Fahrzeugtyp fahrzeugtyp;
    private final int maxGeschwindigkeit;

    public Fahrzeug(String kennzeichen, Fahrzeugtyp fahrzeugtyp) {
        this.Kennzeichen = kennzeichen;
        this.fahrzeugtyp = fahrzeugtyp;
        this.maxGeschwindigkeit = fahrzeugtyp.getMaxGeschwindigkeit();
    }

    public String getKennzeichen() {
        return Kennzeichen;
    }

    public Fahrzeugtyp getFahrzeugtyp() {
        return fahrzeugtyp;
    }

    public int getMaxGeschwindigkeit() {
        return maxGeschwindigkeit;
    }



}
