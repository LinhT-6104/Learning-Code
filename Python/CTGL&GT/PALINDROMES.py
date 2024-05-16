class Stack:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[-1]

    def size(self):
        return len(self.items)


class Queue:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.insert(0, item)

    def dequeue(self):
        return self.items.pop()

    def size(self):
        return len(self.items)


def isPalindrome(s):
    stack = Stack()
    queue = Queue()
    for char in s:
        stack.push(char)
        queue.enqueue(char)
    while not stack.isEmpty() and not queue.isEmpty():
        if stack.pop() != queue.dequeue():
            return False
    return True

# Hàm main để thử nghiệm
if __name__ == "__main__":
    string = input("Nhập xâu cần kiểm tra: ")
    if isPalindrome(string):
        print("Xâu đối xứng")
    else:
        print("Xâu không đối xứng")
    