class Stack:
    def __init__(self):
        self._stackList = list()
        
    def isEmpty(self):
        return len(self._stackList) == 0
    
    def length(self):
        return len(self._stackList)
    
    def getTop(self):
        assert not self.isEmpty(), "List rong khong co gia tri tra ve"
        return self._stackList[-1]
    
    def pop(self):
        assert not self.isEmpty(), "List rong, khong the xoa phan tu"
        return self._stackList.pop()

    def push(self, item):
        self._stackList.append(item)
        