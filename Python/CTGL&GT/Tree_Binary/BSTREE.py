class _BSTreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class BSTree:   
    def __init__(self): # Tạo một thể hiện cây nhị phân tìm kiếm rỗng
        self._root = None
        self._size = 0

    def __len__(self):  # Trả về số lượng các nút trên cây nhị phân tìm kiếm.
        return self._size
    
    def __contains__(self, key):    # Xác định xem cây có chứa khóa đã cho không
        return self._bstSearch(self._root, key) is not None
    
    # Phương thức tìm kiếm đệ quy cho một khóa đích
    def _bstSearch(self, subtree, target):
        if subtree is None: # Trường hợp cơ sở
            return None
        elif target < subtree.key:  
            return self._bstSearch(subtree.left, target)    # Khóa đích ở cây con bên trái
        elif target > subtree.key:  
            return self._bstSearch(subtree.right, target)   # Khóa đích ở cây con bên phải
        else:
            return subtree  # Trường hợp cơ sở

    # Phương thức tìm nút có giá trị khóa lớn nhất
    def _bstMaximum(self, subtree):
        if subtree is None:
            return None
        elif subtree.right is None:
            return subtree
        else:
            return self._bstMaximum(subtree.right)
    
    # Phương thức tìm nút có giá trị khóa nhỏ nhất
    def _bstMinimum(self, subtree):
        if subtree is None:
            return None
        elif subtree.left is None:
            return subtree
        else:
            return self._bstMinimum(subtree.left)
        
    # Phương thức thêm một phần tử mới vào cây
    def add(self, key):
        node = self._bstSearch(key) # Tìm vị trí đặt nút mới chứa khóa key
        # Nếu khóa key đã có trong cây thì trả về False
        if node is not None:
            return False
        # Ngược lại, thêm một nút mới
        else:
            self._root = self._bstInsert(self._root, key)
            self._size += 1
            return True
    
    # Phương thức chèn một nút mới vào cây theo cách đệ quy
    def _bstInsert(self, subtree, key):
        if subtree is None:
            subtree = _BSTreeNode(key)
        elif key < subtree.key:
            subtree.left = self._bstInsert(subtree.left, key)
        elif key > subtree.key:
            subtree.right = self._bstInsert(subtree.right, key)
        return subtree
    
    # Loại bỏ một phần tử tương ứng chứa khóa key
    def remove(self, key):
        assert key in self, "Invalid list key."
        self._root = self._bstRemove(self._root, key)
        self._size -= 1
    
    # Phương thức loại bỏ một phần tử theo cách đệ quy
    def _bstRemove(self, subtree, target):
        # Tìm phẩn tử trong cây 
        if subtree is None:
            return subtree
        elif target < subtree.key:
            subtree.left = self._bstRemove(subtree.left, target)
            return subtree
        elif target > subtree.key:
            subtree.right = self._bstRemove(subtree.right, target)
            return subtree
        # Tìm nút chứa khóa cần loại bỏ.
        else:
            if subtree.left is None and subtree.right is None:
                return None
            elif subtree.left is None or subtree.right is None:
                if subtree.left is not None:
                    return subtree.left
                else:
                    return subtree.right
            else:
                successor = self._bstMinimum(subtree.right)
                subtree.key = successor.key
                subtree.right = self._bstRemove(subtree.right, successor.key)
                return subtree        
            
''' ------------------------------------TestCase-------------------------------------------'''

# Tạo một cây rỗng và kiểm tra kích thước của nó
tree = BSTree()
assert len(tree) == 0, "Kích thước của cây rỗng không đúng"

# Thêm các phần tử vào cây và kiểm tra kích thước sau mỗi lần thêm
tree.add(10)
assert len(tree) == 1, "Kích thước của cây sau khi thêm 1 phần tử không đúng"
tree.add(5)
assert len(tree) == 2, "Kích thước của cây sau khi thêm 2 phần tử không đúng"
tree.add(15)
assert len(tree) == 3, "Kích thước của cây sau khi thêm 3 phần tử không đúng"

# Kiểm tra xem phần tử đã tồn tại trong cây hay chưa
assert 10 in tree, "Phần tử 10 không tồn tại trong cây"
assert 5 in tree, "Phần tử 5 không tồn tại trong cây"
assert 15 in tree, "Phần tử 15 không tồn tại trong cây"
assert 20 not in tree, "Phần tử 20 tồn tại trong cây"

# Loại bỏ một phần tử và kiểm tra kích thước của cây
tree.remove(5)
assert len(tree) == 2, "Kích thước của cây sau khi loại bỏ 1 phần tử không đúng"
assert 5 not in tree, "Phần tử 5 vẫn tồn tại trong cây sau khi loại bỏ"
