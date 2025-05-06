// Abstract: Es kann keine Instanz der Klasse "Lebewesen" erstellt werden.
// Lediglich von der Klasse "Lebewesen" abstammende Klassen wie "Vogel" können instanziiert werden. "Lebewesen" legt lediglich die Grundstruktur fest.
// Das macht Sinn, weil ein Vogel immer ein Lebewesen ist.
// Damit die nicht instanziiert werden kann, macht man sie abstrakt.
public abstract class Lebewesen {
    private String name;

    public Lebewesen(String name) {
        this.name = name;
    }

    public void bewegen() {
        System.out.println("Das Lebewesen bewegt sich.");
    }

    // Jede Klasse stammt von der Klasse "Object" ab,
    // hat also prinzipiell immer ein "extends Object" an der Klassendefinition.
    // Die Klasse "Object" hat eine Methode "toString", die hier in diesem Fall überschrieben wird.
    // Durch das Überschreiben wird beim Aufruf "Lebewesen.toString()" nicht mehr die ursprüngliche Methode
    // der Klasse "Object" verwendet, sondern die hier überschriebene Variante. Genauso kann diese und alle
    // anderen Methoden auch in Klassen, die von Lebewesen abstammen überschrieben werden. Es gilt prinzipiell,
    // dass die erste verfügbare Variante der Methode verwendet wird.
    public String toString(){
        return name;
    }

    // Auch Methoden können abstract sein. Damit wird nur vorgegeben, dass die Methode in der
    // Subklasse existieren muss. Es gibt also in "Vogel" bzw. da "Vogel" ebenfalls abstract ist spätestens in
    // "Papagei" zwingend eine Methode "sterben". Dort muss für diese Methode dann auch Syntax definiert sein.
    // Damit eine Methode abstract sein kann, muss die Klasse auch abstract sein.
    public abstract void sterben();


}
