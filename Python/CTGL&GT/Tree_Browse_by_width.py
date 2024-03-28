import queue
class Node:
    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None

def brow_by_width(root):
    if root is None:
        return 

    queue = [root]

    while queue:
        current_node = queue.pop(0)
        print(current_node.data)
        if current_node.left:
            queue.append(current_node.left)

        if current_node.right:
            queue.append(current_node.right)
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)

print("Breadth-First Traversal:")
brow_by_width(root)