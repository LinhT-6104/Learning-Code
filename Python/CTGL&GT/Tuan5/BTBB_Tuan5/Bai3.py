'''
Em hãy viết chương trình nhập vào n giá trị, mỗi giá trị nhập vào được chèn vào danh sách liên kết sao cho danh sách liên kết luôn được sắp xếp tăng dần và in các giá trị của danh sách.

Input:

Giá trị đầu tiên: số phần tử của danh sách
Các giá trị tiếp theo: giá trị của phần tử cần thêm vào đầu danh sách
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

    def insert(self, value):
        newNode = Node(value)
        if self.head is None:
            self.head = self.tail = newNode
        elif value <= self.head.data:
            newNode.next = self.head
            self.head = newNode
        elif value >= self.tail.data:
            self.tail.next = newNode
            self.tail = newNode
        else:
            curNode = self.head
            prevNode = None
            while curNode is not None and curNode.data < value:
                prevNode = curNode
                curNode = curNode.next
            prevNode.next = newNode
            newNode.next = curNode
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
    myList.insert(value)
myList.show()