class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
class BinaryTree:
    def __init__(self):
        self.root = None
    
    def insert(self, data):
        if self.root is None:
            self.root = Node(data)
        else:
            self.insert_recursively(self.root, data)
    
    def insert_recursively(self, current, data):
        if data < current.data:
            if current.left is None:
                current.left = Node(data)
            else:
                self.insert_recursively(current.left, data)
        elif data > current.data:
            if current.right is None:
                current.right = Node(data)
            else:
                self.insert_recursively(current.right, data)
        else:
            pass    # data already exists in the tree
    
    def search(self, data):
        return self.search_recursively(self.root, data)

    def search_recursively(self, current, data):
        if current is None:
            return False
        elif current.data == data:
            return True
        elif data < current.data:
            return self.search_recursively(current.left, data)
        else:
            return self.search_recursively(current.right, data)
    
    def preorder(self, root):
        if root is not None:
            print(root.data)
            self.preorder(root.left)
            self.preorder(root.right)

    def midorder(self, root):
        if root is not None:
            self.midorder(root.left)
            print(root.data)
            self.midorder(root.right)

    def lastorder(self, root):
        if root is not None:
            self.midorder(root.left)
            self.midorder(root.right)
            print(root.data)

tree = BinaryTree()
tree.insert(5)
tree.insert(3)
tree.insert(7)
tree.insert(2)
tree.insert(4)

print(tree.search(3))  # Output: True
print(tree.search(6))  # Output: False

tree.preorder()