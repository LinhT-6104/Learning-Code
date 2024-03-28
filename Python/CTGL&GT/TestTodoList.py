class Node:
    def __init__(self, data, priority):
        self.data = data
        self.priority = priority
        self.next = None
class TodoList:
    def __init__(self):
        self.head = self.tail = None

    def isEmpty(self):
        return self.head is None
    
    def enqueue(self, data, priority):
        newNode = Node(data, priority)

        if self.head is None:
            self.head = self.tail = newNode
        else:
            if priority < self.head.priority:
                newNode.next = self.head
                self.head = newNode
            elif priority > self.tail.priority:
                self.tail.next = newNode
                self.tail = newNode
            else:
                preNode = self.head
                curNode = self.head.next
                while curNode is not None and priority >= curNode.priority:
                    preNode = curNode
                    curNode = curNode.next
                preNode.next = newNode
                newNode.next = curNode
    def dequeue(self):
        if self.isEmpty():
            print("Đã hết việc cần làm")
        else:   self.head = self.head.next

