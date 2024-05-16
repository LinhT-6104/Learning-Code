class Stack:
    def __init__(self, maxSize):
        self.size = 0
        self.top = -1
        self.stackArray = [None]*maxSize
    def isEmpty(self):
        return self.size == 0
    def isFull(self):
        return self.size == len(self.stackArray)
    def push(self, value):
        assert not self.isFull(), "Mang day khong the them phan tu"
        self.top += 1
        self.stackArray[self.top] = value
        self.size += 1
    def pop(self):
        assert not self.isEmpty(), "Mang rong khong the xoa phan tu"
        popped = self.stackArray[self.top]
        self.stackArray[self.top] = None
        self.top -= 1
        self.size -= 1
        return popped

def thapPhanSangNhiPhan(x):
    result = Stack(32)
    while x != 0:
        result.push(x%2)
        x //= 2
    binary_string = ""
    while not result.isEmpty():
        binary_string += str(result.pop())
    return binary_string

# test case
print(thapPhanSangNhiPhan(5))   ## 101
        