package Design_LinkedList;
// Node class for doubly-linked list
class ListNode<T extends ComparableValue<T>> {
    T val;
    ListNode<T> next;
    ListNode<T> prev;
    public ListNode(T val) { 
        this.val = val; 
    }
}

// Bidirectional sorted doubly-linked list
public class SortedDoublyLinkedList<T extends ComparableValue<T>> {
    private ListNode<T> head;
    private ListNode<T> tail;

    public SortedDoublyLinkedList() {
        head = new ListNode<>(null); // dummy head
        tail = new ListNode<>(null); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Insert while maintaining sort order
    public void insert(T val) {
        ListNode<T> node = new ListNode<>(val);
        ListNode<T> curr = head.next;
        while (curr != tail && curr.val != null && curr.val.isLessThan(val)) {
            curr = curr.next;
        }
        ListNode<T> prev = curr.prev;
        prev.next = node;
        node.prev = prev;
        node.next = curr;
        curr.prev = node;
    }

    // Remove an element
    public boolean remove(T val) {
        ListNode<T> curr = head.next;
        while (curr != tail) {
            if (curr.val.equals(val)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // Search for an element
    public ListNode<T> search(T val) {
        ListNode<T> curr = head.next;
        while (curr != tail) {
            if (curr.val.equals(val)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    // Get next element
    public T getNext(ListNode<T> node) {
        return node.next != tail ? node.next.val : null;
    }

    // Get previous element
    public T getPrev(ListNode<T> node) {
        return node.prev != head ? node.prev.val : null;
    }

    // Print the list
    public void printList() {
        ListNode<T> curr = head.next;
        while (curr != tail) {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}