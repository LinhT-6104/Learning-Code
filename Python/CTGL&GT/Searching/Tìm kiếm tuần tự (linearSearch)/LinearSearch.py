def linearSearch(theSeq, target):
    n = len(theSeq)
    for i in range(n):
        # Nếu khóa tìm kiếm bằng vói phần tử thứ i, trả về True
        if theSeq[i] == target:
            return True
    return False    # Nếu không tìm được, trả về False