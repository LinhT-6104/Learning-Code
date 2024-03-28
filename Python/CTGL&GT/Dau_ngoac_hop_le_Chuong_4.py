class Node:
    def __init__ (self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.size = 0
        self.top = None
    
    def isEmpty(self):
        return self.size == 0

    def length(self):
        curNode = self.top
        count = 0
        while curNode is not None:
            curNode = curNode.next
            count += 1
        return count

    def push(self, x):
        newNode = Node(x)
        newNode.next = self.top
        self.top = newNode
        self.size += 1
        return self.top

    def pop(self):
        if self.isEmpty():
            return None
        popped = self.top.data
        self.top = self.top.next
        self.size -= 1
        return popped

    def getTop(self):
        return self.top.data

def check(x):
    stack = Stack()
    parentheses_pairs = [('(', ')'), ('{', '}'), ('[', ']')]
    
    for c in x:
        for open, close in parentheses_pairs:
            if c == open:
                stack.push(c)
            elif c == close:
                if stack.isEmpty() or stack.pop() != open:
                    return False
    return stack.isEmpty()
    
X = "[{}]"
print(check(X))  # Output: True

X = ['(', ')', '(', ')']
print(check(X))  # Output: True