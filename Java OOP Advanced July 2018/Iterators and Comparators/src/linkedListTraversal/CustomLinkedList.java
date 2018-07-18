package linkedListTraversal;

import java.util.Iterator;

public class CustomLinkedList<T>  implements Iterable<T> {
    private Node root;
    private int size;

    public CustomLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(T data){
        if(this.root == null){
            this.root = new Node(data);
        }else{
            Node currentNode = this.root;
            Node temp = new Node(data);

            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(temp);
        }

        this.size++;
    }

    public boolean remove(T value){
        Node currentNode = this.root;
        Node prevNode = null;
        while(currentNode != null){
            if(currentNode.getData().equals(value)){
                if(prevNode != null){
                    prevNode.setNextNode(currentNode.getNextNode());
                }else{
                    this.root = null;
                    this.root = currentNode.getNextNode();
                }
                this.size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class Node{
        private Node nextNode;
        private T data;

        private Node(){

        }
        private Node(T data){
            this.data = data;
        }
        private Node(T data, Node next){
            this.data = data;
            this.nextNode = next;
        }

        private Node getNextNode() {
            return this.nextNode;
        }

        private void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        private T getData() {
            return this.data;
        }

        private void setData(T data) {
            this.data = data;
        }
    }

    private final class CustomIterator implements Iterator<T>{
        private Node nextNode;

        public CustomIterator() {
            this.nextNode = root;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T toReturn = nextNode.getData();
            nextNode = nextNode.getNextNode();
            return toReturn;
        }
    }
}
