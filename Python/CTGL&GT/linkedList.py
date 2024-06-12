class ListNode:
    def __init__(self, hoTen, msnv, tuoi, viTri, mucLuong):
        self.hoTen = hoTen
        self.next = None
    
    # Hàm duyệt danh sách
    def traversal(self, head):              
        curNode = head                      # curNode = 1 
        while curNode is not None:          
            print(curNode.data)             # print(2) 
            curNode = curNode.next          # curNode = Node(2)
    
    # Hàm tìm kiếm
    def unorderSearch(self, head, value):
        curNode = head
        while curNode is not None and curNode.data != value:
            curNode = curNode.next
        return curNode is not None
    
    # Thêm một nút mới vào danh sách
    def insertNode(self, head, value):
        newNode = ListNode(value)  # Tạo 1 nút mới có trường dữ liệu là item
        newNode.next = head
        head = newNode
        return newNode

    # Xóa một nút khỏi danh sách
    def deleteNode(self, head, value):   
        preNode = None
        curNode = head
        while curNode is not None and curNode.data != 3:
            preNode = curNode
            curNode = curNode.next
        if curNode is not None:
            if curNode is head:
                head = curNode.next
            else:
                preNode.next = curNode.next
        return head
    
# Test case
a = ListNode(3)
a.insertNode(a, 3)
a.insertNode(a, 5)
a.traversal(a)