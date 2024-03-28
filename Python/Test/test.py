class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None
        self.size = 0
    
    def isEmpty(self):
        return self.top is None
    
    def getTop(self):
        if self.isEmpty():
            return None
        return self.top.data
    
    def length(self):
        return self.size
    
    def push(self, value):
        newNode = Node(value)
        newNode.next = self.top
        self.top = newNode
        self.size += 1
        
    def pop(self):
        if self.isEmpty():
            return False
        popped = self.top.data
        self.top = self.top.next
        self.size -=1
        return popped