public class CustomStack {
    private int[] stack;
    private int top;
    private int size;

    public CustomStack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("스택이 모두 채워진 상태입니다.");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비워진 상태입니다.");
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }
}
