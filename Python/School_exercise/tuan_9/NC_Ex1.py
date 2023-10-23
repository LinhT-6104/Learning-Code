# INPUT
n = int(input())
lst = []

# Nhập vào mức lương của từng nhân viên
for i in range(n):
    lst.append(int(input()))

# Kiểm tra danh sách lương
lstReverse = sorted(lst, reverse = True)
if lstReverse == lst:
    print("SORTED")
else:
    print(lst.index(lstReverse!= lst))
            
