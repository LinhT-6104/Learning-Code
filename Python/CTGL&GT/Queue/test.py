class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class queue:
    def __init__(self):
        self.size = 0
        self.front = None
        self.back = None
    def isEmpty(self):
        return self.size == 0
    def length(self):
        return self.size
    def enqueue(self, value):
        newNode = Node(value)
        if self.isEmpty():
            self.head = newNode
        else:
            newNode.next = self.back
        self.back = newNode
        self.size += 1
    def dequeue(self):
        assert not self.isEmpty(), "Nut rong, khong the xoa nut"
        popped = self.front.data
        self.front = self.front.next
        self.size -= 1
        return popped
    def getHead(self):
        assert not self.isEmpty(), "Nut rong, khong co nut tra ve"
        return self.front.data