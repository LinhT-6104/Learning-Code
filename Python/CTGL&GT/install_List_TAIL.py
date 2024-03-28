class ListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.len = 0

    def add_item(self, item):
        new_node = ListNode(item)
        if self.head is None:
            self.head = new_node
        else:
            self.tail.next = new_node
        self.tail = new_node
        self.len += 1

    def delete_item(self, target):
        preNode = None
        curNode = self.head
        while curNode is not None and curNode.data != target:
            preNode = curNode
            curNode = curNode.next
        
        if curNode is not None:
            if curNode is self.head:
                self.head = curNode.next
            else:
                preNode.next = curNode.next
            if curNode is self.tail:
                self.tail = preNode
    
    def show(self):
        curNode = self.head
        while curNode is not None:
            print(curNode.data)
            curNode = curNode.next
        return self.head

a = LinkedList()
a.add_item(5)
a.add_item(4)
a.add_item(3)
a.delete_item(4)
a.show()