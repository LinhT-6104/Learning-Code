def partitionSeq(theSeq, first, last):   # Thủ tục phân đoạn 
	pivot = theSeq[first]
	left = first + 1
	right = last
	while left <= right:
		while left < right and theSeq[left] < pivot:
			left += 1
		while right >= left and theSeq[right] >= pivot:
			right -= 1
		if left < right:
			tmp = theSeq[left]
			theSeq[left] = theSeq[right]
			theSeq[right] = tmp
	if right != first:
		theSeq[first] = theSeq[right]
	theSeq[right] = pivot
	return right

def quicksort(theSeq):
	n = len(theSeq)
	recQuickSort(theSeq, 0, n-1)
	
def recQuickSort(theSeq, first, last):
	if first >= last:
		return;
	else:
		pivot = theSeq[first]
		pos = partitionSeq(theSeq, first, last)
		recQuickSort(theSeq,first,pos-1)
		recQuickSort(theSeq,pos + 1, last)

sequence = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]

quicksort(sequence)
print(sequence)