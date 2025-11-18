class ListNode:
    def __init__(self,val):
        self.val = val
        self.next = None
        self.prev = None
class LinkedList:
    def __init__(self):
        self.head = ListNode(0)
    
    def addAtHead(self,val):
        node = ListNode(val)
        node.next = self.head.next
        self.head.next = node

    def addAtMiddle(self,val):
        if not self.head.next:
            new_node = ListNode(val)
            self.head.next = new_node
            return
        slow = self.head
        fast = self.head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        new_node = ListNode(val)
        new_node.next = slow.next   
        slow.next = new_node
    def removeMiddle(self):
        if not self.head or not self.head.next:
            return

        slow = self.head
        fast = self.head.next.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        if slow.next:
            slow.next = slow.next.next
    def removefromIndex(self,index):
        if not self.head.next:
            return
        curr = self.head
        for _ in range(index):
            if curr.next:
                curr = curr.next
            else:
                return
        if curr.next:
            curr.next = curr.next.next


if __name__ == "__main__":
    l1 = LinkedList()
    l1.addAtHead(1)
    l1.addAtMiddle(2)
    l1.addAtMiddle(3)
    l1.addAtHead(4)
    l1.removefromIndex(2)
    print(l1.head.next.next.val)
