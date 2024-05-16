'''
    BSTree(), __len__, __contains__, _bstSearch, _bstMaximum, 
    _bstMinimum, _bstMaximum, add, _bstInsert(), remove(),
    _bstRemove
'''

class BSTreeNode():
    def __init__(self, key):
        self._key = key
        self._left = None
        self._right = None

class BSTree():
    def __init__(self):
        self._root = None
        self._size = 0

    def __len__(self):
        return self._size
    
    def __contains__(self, key):
        return self._bstSearch(self._root, key) is not None
    
    def _bstSearch(self, subtree, target):
        if subtree is None:
            return None
        elif target > subtree.key:
            return self._bstSearch(subtree.right, target)
        elif target < subtree.key:
            return self._bstSearch(subtree.left, target)
        else:
            return subtree
    
    def _bstMaximum(self, subtree):
        if subtree is None:
            return None
        elif subtree.right is None:
            return subtree
        else:
            return self._bstMaximum(self.right)
        
    def _bstMinimum(self, subtree):
        if subtree is None:
            return None
        elif subtree.left is None:
            return subtree
        else:
            return self._bstMinimum(subtree.left)
    
    def add(self, key):
        if self._bstSearch(key) is not None:
            return False
        else:
            self._root = self._bstInsert(self.root, key)
            self._size += 1
            return True
    
    def _bstInsert(self, subtree, key):
        if subtree is None:
            subtree = BSTreeNode(key)
        elif key > subtree.key:
            subtree.right = self._bstInsert(subtree.right, key)
        elif key < subtree.key:
            subtree.left = self._bstInsert(subtree.left, key)
        return subtree

    def remove(self, key):
        assert key in self, "Invalid list key"
        self._root = self._bstRemove(self._root, key)
        self._size -= 1
    
    def _bstRemove(self, subtree, key):
        if subtree is None:
            return None
        elif key > subtree.key:
            subtree.right = self._bstRemove(subtree.right, key)
            return subtree
        elif key < subtree.key:
            subtree.left = self._bstRemove(subtree.left, key)
            return subtree
        else:
            if subtree.left is None and subtree.right is None:
                return None
            elif subtree.left is None or subtree.right is None:
                if subtree.left is None:
                    return subtree.right
                else:
                    return subtree.left
            else:
                successor = self._bstMinimum(subtree.right)
                subtree.key = successor.key
                subtree.right = self._bstRemove(subtree.right, subtree.key)
                return subtree