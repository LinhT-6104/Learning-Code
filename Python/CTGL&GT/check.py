class listnode:
    def __init__(self, data):
        self.data = data
        self.next = None
    
    # Duyệt danh sách 
    def traversal(self, head):
        curNode = head
        while curNode is not None:
            print(curNode.data)
            curNode = curNode.next
    
    # Tìm kiếm trong danh sách
    def unorderedSearch(self, head, target):
        curNode = head
        while curNode is not None and curNode.data != target:
            curNode = curNode.next
        return curNode is not None

    # Thêm một nút mới vào danh sách
    def insertNode(self, head, item):
        newNode = listnode(item)    # Tạo mới một nút có trường dữ liệu là item
        # Thay đổi liên kết để chèn một nút vào đầu DS
        newNode.next = head 
        head = newNode
        return newNode

    # Xóa một nút khỏi danh sách
    def deleteNode(self, head, target):
        predNode = None
        curNode = head
        while curNode is not None and curNode.data != target:
            predNode = curNode
            curNode = curNode.next

        if curNode is not None:
            if curNode is head: 
                head = curNode.next # Xóa nút đầu
            else:
                predNode.next = curNode.next # Xóa nút giữa   
        return head

	# Tạo danh sách
a = listnode(15)
b = listnode(63)
c = listnode(27)

a.next = b
b.next = c

# In ra giá trị của các nút
print(a.data)
print(a.next.data)
print(a.next.next.data, "\n")

# Duyệt danh sách
print("Duyệt danh sách:")
a.traversal(a)
print()

# Tìm kiếm trong danh sách
print("Tìm kiếm 63:", a.unorderedSearch(a, 63))
print("Tìm kiếm 100:", a.unorderedSearch(a, 100))
print()

# Thêm một nút mới vào danh sách
print("Thêm một nút mới có giá trị 100 vào đầu danh sách:")
a = a.insertNode(a, 100)
a.traversal(a)
print()

# Xóa một nút khỏi danh sách
print("Xóa nút có giá trị 63 khỏi danh sách:")
a = a.deleteNode(a, 63)
a.traversal(a)