class ArrayBinaryTree:
    def __init__(self, maxSize):
        self.maxSize = maxSize
        self.tree = [None] * maxSize

    def insert(self, value):
        if self.tree[0] is None:
            self.tree[0] = value
            return True
        else:
            for i in range(self.maxSize):
                if self.tree[i] is None:
                    parent = (i - 1) // 2
                    if i % 2 == 0:
                        self.tree[parent * 2 + 1] = value
                    else:
                        self.tree[parent * 2 + 2] = value
                    return True
            return False