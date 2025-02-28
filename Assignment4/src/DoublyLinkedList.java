class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }
    public void add(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public Node removeLast() {
        if (tail == null) {
            return null;
        }

        Node remove = tail;
        Node end = remove.prev;

        if (end != null) {
            end.next = null;
        } else {
            head = null; // If the list becomes empty after removal
        }

        tail = end;
        return remove; // Return the removed node
    }





    public void remove(char data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public void addString(String str) {
        for (int i = 0; i < str.length(); i++) {
            add(str.charAt(i));
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

}
