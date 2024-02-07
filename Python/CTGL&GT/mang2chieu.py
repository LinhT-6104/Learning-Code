class Array2D:
    # Tạo mảng 2-D có kích thước numRows x numCols.
    def __init__(self, numRows, numCols):
        # Tạo mảng 1-D để lưu trữ Con trỏ mảng cho mỗi hàng.
        self._theRows = [None] * numRows

        # Tạo mảng 1-D cho mỗi hàng của mảng 2-D
        for i in range(numRows):
            self._theRows[i] = [None] * numCols

    # Trả về số hàng trong mảng 2-D
    def numRows(self):
        return len(self._theRows)
    
    # Trả về số cột trong mảng 2-D
    def numCols(self):
        return len(self._theRows[0])
    
    # Nhận nội dung của phần tử tại vị trí [i, j]
    def __getitem__(self, index):
        i, j = index
        the1dArray = self._theRows[i]
        return the1dArray[j]

    # Đặt nội dung của phần tử tại vị trí [i, j] thành giá trị.
    def __setitem__(self, index, value):
        i, j = index
        the1dArray = self._theRows[i]
        the1dArray[j] = value
        # Cách 2: self._theRows[i][j] = value


# Tạo một mảng 2-D với 3 hàng và 4 cột
arr = Array2D(3, 4)

# In ra số hàng và số cột của mảng 2-D
print("Number of rows:", arr.numRows())  # In ra: 3
print("Number of columns:", arr.numCols())  # In ra: 4

# Gán và lấy giá trị của một phần tử trong mảng 2-D
arr[1, 2] = 5
print("Value at [1, 2]:", arr[1, 2])  # In ra: 5
