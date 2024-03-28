class Node:
    def __init__(self, p, x):
        self.priority = p
        self.data = x
        self.next = 0

class Queue:
    def __init__(self):
        self.item  
        
    def isEmpty(self):
        if self.size == 0:
            return True
        else:
            return False
    
    def length(self):
        return self.size
    
    def enqueue(self, x):
        newNode = Node(x)
        if self.isEmpty():
            self.front = newNode
        else:
            curNode = 
            self.back.next = newNode
        self.back = newNode
        self.size += 1
    
    def dequeue(self):
        highest_pri = 
        while highest
    
    def getHead(self):
        if self.isEmpty():
            print("Hàng đợi rỗng.")
            return None
        else:
            return self.front.data
    