class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedNode:
    def __init__(self):
        self.head = None
        
    def insertFirst(self, value):
        newNode = Node(value)
        newNode.next = self.head
        self.head = newNode
        return self.head
        
    def traversal(self):
        curNode = self.head
        while curNode is not None:
            print(curNode.data)
            curNode = curNode.next
    
    def remove(self, value):
        if not self.head:
            return
        if self.head.data == value:
            self.head = self.head.next
            return self.head
        else:
            preNode = None
            curNode = self.head
            while curNode is not None and curNode.data != value:
                preNode = curNode
                curNode = curNode.next
            if curNode is not None:
                preNode.next = curNode.next
            return self.head

n = int(input())
myList = LinkedNode()
for _ in range(n):
    value = int(input())
    myList.insertFirst(value)
    
value = int(input()) # Input value delete

myList.remove(value)

myList.traversal()
