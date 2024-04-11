package org.example.lab6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Node implements Comparable, Serializable {
    int x, y;
    int color;
    List<Node> nodeArray;

    public Node(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.nodeArray = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void addConnection(Node node) {
        this.nodeArray.add(node);
        node.nodeArray.add(this);
    }

    public boolean isConnected(Node node) {
        return nodeArray.stream().anyMatch(p -> p.compareTo(node) == 0);
    }

    @Override
    public int compareTo(Object o) {
        if (o == this) {
            return 0;
        }

        if (!(o instanceof Node)) {
            throw new IllegalArgumentException("Object is not an instance of Node");
        }

        Node node = (Node) o;

        if (this.x != node.x) {
            return Integer.compare(this.x, node.x);
        }

        return Integer.compare(this.y, node.y);
    }

}
