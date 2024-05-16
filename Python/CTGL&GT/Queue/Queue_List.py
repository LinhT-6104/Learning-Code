class Queue_List:
    def __init__(self):
        self.queueList = list()
    def isEmpty(self):
        return len(self.queueList) == 0
    def length(self):
        return len(self.queueList)
    def enqueue(self, value):
        self.queueList.append(value)
    def dequeue(self):
        assert not self.isEmpty(), "Mang rong, khong the xoa"
        return self.queueList.pop(0)
    def getHead(self):
        assert not self.isEmpty(), "List rỗng không thể lấy phần tử"
        return self.queueList[0]

# Test case
my_queue = Queue_List()
my_queue.enqueue(10)
my_queue.enqueue(20)
my_queue.enqueue(30)

print("Size of queue:", my_queue.size())  # Kích thước của hàng đợi
print("Dequeued item:", my_queue.dequeue())  # Lấy ra phần tử đầu tiên
print("Size of queue after dequeue:", my_queue.size())  # Kích thước sau khi lấy ra  