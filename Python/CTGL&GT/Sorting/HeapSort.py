def siftUp(ndx, theSeq):    # Chèn một nút vào đống
    child = ndx
    while child > 0:
        parent = (child - 1) // 2
        if theSeq[child] > theSeq[parent]:
            tmp = theSeq[child]
            theSeq[child] = theSeq[parent]
            theSeq[parent] = tmp
            child = parent
        else:
            break

def siftDown(ndx, theSeq):  # Trích rút một phần tử
    parent = 0
    while True:
        left = 2 * parent + 1
        right = 2 * parent + 2
        largest = parent
        if left <= ndx and theSeq[left] > theSeq[largest]:
            largest = left
        if right <= ndx and theSeq[right] > theSeq[largest]:
            largest = right
        if largest != parent:
            tmp = theSeq[parent]
            theSeq[parent] = theSeq[largest]
            theSeq[largest] = tmp
            parent = largest
        else:
            break

def heapsort(theSeq):
    n = len(theSeq)
    for i in range(n):
        siftUp(i, theSeq)
    for j in range(n-1, 0, -1):
        tmp = theSeq[j]
        theSeq[j] = theSeq[0]
        theSeq[0] = tmp
        siftDown(j-1, theSeq)

sequence = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]
heapsort(sequence)
print(sequence)
    