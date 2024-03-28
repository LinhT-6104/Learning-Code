def InsertNode(head, value):
    # Tìm vị trí để chèn giá trị mới
    predNode = None
    curNode = head
    while curNode is not None and value >= curNode.data:
        preNode = curNode
        curNode = curNode.next
    
    # Tạo nút mới từ value
    newNode = ListNode(value)
    newNode.next = curNode

    # Liên kết nút mới vào danh sách
    if curNode is head:
        head = newNode
    else:
        predNode.next = newNode