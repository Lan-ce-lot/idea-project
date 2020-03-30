package work.work3_30;

public class Test {
    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 1; i <= 20; i++) {
            q.enqueue(i);
        }

        while (!q.empty()) {
            System.out.println(q.dequeue());
        }
    }
}

class Queue {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 8;

    // 构造默认大小8的队列
    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        elements = new int[capacity];
    }

    public void enqueue(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    // 利用arraycopy函数实现
    public int dequeue() {
        if (!empty()) {
            int temp = elements[0];
            System.arraycopy(elements, 1, elements, 0, elements.length - 1);
            size--;
            return temp;
        }
        System.out.println("队列空!");
        return -1;
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}