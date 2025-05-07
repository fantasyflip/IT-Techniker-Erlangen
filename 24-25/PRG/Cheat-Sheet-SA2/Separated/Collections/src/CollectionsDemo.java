
import java.util.*;

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
