def SortedLinearSearch(theSeq, item):
    n = len(theSeq)
    for i in range(n):
        if theSeq[i] == item:
            return True     # Nếu khóa cần tìm xuất hiện tại vị trí thứ i, trả về True
        elif theSeq[i] > item:
            return False    # Nếu khóa cần tìm > phần tử tại vị trí thứ i -> kết luận nó không có trong dãy
    return False    # Khóa cần tìm không có trong dãy