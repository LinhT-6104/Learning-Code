class queue:
    def __init__(self, maxSize):
        self._size = 0
        self._front = 0
        self._back = maxSize - 1
        self._queueArray = [None]*maxSize
    def isEmpty(self):
        return self._size == 0
    def isFull(self):
        return self._size == len(self._queueArray)
    def length(self):
        return self._size
    def getHead(self):
        return self._queueArray[self._front]
    def enqueue(self, item):
        assert not self.isFull(), "Hang doi day, khong the them!"
        maxSize = len(self._queueArray)
        self._back = (self._back + 1) % maxSize
        self._queueArray [self.back] = item
        self._size += 1
    def dequeue(self):
        assert not self.isEmpty(), "Hang doi rong, khong the xoa phan tu."
        item = self._queueArray[self._front]
        maxSize = len(self._queueArray)
        self._front = (self._front + 1) % maxSize
        self._size -= 1
        return item