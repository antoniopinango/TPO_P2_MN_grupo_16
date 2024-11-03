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

    // Implementación de Iterable
    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    // Metodo para agregar múltiples elementos desde otro conjunto
    public boolean addAll(Set<T> otherSet) {
        boolean modified = false;
        for (T item : otherSet) {
            if (add(item)) {
                modified = true; // Al menos un nuevo elemento fue agregado
            }
        }
        return modified; // Devuelve true si se agregaron elementos nuevos
    }

    // Clase Builder
    public static class Builder<T> {
        private Set<T> set;

        public Builder() {
            this.set = new Set<>();
        }

        public Builder<T> add(T element) {
            set.add(element);
            return this;
        }

        public Builder<T> addAll(Set<T> otherSet) {
            set.addAll(otherSet);
            return this;
        }

        public Set<T> build() {
            return set;
        }
    }
}
