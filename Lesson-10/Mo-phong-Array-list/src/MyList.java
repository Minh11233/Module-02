public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index <= size) {
            for (int i = size; i > index; i--) {
                    E holder;
                    elements[i] = elements[i - 1];
                }
            elements[index] = element;
            }
        }

    public E remove(int index) {
        for (int i = 0; i < size; i++) {
            if (index == i) {
                elements[i] = elements[i+1];
            }
        }
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if ()
        }
    }

    public boolean add(E e) {
        return false;
    }

    public void ensureCapacity(int minCapacity) {

    }


}

