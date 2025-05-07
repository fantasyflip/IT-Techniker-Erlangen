import java.util.*;

// Alternativ zu einem Array können mehrere Referenzobjekte in einer Collection gespeichert werden.
// Collections können dynamisch wachsen und schrumpfen und benötigen daher keine vordefinierte Größe.
// Die Größe kann sich während der Laufzeit verändern.
// Die Collection kann dabei entweder eine "List" oder ein "Set" sein.
// Beide Varianten haben eigene Eigenschaften.
// List: Geordnete Folge von Elementen
// Set: Sammlung von Objekten, in der jedes Objekt nur einmal vorkommen darf
// -> Mit einem SortedSet (Kindklasse zu Set) ist auch ein Set in einer geordneten Reihenfolge

class CollectionsDemo {
    public static void main(String[] args){
        // --- LISTS ---
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(30);
        arrayList.add(10);
        arrayList.add(20);
        Collections.sort(arrayList); // funktioniert jetzt
        System.out.println("ArrayList (sortiert): " + arrayList);

        // Abstammung von LinkedList: Collection -> List -> LinkedList
        // Die List fügt Elemente immer am Ende an.
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(15);
        linkedList.add(10);
        Collections.sort(linkedList);
        System.out.println("LinkedList (sortiert): " + linkedList);

        // --- SETS ---
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        List<Integer> sortedHashSet = new ArrayList<>(hashSet);
        Collections.sort(sortedHashSet);
        System.out.println("HashSet (sortiert): " + sortedHashSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(9);
        linkedHashSet.add(7);
        linkedHashSet.add(8);
        List<Integer> sortedLinkedHashSet = new ArrayList<>(linkedHashSet);
        Collections.sort(sortedLinkedHashSet);
        System.out.println("LinkedHashSet (sortiert): " + sortedLinkedHashSet);


        // Abstammung von TreeSet: Collection -> Set -> SortedSet -> TreeSet
        // Da TreeSet also ein SortedSet ist muss die Klasse, aus der ein TreeSet erstellt werden soll,
        // das Interface "Comparable<T>" implementieren (siehe Auto)
        // Das TreeSet fügt Elemente automatisch in der richtigen sortierten Reihenfolge hinzu.
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(100);
        treeSet.add(50);
        treeSet.add(75);
        System.out.println("TreeSet (automatisch sortiert): " + treeSet);

        // --- MAPS ---
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Drei");
        hashMap.put(1, "Eins");
        hashMap.put(2, "Zwei");
        System.out.println("HashMap (unsortiert): " + hashMap);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(20, "Zwanzig");
        linkedHashMap.put(10, "Zehn");
        linkedHashMap.put(30, "Dreißig");
        System.out.println("LinkedHashMap (Einfügereihenfolge): " + linkedHashMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(300, "CCC");
        treeMap.put(100, "AAA");
        treeMap.put(200, "BBB");
        System.out.println("TreeMap (automatisch nach Schlüssel sortiert): " + treeMap);

        Map<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(9, "Neun");
        hashtable.put(7, "Sieben");
        hashtable.put(8, "Acht");
        System.out.println("Hashtable (unsortiert): " + hashtable);


        // --- ITERATOR inkl. Custom-Class ---
        // Die Klasse Auto hat das Interface Comparable<T> implementiert -> Siehe Auto
        TreeSet<Auto> treeSet2 = new TreeSet<>();
        treeSet2.add(new Auto("BMW", 340));
        treeSet2.add(new Auto("Mercedes", 224));
        treeSet2.add(new Auto("Volvo",355));

        // Jede Collection enthält einen Iterator, um über die Collection zu iterieren
        // und alle Elemente zu erreichen
        Iterator<Auto> it = treeSet2.iterator();

        // Jeder Iterator hat die Methoden "next", "hasNext" und "remove".
        // Damit kann über jedes Element iteriert werden
        // While-Schleife
        while(it.hasNext()){
            System.out.println(it.next());
        }
        // For-Schleife (ausführlich)
        for(Iterator<Auto> i = treeSet2.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        // For-Schleife (simpel/kurz)
        for(Auto a : treeSet2){
            System.out.println(a);
        }
    }
}



//        | Typ           | Sortiert  | Duplikate erlaubt   | Einfügereihenfolge    | Synchronisiert  |
//        | ------------- | --------- | ------------------ | ---------------------- | --------------- |
//        | ArrayList     | ❌        | ✅                 | ✅                    | ❌              |
//        | LinkedList    | ❌        | ✅                 | ✅                    | ❌              |
//        | HashSet       | ❌        | ❌                 | ❌                    | ❌              |
//        | LinkedHashSet | ❌        | ❌                 | ✅                    | ❌              |
//        | TreeSet       | ✅        | ❌                 | automatisch sortiert  | ❌              |
//        | HashMap       | ❌        | Schlüssel: ❌      | ❌                    | ❌              |
//        | LinkedHashMap | ❌        | Schlüssel: ❌      | ✅                    | ❌              |
//        | TreeMap       | ✅        | Schlüssel: ❌      | automatisch sortiert  | ❌              |
//        | Hashtable     | ❌        | Schlüssel: ❌      | ❌                    | ✅ (veraltet)   |

// Für jeden elementaren Datentyp gibt es eine entsprechende Wrapper-Klasse im Paket java.lang.
// Diese Klassen ermöglichen es, primitive Werte als Objekte zu behandeln. (Sie erben somit ebenfalls von "Object")
// Dies ist notwendig, wenn man primitive Werte in Kontexten verwenden möchte,
// die Objekte erfordern (z.B. in Collections wie ArrayList oder wenn man Methoden auf den Werten aufrufen möchte).
//
// Elementarer Datentyp		|	Wrapper-Klasse
//		boolean 			|		Boolean
//		byte 				|		Byte
//		short 				|		Short
//		int 				|		Integer
//		long 				|		Long
//		float 				|		Float
//		double 				|		Double
//		char		 		|		Character
//
// Boxing - Beispiel:
// public int getPatientNr(){
//        // Um an den elementaren Datentyp einer Wrapper-Klasse zu gelangen muss man diesen theoretisch "unboxen". Das passiert mittlerweile allerdings automatisch.
//        // return this.patientNr.intValue(); // Nicht notwendig
//        return this.patientNr; // Auto-Unboxing
//    }
//
// Unboxing - Beispiel:
// public void setPatientNr(){
//        // Um den elementaren Datentyp einer Wrapper-Klasse zu setzen, muss man diesen theoretisch "boxen". Das passiert mittlerweile allerdings automatisch.
//        // this.patientNr = Integer.valueOf((int)((Math.random() * 100) + 1)*42); // Nicht notwendig
//        this.patientNr = (int)((Math.random() * 100) + 1)*42; // Autoboxing
//    }
