class Stack:
    def __init__(self, maxSize):
        self.stackArray = [None]*maxSize
        self.top = -1
        self.size = 0
    def isEmpty(self):
        return self.size == 0
    def isFull(self):
        return self.size == len(self.stackArray)
    def length(self):
        return self.size
    def getTop(self):
        return self.stackArray[self.top]
    def push(self, value):
        if self.isFull():
            print("Mảng đầy, không thể thêm")
        else:
            self.top += 1
            self.stackArray[self.top] = value
            self.size += 1
    def pop(self):
        if self.isEmpty():
            print("Mảng rỗng, không thể xóa")
            return None
        else:
            removed = self.getTop()
            self.stackArray[self.top] = None
            self.top -= 1
            self.size -= 1
            return removed

def isDauNgoacHopLe(x):
    check = Stack(len(x))
    bracket = [['(',')'], ['[',']'], ['{','}']]
    for c in x:
        for open, close in bracket:
            if c == open:
                check.push(c)
            elif c == close:
                if check.isEmpty() or check.pop() != open:
                    return False
    return check.isEmpty()
X = "[{}]"
print(isDauNgoacHopLe(X))  # Output: True

X = ['(', ')', '(', ')']
print(isDauNgoacHopLe(X))  # Output: True