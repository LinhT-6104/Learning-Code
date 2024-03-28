''' 
Em hãy viết chương trình nhập vào n giá trị, mỗi giá trị nhập vào được chèn vào cuối danh sách liên kết (danh sách liên kết có tham chiếu Head và Tail) và in các giá trị của danh sách.

Input:

Giá trị đầu tiên: số phần tử của danh sách
Các giá trị tiếp theo: giá trị của phần tử cần thêm vào cuối danh sách
Output:

các giá trị của danh sách được in theo thứ tự từ nút đầu đến nút cuối
'''

class Node:
    def __init__ (self, data):
        self.data = data
        self.next = None

class LinkList:
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, value):
        newNode = Node(value)
        if self.head == None:
            self.head = self.tail = newNode
        else:
            self.tail.next = newNode
            self.tail = newNode
        return self.head
    
    def show(self):
        curNode = self.head
        while curNode is not None:
            print(curNode.data)
            curNode = curNode.next
        
n = int(input())
myList = LinkList()
for _ in range(n):
    value = int(input())
    myList.append(value)
myList.show()

            