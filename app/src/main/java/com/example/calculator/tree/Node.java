package com.example.calculator.tree;

public class Node {

    public static enum Type {
        ADDITION,
        SUBSTRACTION,
        MULTIPLICATION,
        DIVISION,
        NUMBER
    }

    private final Type type;
    private Node nodeLeft;
    private Node nodeRight;

    // when it's a number
    private double value;

    // Constructor for operations
    public Node(Node nodeLeft, Node nodeRight, Type type) {

        this.type = type;
        this.nodeLeft = nodeLeft;
        this.nodeRight = nodeRight;

    }


    // Constructor for leafs, number
    public Node(Double value) {
        this.type = Type.NUMBER;
        this.value = value;
    }


    public double getValue() {
        switch (type) {
            case ADDITION:
                return nodeLeft.getValue() + nodeRight.getValue();
            case SUBSTRACTION:
                return nodeLeft.getValue() - nodeRight.getValue();
            case MULTIPLICATION:
                return nodeLeft.getValue() * nodeRight.getValue();
            case DIVISION:
                return nodeLeft.getValue() / nodeRight.getValue();
            default: // number
                return value;
        }
    }

}
