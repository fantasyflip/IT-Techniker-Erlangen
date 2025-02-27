public class TierKaefigTest {
    public static void main(String[] args) {
//        a) Variante 1:
//        TierKaefig<Tier> kaefig1 = new TierKaefig<Katze>();
//
//        Nicht kompilierbar, da die Typen inkompatibel sind.
//        Beziehungen zwischen Klassen sind für Typparameter irrelvant. Auf beiden Seiten muss der gleiche Datentyp stehen.


//        b) Variante 2:
//        TierKaefig<Hund> kaefig2 = new TierKaefig<Tier>();
//
//        Nicht kompilierbar, da die Typen inkompatibel sind.
//        Siehe a)


//        c) Variante 3:
//        TierKaefig<?> kaefig3 = new TierKaefig<Katze>();
//        kaefig3.setInsasse(new Katze());
//
//        Nicht kompilierbar, ? (unbekannter Datentyp) kann nicht auf Katze angewandt werden in setInsasse.
//        Java kann nicht bestimmen ob ? Katze oder Hund ist.
//        Es wird zwar ein TierKaefig vom Typ Katze erstellt, dieser wird allerdings in eine Variable mit unbekanntem Typparamter gespeichert


//        d) Variante 4:
//        TierKaefig kaefig4 = new TierKaefig();
//        kaefig4.setInsasse(new Hund());
//
//        Funktioniert mit Warnung wegen mangelnder Typsicherheit

    }
}
