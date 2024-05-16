def SelectionSort(theSeq):
    n = len(theSeq)
    for i in range(n-1):
        smallNdx = i
        for j in range(i+1, n):
            if theSeq[smallNdx] > theSeq[j]:
                smallNdx = j
        if smallNdx != i:
            temp = theSeq[i]
            theSeq[i] = theSeq[smallNdx] 
            theSeq[smallNdx] = temp

check = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]
SelectionSort(check)
print(check)