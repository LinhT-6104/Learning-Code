class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class Stack:
    def __init__(self):
        self.size = 0
        self.top = None
    def isEmpty(self):
        return self.size == 0
    def length(self):
        return self.size
    def getTop(self):
        assert not self.isEmpty(), "Mang rong khong the tra ve phan tu dau"
        return self.top.data
    def push(self, value):
        newNode = Node(value)
        newNode.next = self.top
        self.top = newNode
        self.size += 1
    def pop(self):
        assert not self.isEmpty(), "Mang rong khong the xoa phan tu"
        popped = self.top.data
        self.top = self.top.next
        self.size -= 1
        return popped
def thapPhanSangBatPhan(x):
    octal = Stack()
    while x != 0:
        a = x % 8
        x = x // 8
        octal.push(a)
    octal_search = ""
    while not octal.isEmpty():
        octal_search += str(octal.pop())
    return octal_search

print(thapPhanSangBatPhan(167))