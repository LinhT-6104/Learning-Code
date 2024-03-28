class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class ExpressionTree:
    def __init__(self, expStr):
        self._expTree = None
        self._buildTree(expStr)

    def evaluate(self):
        return self._evalTree(self._expTree)

    def _evalTree(self, root):
        if root.left is None and root.right is None:
            return int(root.data)
        else:
            lvalue = self._evalTree(root.left)
            rvalue = self._evalTree(root.right)
            return self._computeOp(lvalue, root.data, rvalue)

    def _computeOp(self, left, op, right):
        if op == '+':
            return left + right
        elif op == '-':
            return left - right
        elif op == '*':
            return left * right
        elif op == '/':
            return left / right

    def _buildTree(self, expStr):
        operators = {'+', '-', '*', '/'}
        stack = []

        for token in expStr:
            if token.isdigit():
                stack.append(Node(token))
            elif token in operators:
                new_node = Node(token)
                new_node.right = stack.pop()
                new_node.left = stack.pop()
                stack.append(new_node)

        self._expTree = stack.pop()

def main():
    expression = "3*5+2"
    exp_tree = ExpressionTree(expression)
    print("Expression:", expression)
    print("Result:", exp_tree.evaluate())  # Output: 17

if __name__ == "__main__":
    main()
