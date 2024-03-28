'''
Em hãy viết chương trình xoá một nút trong danh sách liên kết đơn với tham chiếu Head và Tail.

Input:

Giá trị đầu tiên n: số phần tử của danh sách
n giá trị tiếp theo: giá trị của phần tử cần thêm vào đầu danh sách
Giá trị cuối cùng: giá trị cần tìm kiếm
Output:

các giá trị của danh sách được in theo thứ tự từ nút đầu đến nút cuối sau khi xoá nút
'''

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insertFirst(self, data):
        newNode = Node(data)
        newNode.next = self.head
        self.head = newNode
        if self.tail is None:
            self.tail = newNode
        return self.head

    def delete(self, value):
        prevNode = None
        curNode = self.head
        while curNode is not None and curNode.data != value:
            prevNode = curNode
            curNode = curNode.next
        if curNode is None:
            return self.head
        if prevNode is None:  # Nếu nút cần xóa là nút đầu tiên của danh sách
            self.head = curNode.next
            if self.head is None:  # Nếu danh sách trở thành rỗng
                self.tail = None
        elif curNode.next is None:  # Nếu nút cần xóa là nút cuối cùng của danh sách
            prevNode.next = None
            self.tail = prevNode
        else:
            prevNode.next = curNode.next
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
    myList.insertFirst(value)
d = int(input())
myList.delete(d)
myList.show()


