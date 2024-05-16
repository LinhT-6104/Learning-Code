def binarySearch(theSeq, target):
    # Bắt đầu xét toàn bộ dãy ban đầu
    low = 0
    high = len(theSeq) - 1

    # Thực hiện lặp quá trình phân chia dãy tại vị trí chính giữa cho đến khi tìm thấy giá trị cần tìm
    while low <= high:
        mid = (low + high)//2   # Tìm điểm chính giữa của dãy.
        if theSeq[mid] == target:   # Kiểm tra điểm chính giữa có chứa giá trị cần tìm ?
            return True
        elif theSeq[mid] < target:  # Kiểm tra giá trị cần tìm có trước phần tử chính giữa hay không?
            low = mid + 1
        elif theSeq[mid] > target:  # Kiểm tra giá trị cần tìm có ở sau phần tử chính giữa hay không?
            high = mid - 1
    return False    # Nếu dãy không thể phân chia nữa, quá trình tìm kiếm đã xong