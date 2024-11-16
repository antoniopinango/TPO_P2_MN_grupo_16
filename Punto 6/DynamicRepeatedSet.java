package org.example.tpo;
import org.example.adt.Set;
import java.util.Random;

public class DynamicRepeatedSet implements Set {
    private RepeatedSetNode first;
    private final Random random;
    private int size;

    public DynamicRepeatedSet() {
        this.first = null;
        this.random = new Random();
        this.size = 0;
    }

    @Override
    public void add(int a) {
        if (this.isEmpty()) {
            this.first = new RepeatedSetNode(a, 1, null);
            this.size++;
            return;
        }
        RepeatedSetNode current = this.first;
        while (current != null) {
            if (current.getValue() == a){
                current.setCount(current.getCount() + 1);
                return;
            }
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
        }
        current.setNext(new RepeatedSetNode(a, 1, null));
        this.size++;
    }

    @Override
    public int choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(size);
        int count = 0;
        RepeatedSetNode current = this.first;
        while (current != null) {
            count += current.getCount();
            if (i < count) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return -1;
    }


    @Override
    public void remove(int a) {
        if (this.isEmpty()) {
            return;
        }

        if (this.first.getValue() == a) {
            if (this.first.getCount() > 1) {
                this.first.setCount(this.first.getCount() - 1);
            } else {
                this.first = this.first.getNext();
                this.size--;
            }
            return;
        }

        RepeatedSetNode current = this.first.getNext();
        RepeatedSetNode previous = this.first;

        while (current != null) {
            if (current.getValue() == a) {
                if (current.getCount() > 1) {
                    current.setCount(current.getCount() - 1);
                } else {
                    previous.setNext(current.getNext());
                    this.size--;
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    public int count (int a){
        RepeatedSetNode current = this.first;
        while (current != null) {
            if (current.getValue() == a) {
                return current.getCount();
            }
            current = current.getNext();
        }
        return 0;
    }
}
