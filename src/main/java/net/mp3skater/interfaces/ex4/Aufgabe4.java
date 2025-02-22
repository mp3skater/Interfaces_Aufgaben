package main.java.net.mp3skater.interfaces.ex4;

/**
 * Aufgabe 4
 *
 * Erweiterung des im Unterricht vorgestellten Interface MeinIterator und der Klasse MeineDefaultListe um zwei Methoden:
 *  - boolean setzenAktuellesElement(Object element)
 *  - boolean loeschenAktuellesElement()
 *
 * Im Folgenden wird eine einfache verkettete Liste implementiert, inklusive eines internen Iterators.
 */

interface MeinIterator {
    boolean hasNext();
    Object next();
    // Neue Methoden
    boolean setzenAktuellesElement(Object element);
    boolean loeschenAktuellesElement();
}

class MeineDefaultListe {

    // Einfach verkettete Liste
    private Node head;

    private static class Node {
        Object data;
        Node next;
        Node(Object data) { this.data = data; }
    }

    // Methode zum Hinzufügen eines Elements am Ende
    public void add(Object element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = new Node(element);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Liefert einen Iterator für diese Liste
    public MeinIterator elemente() {
        return new DefaultIterator();
    }

    // Interne Iterator-Implementierung
    private class DefaultIterator implements MeinIterator {
        private Node previous = null;
        private Node current = head;
        // Damit loeschenAktuellesElement() funktioniert, merken wir uns auch den Knoten vor dem aktuellen Element.

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            if (current == null)
                return null;
            Object data = current.data;
            previous = current;
            current = current.next;
            return data;
        }

        // Ersetzt das Element, auf das der Iterator aktuell zeigt,
        // sofern ein aktuelles Element existiert und element nicht null ist.
        @Override
        public boolean setzenAktuellesElement(Object element) {
            if (element == null || previous == null)
                return false;
            previous.data = element;
            return true;
        }

        // Löscht das aktuelle Element (also das, welches zuletzt von next() geliefert wurde)
        // und setzt den Iterator so, dass das nächste Element künftig geliefert wird.
        @Override
        public boolean loeschenAktuellesElement() {
            if (previous == null)
                return false; // Es wurde noch kein Element besucht
            // Falls das zu löschende Element am Anfang steht
            if (previous == head) {
                head = head.next;
            } else {
                // Suche den Vorgänger von previous
                Node vorVorher = head;
                while (vorVorher != null && vorVorher.next != previous)
                    vorVorher = vorVorher.next;
                if (vorVorher != null)
                    vorVorher.next = previous.next;
            }
            // Setze current auf den Nachfolger des gelöschten Knotens
            current = previous.next;
            // Setze previous zurück, sodass beim nächsten Aufruf von next() nicht nochmal gelöscht wird.
            previous = null;
            return true;
        }
    }

    // Zum Testen: gibt alle Elemente der Liste aus
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Aufgabe4 {
    public static void main(String[] args) {
        // Beispiel-Testprogramm
        MeineDefaultListe liste = new MeineDefaultListe();
        liste.add("Erstes Element");
        liste.add("Zweites Element");
        liste.add("Drittes Element");

        System.out.println("Liste vor Iteration:");
        liste.printList();

        MeinIterator it = liste.elemente();
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println("Besucht: " + element);
            // Setze aktuelles Element um (hänge _geändert an)
            it.setzenAktuellesElement(element + " _geändert");
        }

        System.out.println("\nListe nach setzten der Elemente:");
        liste.printList();

        // Erneut iterieren und jeweils ein Element löschen
        it = liste.elemente();
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println("Lösche: " + element);
            it.loeschenAktuellesElement();
        }

        System.out.println("\nListe nach Löschvorgängen:");
        liste.printList();
    }
}
