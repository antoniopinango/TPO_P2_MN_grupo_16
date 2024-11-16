package org.example.tpo;

public class RepeatedSetNode {
    private int value;
    private int count;
    private RepeatedSetNode next;

    public RepeatedSetNode(int value, int count, RepeatedSetNode next) {
        this.value = value;
        this.count = count;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RepeatedSetNode getNext() {
        return next;
    }

    public void setNext(RepeatedSetNode next) {
        this.next = next;
    }
}
