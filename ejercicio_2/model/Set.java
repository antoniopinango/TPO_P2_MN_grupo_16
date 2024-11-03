package ejercicio_2.model;

import java.util.Iterator;
import java.util.LinkedList;

public class Set<T> implements Iterable<T>{
    private LinkedList<T> elements;

    public Set() {
        elements = new LinkedList<>();
    }

    public boolean add(T item) {
        if (!elements.contains(item)) {
            elements.add(item);
            return true; // Indica que se ha agregado un elemento nuevo
        }
        return false; // El elemento ya estaba presente
    }

    public boolean remove(T item) {
        return elements.remove(item);
    }

    public boolean contains(T item) {
        return elements.contains(item);
    }

    public int size() {
        return elements.size();
    }

    public LinkedList<T> getElements() {
        return elements;
    }

    // Implementación de Iterable
    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }


}
