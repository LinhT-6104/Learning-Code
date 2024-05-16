class queue:
    def __init__(self):
        self.queueList = list()
    def isEmpty(self):
        return len(self.queueList) == 0
    def length(self):
        return len(self.queueList)
    def getHead(self):
        return self.queueList[0]
    def enqueue(self, value):
        self.queueList.append(value)
    def dequeue(self):
        assert not self.isEmpty(), "list rong, khong the xoa"
        return self.queueList.pop(0)
    