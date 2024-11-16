package org.example.tpo;


import org.example.adt.Set;
import org.example.adt.nodes.Node;
import java.util.Random;


public class SuperSet implements Set {
    private Node first;
    private final Random random;
    private int size;

    public SuperSet() {
        this.first = null;
        this.random = new Random();
        this.size = 0;

    }


    @Override
    public void add(int a) {
        if (this.isEmpty()){
            this.first = new Node (a, null);
            this.size++;
            return;
        }
        Node current = this.first;
        while (current.getNext() != null) {
            if (current.getValue() == a){
                return;
            }
            current = current.getNext();
        }
        if (current.getValue() == a){
            return;
        }
        current.setNext(new Node (a, null));
        this.size++;
    }

    @Override
    public int choose() {
        if (this.isEmpty()){
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(size);
        int count = 0;
        Node current = this.first;
        while (current != null) {
            if (count == i){
                return current.getValue();
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public void remove(int a) {
        if (this.isEmpty()){
            return;
        }
        if (this.first.getNext() == null){
            if (this.first.getValue()==a){
                this.first = null;
                this.size--;
            }
            return;
        }
        if (this.first.getValue() == a){
            this.first = this.first.getNext();
            this.size--;
            return;
        }
        Node current = this.first.getNext();
        Node previous = this.first;
        while (current.getNext() != null){
            if (current.getValue() == a){
                previous.setNext(current.getNext());
                this.size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
        if (current.getValue() == a){
            previous.setNext(current.getNext());
            this.size--;
        }

    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
    public boolean isSubset(Set other){
        if (other.isEmpty()){
            return true;
        }
        Node current = this.first;
        while (current != null){
            boolean found = false;
            Node otherCurrent = ((SuperSet) other).first;
            while (otherCurrent != null){
                if (current.getValue() == otherCurrent.getValue()){
                    found = true;
                    break;
                }
                otherCurrent = otherCurrent.getNext();
            }
            if (!found){
                return false;
            }
            current = current.getNext();
        }
        return true;


    }
    public Set complement (Set other){
        if (!isSubset(other)){
            throw new RuntimeException("El conjunto no es un subconjunto del superconjunto");

        }
        SuperSet complementSet = new SuperSet();
        Node current = ((SuperSet) other).first;
        while (current != null){
            if (!contains((current.getValue()))){
                complementSet.add(current.getValue());
            }
            current = current.getNext();
        }
        return complementSet;
    }

    public boolean contains (int value){
        Node current = this.first;
        while (current != null){
            if (current.getValue() == value){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}
