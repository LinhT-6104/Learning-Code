import stack

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def build_expression_tree(expression):
    stack = []  # Sử dụng stack để xây dựng cây biểu thức

    for token in expression:
        if token.isdigit():
            stack.append(Node(token))  # Nếu token là toán hạng, thêm nút mới vào stack
        else:
            # Nếu token là toán tử, tạo một nút mới và gán nút con trái và nút con phải của nó từ stack
            new_node = Node(token)
            new_node.right = stack.pop()
            new_node.left = stack.pop()
            stack.append(new_node)  # Thêm nút mới vào stack

    # Stack sẽ chỉ còn một phần tử duy nhất, đó chính là nút gốc của cây biểu thức
    return stack.pop()

# Ví dụ: biểu thức số học "3 * (4 + 5)"
expression = ['3', '*', '(', '4', '+', '5', ')']

# Xây dựng cây biểu thức từ biểu thức đã cho
expression_tree = build_expression_tree(expression)

# In cây biểu thức dưới dạng duyệt trước (preorder traversal)
def preorder_traversal(root):
    if root is not None:
        print(root.data, end=" ")
        preorder_traversal(root.left)
        preorder_traversal(root.right)

print("Preorder Traversal of Expression Tree:")
preorder_traversal(expression_tree)
