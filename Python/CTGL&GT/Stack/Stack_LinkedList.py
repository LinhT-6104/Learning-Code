class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class Stack:
    def __init__(self):
        self.size = 0
        self.top = None
    def isEmpty(self):
        return self.top is None
    def length(self):
        return self.size
    def push(self, item):   
        newNode = Node(item)
        newNode.next = self.top
        self.top = newNode
        self.size += 1
    def pop(self):
        assert not self.isEmpty(), "Mảng rỗng, không thể xóa phần tử"
        removed = self.top.data     
        self.top = self.top.next   
        self.size -= 1
        return removed
    def getTop(self):
        assert not self.isEmpty(),"Mang rong, khong the lay phan tu"
        return self.top.data

# Test case
# Sử dụng ngăn xếp
stack = Stack()

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