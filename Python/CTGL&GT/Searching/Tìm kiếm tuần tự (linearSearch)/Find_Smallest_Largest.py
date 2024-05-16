def FindSmallest(theSeq):
    n = len(theSeq)
    smallest = theSeq[0]    # Giả sử phần tử đầu tiên là nhỏ nhất
    for i in range(1, n):
        if theSeq[i] < smallest:    # Xác định xem có phần tử nào trong dãy nhỏ hơn không
            smallest = theSeq[i]
    return smallest # Trả về giá trị nhỏ nhất trong dãy.

def findLargest(theSeq):
    n = len(theSeq)
    largest = theSeq[0] # Giả sử phần tử đầu tiên là lớn nhất
    for i in range(1, n):   # Xác định xem có phần tử nào trong dãy lớn hơn không
        if theSeq[i] > largest:
            largert = theSeq[i]
    return largest # Trả về giá trị lớn nhất trong dãy.