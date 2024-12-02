public class CustomQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int count;

    public CustomQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.head = 0;
        this.tail = -1;
        this.count = 0;
    }

    public void add(int value) {
        if (isFull()) {
            throw new IllegalStateException("큐가 모두 채워진 상태입니다.");
        }
        tail = (tail + 1) % size;
        queue[tail] = value;
        count++;
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("큐가 비어있는 상태입니다.");
        }
        int value = queue[head];
        head = (head + 1) % size;
        count--;
        return value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == size;
    }
}
