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

n = int(input())
myList = LinkedNode()
for _ in range(n):
    value = int(input())
    myList.insertFirst(value)
myList.traversal()
