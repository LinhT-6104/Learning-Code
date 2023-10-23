
my_tuple = (4, 2, 3, 6, 4, 5, 6)

# Trả về vị trí xuất hiện đầu tiên của số 4
print(my_tuple.index(4)) # return 0

# Trả về vị trí xuất hiện đầu tiên của số 4 bắt đầu từ vị trí số 3
print(my_tuple.index(4, 3)) #return 4

# Trả về vị trí xuất hiện đầu tiên của số 4 trong khoảng 2;5
print(my_tuple.index(4, 2, 5)) 
# return 4
