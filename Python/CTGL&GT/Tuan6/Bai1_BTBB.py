''' 
Em hãy viết chương trình thực hiện các công việc sau:

a) Cài đặt ngăn xếp bằng mảng hoặc danh sách liên kết gồm các phép toán: 

- Stack(): khởi tạo ngăn xếp rỗng

- isEmpty(): kiểm tra ngăn xếp có rỗng không

- push(value): thêm 1 phần tử có giá trị value vào đỉnh ngăn xếp

- pop(): loại bỏ phần tử ở đỉnh của ngăn xếp

b) Nhập vào 1 xâu gồm các kí hiệu "(" và ")", sau đó kiểm tra xâu nhập vào có chứa các dấu ngoặc hợp lệ hay không

Input:

Chuỗi chứa các dấu ngoặc
Output:

Trả về "Hop le" nếu chuỗi chứa các dấu ngoặc hợp lệ, ngược lại trả về "Khong hop le"

''' 

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None
        self.size = 0
    
    def isEmpty(self):
        return self.size == 0
    
    def getTop(self):
        return self.top
    
    def push(self, value):
        newNode = Node(value)
        newNode.next = self.top
        self.top = newNode
        self.size += 1
        return self.top
    
    def length(self):
        return self.size
    
    def pop(self):
        assert not self.isEmpty(), "Khong hop le"
        popped = self.top.data
        self.top = self.top.next
        self.size -= 1
        return popped

def check(s):
    stack = Stack()
    for x in s:
        if x == '(':
            stack.push('(')
        elif x == ')':
            if stack.isEmpty() or stack.pop() != '(':
                return False
    return stack.isEmpty()

s = input()
if check(s) == True:
    print("Hop le")
else:
    print("Khong hop le")
