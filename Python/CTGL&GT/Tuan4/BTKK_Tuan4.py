class Node:     # Đại diện cho mỗi nút trong danh sách liên kết
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:   # Đại diện cho danh sách liên kết
    def __init__(self): # Khởi tạo danh sách rỗng
        self.head = None
    
    def __len__(self):  # Trả về số phần tử của danh sách
        count = 0
        curNode = self.head
        while curNode is not None:
            count += 1
            curNode = curNode.next
        return count
    
    # Thêm giá trị value vào đầu danh sách
    def insertFirst(self, value):
        newNode = Node(value)
        newNode.next = self.head
        self.head = newNode
        return self.head
    
    # Chèn value vào vị trí thứ pos trong danh sách
    def insert(self, pos, value):
        if pos < 0 or pos > len(self):
            raise IndexError("Index out of range")
        if pos == 0:
            self.insertFirst(value)
            return
        else:
            newNode = Node(value)
            curNode = self.head
            for _ in range(pos - 1):
                curNode = curNode.next
            newNode.next = curNode.next
            curNode.next = newNode
            return self.head

    # Thêm giá trị value vào cuối danh sách
    def append(self, value):
        newNode = Node(value)
        if self.head is None:
            self.head = newNode
            return self.head
        curNode = self.head
        while curNode.next is not None:
            curNode = curNode.next
        curNode.next = newNode
        return self.head

    # Xóa giá trị value khỏi danh sách
    def delete(self, value):
        if not self.head:
            return 
        if self.head.data == value:
            self.head = self.head.next
            return self.head
        preNode = None
        curNode = self.head
        while curNode is not None and curNode.data != value:
            preNode = curNode
            curNode = curNode.next
        preNode.next = curNode.next
        return self.head

    # Duyệt danh sách
    def traversal(self):
        curNode = self.head
        while curNode is not None:
            print(curNode.data)
            curNode = curNode.next
        return self.head

# Nhập vào 3 giá trị và chèn vào đầu danh sách
myList = LinkedList()
for _ in range (3):
    value = int(input("- Nhap gia tri chen vao dau danh sach: "))
    myList.insertFirst(value)


# Nhập vào 1 giá trị chèn vào cuối danh sách
value = int(input("- Nhap gia tri chen vao cuoi danh sach: "))
myList.append(value)


# Nhập vào 1 giá trị chèn vào vị trí 4 trong danh sách
value = int(input("- Nhap gia tri chen vao vi tri thu 4 trong danh sach: "))
myList.insert(4, value)

# Nhập vào 1 giá trị, tìm kiếm giá trị đó trong danh sách và xoá giá trị khỏi danh sách
value = int(input("- Nhap gia tri can tim va xoa khoi danh sach: "))
myList.delete(value)

# In các phần tử của danh sách
myList.traversal()