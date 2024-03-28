class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedNode:
    def __init__(self):
        self.head = None
        
    def insertLast(self, value):
        newNode = Node(value)
        if self.head is None:
            self.head = newNode
            return self.head
        curNode = self.head
        while curNode.next is not None:
            curNode = curNode.next
        curNode.next = newNode
        return self.head
        
    def traversal(self):
        curNode = self.head
        while curNode is not None:
            print(curNode.data)
            curNode = curNode.next

n = int(input())
myList = LinkedNode()
for _ in range(n):
    value = int(input())
    myList.insertLast(value)
myList.traversal()
