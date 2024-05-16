def mergerOrderedLists(listA, listB):
    newList = list()
    a = 0
    b = 0
    while a < len(listA) and b < len(listB):
        if listA[a] < listB[b]:
            newList.append(listA[a])
            a += 1
        else:
            newList.append(listB[b])
            b += 1
    while a < len(listA):
        newList.append(listA[a])
        a += 1
    while b < len(listB):
        newList.append(listB[b])
        b += 1
    return newList
    

def pythonMergeSort(theList):
    if len(theList) <= 1:
        return theList
    else:
        mid = len(theList) // 2
        leftHalf = pythonMergeSort(theList[:mid])
        rightHalf = pythonMergeSort(theList[mid:])
        newList = mergerOrderedLists(leftHalf, rightHalf)
        return newList

check = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]
sortedList = pythonMergeSort(check)
print(pythonMergeSort(check))