# Định nghĩa một lớp lưu trữ riêng để tạo
class _BagListNode(object):
    def __init__(self, item):
        self.item = item
        self.next = None

class Bag:
    # Khởi tạo Bag rỗng
    def __init__(self):
        self._head = None
        self._size = 0
    
    # Trả lại số lượng đồ vật trong Bag
    def __len__(self):
        return self._size
    
    # Xác định xem một vật có trong Bag hay không.
    def __contains__(self, target):
        curNode = self._head
        while curNode is not None and curNode.item != target:
            curNode = curNode.next
        return curNode is not None
    
    # Thêm một đồ vật vào Bag
    def add(self, item):
        newNode = _BagListNode(item)
        newNode.next = self._head
        self._head = newNode
        self._size += 1
    
    # Loại bỏ một đồ vật ra khỏi Bag
    def remove(self, item):
        preNode = None
        curNode = self._head
        while curNode is not None and curNode.item != item:
            preNode = curNode
            curNode = curNode.next
        
        # Đồ vật phải nằm trong bag để loại bỏ
        assert curNode is not None, "The item must be in the bag."

        # Hủy liên kết nút và trả lại đồ
        self._size -= 1
        if curNode is self._head:
            self._head = curNode.next
        else:
            preNode.next = curNode.next
        return curNode.item
    