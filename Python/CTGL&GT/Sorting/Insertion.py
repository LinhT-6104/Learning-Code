def insertionSort(theSeq):
    n = len(theSeq)
    for i in range(1, n):
        value = theSeq[i]
        pos = i
        while pos > 0 and value < theSeq[pos-1]:
            theSeq[pos] = theSeq[pos-1]
            pos -= 1
        theSeq[pos] = value

check = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]
insertionSort(check)
print(check)