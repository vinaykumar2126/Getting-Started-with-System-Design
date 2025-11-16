class ListNode:
    def __init__(self,val):
        self.val = val
        self.next = None
        self.prev = None
class LinkedList:
    def __init__(self):
        self.head = ListNode(0)
        self.tail = ListNode(0)
        self.head.next = self.tail
        self.tail.prev = self.head
    def addAtHead(self,val):
        node = ListNode(val)
        new_node = self.head.next
        node.next = new_node    
        node.prev = self.head
        new_node.prev = node
        self.head.next = node
    def addAtTail(self,val):
        node = ListNode(val)
        node.prev = self.tail.prev
        node.next = self.tail
        self.tail.prev.next = node
        self.tail.prev = node
    def get(self,index):
        curr = self.head.next
        count = 1
        while count!=index and curr!=self.tail:
            curr = curr.next
            count+=1
        return curr.val

    def addAtIndex(self,index,val):
        curr = self.head.next
        count = 0
        while count!=index and curr!=self.tail:
            curr = curr.next
            count+=1
        node = ListNode(val)
        curr.prev.next = node
        node.next = curr
        node.prev = curr.prev
        curr.prev = node

    def deleteAtIndex(self,index):
        count = 0
        curr = self.head.next
        while count!=index and curr!=self.tail:
            curr = curr.next
            count+=1
        curr.prev.next = curr.next
        curr.next.prev = curr.prev
    def printList(self):
        curr = self.head.next
        while curr!=self.tail:
            print(curr.val,end="->")
            curr = curr.next


if __name__ == "__main__":
    l1 = LinkedList()
    l1.addAtHead(1)
    l1.addAtTail(2)
    l1.addAtTail(3)
    l1.addAtTail(4)
    l1.addAtIndex(2,5)
    print(l1.get(2))
    # print(l1.head.next.val)
    l1.deleteAtIndex(2)
    l1.printList()