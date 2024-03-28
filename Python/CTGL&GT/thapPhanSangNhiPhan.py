class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None

    def is_empty(self):
        return self.top is None

    def push(self, data):
        new_node = Node(data)
        new_node.next = self.top
        self.top = new_node

    def pop(self):
        if self.is_empty():
            return None
        popped = self.top.data
        self.top = self.top.next
        return popped

def decimal_to_binary(decimal_number):
    if decimal_number == 0:
        return '0'
    
    stack = Stack()

    while decimal_number > 0:
        remainder = decimal_number % 2
        stack.push(remainder)
        decimal_number //= 2

    binary_number = ''
    while not stack.is_empty():
        binary_number += str(stack.pop())

    return binary_number

# Ví dụ: chuyển đổi số 10 thành dạng nhị phân
decimal_number = 10
binary_number = decimal_to_binary(decimal_number)
print("Số nhị phân của", decimal_number, "là:", binary_number)
