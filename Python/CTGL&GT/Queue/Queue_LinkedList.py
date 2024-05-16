class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class Queue:    # Đầu bên trái, đuôi bên phải
    def __init__(self):
        self.front = None
        self.back = None
        self.size = 0
    def isEmpty(self):
        return self.front is None
    def length(self):
        return self.size
    def enqueue(self,x):
        newNode = Node(x)
        if self.isEmpty():
            self.front = newNode
        else:
            newNode.next = self.back
        self.back = newNode
        self.size += 1
    def dequeue(self):
        if self.isEmpty():
            return None
        else:
            removed = self.front.data
            self.front = self.front.next
            self.size -= 1
            return removed
    def getHead(self):
        assert not self.isEmpty(), "Mang rong, khong the lay phan tu"
        return self.front.data

# input preview
queue = Queue()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
    
print("Số phần tử trong hàng đợi:", queue.length())
print("Phần tử đầu tiên trong hàng đợi:", queue.getHead())

print("Lấy ra phần tử đầu tiên:", queue.dequeue())
print("Số phần tử trong hàng đợi:", queue.length())

