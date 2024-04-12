import java.util.LinkedList;

public class MyStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public MyStack() {
        list = new LinkedList<E>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public void push(E item) {
        list.add(0, item);
    }
}