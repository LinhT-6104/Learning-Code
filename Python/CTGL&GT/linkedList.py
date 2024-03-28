class ListNode:
    def __init__(self, data):
        self.data = data
        self.next = None
    
    # Hàm duyệt danh sách
    def traversal(self, head):
        curNode = head
        while curNode is not None:
            print(curNode.data)
            curNode = curNode.next
    
    # Hàm tìm kiếm
    def unorderSearch(self, head, target):
        curNode = head
        while curNode is not None and curNode.data != target:
            curNode = curNode.next
        return curNode is not None
    
    # Thêm một nút mới vào danh sách
    def insertNode(self, head, item):
        newNode = ListNode(item)  # Tạo 1 nút mới có trường dữ liệu là item
        newNode.next = head
        head = newNode
        return newNode

    # Xóa một nút khỏi danh sách
    def deleteNode(self, head, target):
        preNode = None
        curNode = head
        while curNode is not None and curNode.data != target:
            preNode = curNode
            curNode = curNode.next
        if curNode is not None:
            if curNode is head:
                head = curNode.next
            else:
                preNode.next = curNode.next
        return head
    
a = ListNode(3)
b = ListNode(4)
c = ListNode(5)

a.next = b
b.next = c

print(a.data)
print(a.next.data)
print(a.next.next.data)
print()

a.traversal(a)
print()

print(a.unorderSearch(a, 5))    # True
print(a.unorderSearch(a, 6))    # False
print(b.unorderSearch(b, 3))    # False
print(b.unorderSearch(a, 3))    # True
print()

a = a.insertNode(a, 6)
a.traversal(a)
print()

a = a.deleteNode(a, 5)
a.traversal(a)