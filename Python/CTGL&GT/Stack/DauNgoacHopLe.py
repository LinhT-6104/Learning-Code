class Stack:
    def __init__(self, maxSize):
        self.top = -1
        self.size = 0
        self.stackArray = [None]*maxSize
    def isEmpty(self):
        return self.size == 0
    def isFull(self):
        return self.size == len(self.stackArray)
    def length(self):
        return self.size
    def push(self, x):
        if self.isFull():
            print("Mảng đầy, không thể thêm phần tử")
            return None
        self.top += 1
        self.stackArray[self.top] = x
        self.size += 1
    def pop(self):
        if self.isEmpty():
            print("Mảng rỗng, không thể xóa phần tử!")
            return None
        removed = self.stackArray[self.top]
        self.top -= 1
        self.size -= 1
        return removed
    def getTop(self):
        if self.isEmpty():
            print("Hàng đợi rỗng, không có phần tử trả về")
            return None
        return self.stackArray[self.top]
    
def isDauNgoacHopLe(s):
    check = Stack(len(s))
    parentheses = [['(',')'], ['[',']'], ['{','}']]
    for c in s:
        for open, close in parentheses:
            if c == open:
                check.push(c)
            elif c == close:
                if check.isEmpty() or check.pop() != open:
                    return False
    return check.isEmpty()

a = "(())"
print("Dấu ngoặc hợp lệ? ", isDauNgoacHopLe(a))