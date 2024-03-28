''' 
Em hãy viết chương trình thực hiện các công việc sau:

a) Cài đặt ngăn xếp bằng mảng hoặc danh sách liên kết gồm các phép toán: 

- Stack(): khởi tạo ngăn xếp rỗng

- isEmpty(): kiểm tra ngăn xếp có rỗng không

- push(value): thêm 1 phần tử có giá trị value vào đỉnh ngăn xếp

- pop(): loại bỏ phần tử ở đỉnh của ngăn xếp

b) Thực hiện các thao tác với ngăn xếp:

- Nhập vào giá trị nguyên dương n. 

- Nhập và n giá trị nguyên dương và thực hiện thêm lần lượt vào đỉnh ngăn xếp.

- Loại bỏ một phần tử ở đỉnh ngăn xếp

- In nội dung của ngăn xếp theo thứ tự từ đỉnh xuống đáy

Input:

n: số phần tử cần thêm vào ngăn xếp
n giá trị tiếp theo: các giá trị cần thêm vào năng xếp
Output:

Nội dung ngăn xếp (từ đỉnh đến đáy) sau khi thêm n phần tử và loại bỏ 1 phần tử

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
    
    def push(self, value):
        newNode = Node(value)
        newNode.next = self.top
        self.top = newNode
        self.size += 1
        return self.top
    
    def pop(self):
        assert not self.isEmpty(), "Khong hop le"
        popped = self.top.data
        self.top = self.top.next
        self.size -= 1
        return popped

n = int(input())
stack = Stack()

for _ in range(n):
    value = int(input())
    stack.push(value)

stack.pop()

while not stack.isEmpty():
    print(stack.pop())