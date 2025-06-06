public class ArrayQueue {
    private int front, rear, capacity;
    private int[] queue;
    public ArrayQueue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }
    public void enqueue(int item) {
        if (rear == capacity) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear++] = item;
    }
    public int dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        return item;
    }
    public int peek() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }
    public boolean isEmpty() {
        return front == rear;
    }
    public void display() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // 10 20 30
        System.out.println("Dequeued: " + q.dequeue());
        q.display(); // 20 30
        System.out.println("Front element: " + q.peek()); // 20
    }
}

