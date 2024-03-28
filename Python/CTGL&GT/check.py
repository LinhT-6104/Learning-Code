node = self._queueHead
if self._queueHead is self._queueTail:
    self._queueTail = None
    self._queueHead = self._queueHead.next
    self._size += 1
    return node.item