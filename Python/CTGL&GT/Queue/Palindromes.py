class Queue:
    def __init__(self):
        self.items = []
    def isEmpty(self):
        return len(self.items) == 0
    def length(self):
        return len(self.items)
    def enqueue(self, x):
        self.items.insert(0, x)
    def dequeue(self):
        return self.items.pop()
    def getHead(self):
        return self.items[-1]
class Stack:
    def __init__(self):
        self.items = []
    def isEmpty(self):
        return self.items == []
    def length(self):
        return len(self.items)
    def push(self, x):
        self.items.append(x)
    def pop(self):
        return self.items.pop()
    def peek(self):
        return self.items[-1]
    
def isPalindromes(s):
    stack = Stack()
    queue = Queue()
    for c in s:
        stack.push(c)
        queue.enqueue(c)
    while not stack.isEmpty() and not queue.isEmpty():
        if stack.pop() != queue.dequeue():
            return False
    return True

S1 = "abc"
S2 = "aba"
print(isPalindromes(S1))
print(isPalindromes(S2))