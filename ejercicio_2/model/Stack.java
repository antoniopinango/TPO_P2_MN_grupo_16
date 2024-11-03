package ejercicio_2.model;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T>{
    private LinkedList<T> elements;

    public Stack() {
        elements = new LinkedList<>();
    }

    public void push(T item) {
        elements.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.getLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    // Metodo para agregar un elemento (equivalente a push)
    public void add(T item) {
        push(item);
    }

    // Metodo para agregar todos los elementos desde otra pila
    public void addAll(Stack<T> otherStack) {
        // Usar un nuevo stack temporal para invertir
        Stack<T> tempStack = new Stack<>();
        for (T item : otherStack) {
            tempStack.push(item);
        }
        // Ahora agregar los elementos del tempStack al stack original
        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return elements.descendingIterator(); // Permite iterar de atrás hacia adelante
    }

    @Override
    public String toString() {
        return "Stack: " + elements.toString();
    }

    // Clase Builder
    public static class Builder<T> {
        private Stack<T> stack;

        public Builder() {
            this.stack = new Stack<>();
        }

        public Builder<T> add(T element) {
            stack.add(element);
            return this;
        }

        public Builder<T> addAll(Stack<T> otherStack) {
            stack.addAll(otherStack);
            return this;
        }

        public Stack<T> build() {
            return stack;
        }
    }
}
