import array
# Cài đặt trộn hai dãy con ảo đã sắp xếp (được đánh dấu trên chính dãy ban đầu)

# Trộn hai dãy con ảo đã sắp xếp: [left...right) [right...end)
# Sử dụng biến tmpArrray để lưu trữ tạm
def mergeVirtualSeq(theSeq, left, right, end, tmpArray):
    # Khởi tạo hai biến chỉ số bắt đầu của hai dãy con cần trộn
    a = left
    b = right
    # Khởi tạo một biến chỉ số cho mảng kết quả chứa danh sách sau trộn
    m = 0
    # Trộn hai dãy cùng nhau cho đến khi một dãy rỗng.
    while a < right and b < end:
        if theSeq[a] < theSeq[b]:
            tmpArray[m] = theSeq[a]
            a += 1
        else:
            tmpArray[m] = theSeq[b]
            b += 1
        m += 1
    # Nếu dãy bên trái vẫn còn phần tử, bổ sung vào cuối mảng tạm 
    while a < right:
        tmpArray[m] = theSeq[a]
        a += 1
        m += 1
    # Nếu dãy bên phải vẫn còn phần tử, bổ sung vào cuối mảng tạm 
    while b < end:
        tmpArray[m] = theSeq[b]
        b += 1
        m += 1
    # Sao chép dãy con đã sắp xếp trở lại cấu trúc dãy ban đầu
    for i in range(end - left):
        theSeq[i+left] = tmpArray[i]


# Cài đặt thuật toán sắp xếp trộn cải tiến
# Sắp xếp dãy con ảo theo thứ tự tăng dần sử dụng thuật toán sắp xếp trộn
def recMergeSort(theSeq, first, last, tmpArray):
    # Kiểm tra trường hợp cơ sở: Dãy ảo chỉ có chứa đúng một phần tử.
    if first == last:
        return;
    else:
        mid = (first + last) // 2   # Tính chỉ số chính giữa

        # Phân tách dãy và thực hiện đệ quy
        recMergeSort(theSeq, first, mid, tmpArray)
        recMergeSort(theSeq, mid+1, last, tmpArray)

        # Trộn hai dãy con đã sắp xếp.
        mergeVirtualSeq(theSeq, first, mid + 1, last + 1, tmpArray)


# Hàm khởi tạo mảng tạm và gọi đến thủ tục sắp xếp trộn

# Sắp xếp một mảng hoặc danh sách theo thứ tự tăng dần sử dụng thuật toán sắp xếp trộn
def mergeSort(theSeq):
    n = len(theSeq)
    # Tạo một mảng tạm để sử dụng khi trộn dãy con.
    tmpArray = array.array('i', [0]*n) # Tạo một mảng integer với độ dài n và khởi tạo tất cả giá trị là 0, i' được sử dụng để chỉ ra rằng mảng sẽ chứa các số nguyên có kích thước 4 byte.
    # Gọi thủ tục đệ quy lần đầu cho toàn bộ dãy cần sắp xếp
    recMergeSort(theSeq, 0, n-1, tmpArray)

# Khởi tạo một dãy số ngẫu nhiên
sequence = [8, 3, 1, 7, 0, 10, 2, 5, 4, 9, 6]

# In ra dãy số trước khi sắp xếp
print("Dãy số trước khi sắp xếp:", sequence)

# Sắp xếp dãy số bằng thuật toán merge sort
mergeSort(sequence)

# In ra dãy số sau khi sắp xếp
print("Dãy số sau khi sắp xếp:", sequence)