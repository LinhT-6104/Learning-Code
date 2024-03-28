class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:    # Đầu bên trái, đuôi bên phải
    def __init__(self):
        self.head = None
        self.rear = None
        self.size = 0
        
    def isEmpty(self):
        # return self.size == 0
        return self.head is None
    
    def length(self):
        return self.size
    
    def enqueue(self, x):
        newNode = Node(x)
        if self.isEmpty():
            self.head = self.rear = newNode
        else:
            newNode.next = self.rear
        self.rear = newNode
        self.size += 1
    
    def dequeue(self):
        if self.isEmpty():
            print("Hàng đợi rỗng.")
            return None
        else:
            removed = self.head.data
            self.head = self.head.next
            self.size -= 1
            return removed
    
    def getHead(self):
        if self.isEmpty():
            print("Hàng đợi rỗng.")
            return None
        else:
            return self.head.data
    
# input preview
queue = Queue()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)

print("Số phần tử trong hàng đợi:", queue.length())
print("Phần tử đầu tiên trong hàng đợi:", queue.getHead())

print("Lấy ra phần tử đầu tiên:", queue.dequeue())
print("Số phần tử trong hàng đợi:", queue.length())