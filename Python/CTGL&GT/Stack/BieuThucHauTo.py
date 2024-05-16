class Stack:
    def __init__(self, maxSize):
        self.top = -1
        self.size = 0
        self.stackArray = [None]*maxSize
    def isEmpty(self):
        return self.size == 0
    def isFull(self):
        return self.size == len(self.stackArray)
    def getTop(self):
        return self.stackArray[self.top]
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
def bieuThucHauTo(s):
    result = Stack(len(s))
    for c in s:
        if c.isdigit():
            result.push(int(c))
        else:
            so2 = result.pop()
            so1 = result.pop()
            if c == '+':
                result.push(so1 + so2)
            elif c == '-':
                result.push(so1 - so2)
            elif c == '*':
                result.push(so1 * so2)
            elif c == '/':
                result.push(so1 / so2)
    return result.pop()

print(bieuThucHauTo("45+12+-3/"))