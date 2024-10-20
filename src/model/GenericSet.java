package src.model;

import java.util.HashSet;
import java.util.Set;

public class GenericSet<T> {
    private Set<T> elements;

    public GenericSet() {
        elements = new HashSet<>();
    }

    public void add(T item) {
        elements.add(item);
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

    public Set<T> getElements() {
        return elements;
    }
}
