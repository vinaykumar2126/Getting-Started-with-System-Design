package Design_LinkedList;

public class Main {
    public static void main(String[] args) {
        SortedDoublyLinkedList<MyInt> dll = new SortedDoublyLinkedList<>();
        dll.insert(new MyInt(5));
        dll.insert(new MyInt(2));
        dll.insert(new MyInt(8));
        dll.insert(new MyInt(3));
        dll.printList(); // Output: 2 <-> 3 <-> 5 <-> 8 <-> null

        ListNode<MyInt> node = dll.search(new MyInt(5));
        System.out.println("Next of 5: " + dll.getNext(node)); // Output: 8
        System.out.println("Prev of 5: " + dll.getPrev(node)); // Output: 3

        dll.remove(new MyInt(3));
        dll.printList(); // Output: 2 <-> 5 <-> 8 <-> null
    }
}
