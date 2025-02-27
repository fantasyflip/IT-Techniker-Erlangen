public class TierKaefigTest {
    public static void main(String[] args) {
//        a) Variante 1:
//        TierKaefig<Tier> kaefig = new TierKaefig<Katze>();
//
//        Nicht kompilierbar, da die Typen inkompatibel sind

//        b) Variante 2:
//        TierKaefig<Hund> kaefig = new TierKaefig<Tier>();
//
//        Nicht kompilierbar, da die Typen inkompatibel sind

//        c) Variante 3:
//        TierKaefig<?> kaefig = new TierKaefig<Katze>();
//        kaefig.setInsasse(new Katze());
//
//        Nicht kompilierbar, ? kann nicht auf Katze angewandt werden in setInsasse

//        d) Variante 4:
//        TierKaefig kaefig = new TierKaefig();
//        kaefig.setInsasse(new Hund());
//
//        Funktioniert mit Warnung wegen mangelnder Typsicherheit

    }
}
