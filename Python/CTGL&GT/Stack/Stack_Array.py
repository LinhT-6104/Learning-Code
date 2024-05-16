class Stack:
    def __init__(self, maxSize):
        self._size = 0
        self._top = -1
        self._stackArray = [None]*maxSize
    
    def isEmpty(self):
        return self._size == 0
    
    def isFull(self):
        return self._size == len(self._stackArray)
    
    def length(self):
        return self._size
    
    def getTop(self):
        return self._stackArray[self._top]
    
    def push(self, item):
        assert not self.isFull(), "Ngăn xếp đầy, không thể thêm phần tử"
        self._top += 1
        self._stackArray[self._top] = item
        self._size += 1
    
    def pop(self):
        assert not self.isEmpty(), "Hàng đợi rỗng, không thể xóa phần tử"
        item = self._stackArray[self._top]
        self._top -= 1
        self._size -= 1
        return item

# Test case
# Sử dụng ngăn xếp
stack = Stack(0)

# Thêm phần tử vào ngăn xếp
stack.push(1)
stack.push(2)
stack.push(3)

# Lấy giá trị của phần tử ở đầu ngăn xếp
print("Phần tử ở đầu ngăn xếp:", stack.getTop())

# Xóa phần tử từ đầu ngăn xếp và in ra giá trị đã xóa
print("Phần tử đã xóa:", stack.pop())

# Kiểm tra xem ngăn xếp có rỗng không
print("Ngăn xếp có rỗng không?", stack.isEmpty())

# In ra số lượng phần tử trong ngăn xếp
print("Số lượng phần tử trong ngăn xếp:", stack.length())