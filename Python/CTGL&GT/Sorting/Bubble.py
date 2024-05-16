def bubbleSort(theSeq):
    n = len(theSeq)
    for i in range(n-1):
        for j in range(n-i-1):
            if theSeq[j] > theSeq[j+1]:
                tmp = theSeq[j]
                theSeq[j] = theSeq[j+1]
                theSeq[j+1] = tmp

check = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]
bubbleSort(check)
print(check)    