public class IntDoublyLinkedList {
    private IntNode head;
    private IntNode tail;

    public IntDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {
        IntNode newNode = new IntNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public IntNode removeLast() {
        if (tail != null) {
            IntNode temp = tail;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            return temp;
        }
        return null;
    }

    public int getLast() {
        if (tail != null) {
            return tail.data;
        }
        return 0;
    }

    public boolean isEmpty() {
        return head == null;
    }



}