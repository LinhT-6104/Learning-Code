import array

# Gộp giá trị vào mảng ảo rồi cho vào mảng chính
def mergeVirtualSeq(theSeq, left, right, end, tmpArray):
    a = left
    b = right
    m = 0
    while a < right and b < end:
        if theSeq[a] < theSeq[b]:
            tmpArray[m] = theSeq[a]
            a += 1
        else:
            tmpArray[m] = theSeq[b]
            b += 1
        m += 1
    while a < right:
        tmpArray[m] = theSeq[a]
        a += 1
        m += 1
    while b < end:
        tmpArray[m] = theSeq[b]
        b += 1
        m += 1
    for i in range(end - left):
        theSeq[left + i] = tmpArray[i]

def recMergeSort(theSeq, first, last, tmpArray):
    if first == last:
        return theSeq
    else:
        mid = (first + last) // 2
        recMergeSort(theSeq, first, mid, tmpArray)
        recMergeSort(theSeq, mid + 1, last, tmpArray)
        mergeVirtualSeq(theSeq, first, mid + 1, last + 1, tmpArray)
# 
def mergeSort(theSeq):
    n = len(theSeq)

    tmpArray = array.array('i', [0]*n)
    recMergeSort(theSeq, 0, n-1, tmpArray)

sequence = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]

mergeSort(sequence)
print(sequence)