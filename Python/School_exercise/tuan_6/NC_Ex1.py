# Nhap n 
n = int(input())

# Xac dinh so hoan chinh
def shc(a):
    tong = 0
    for j in range (1,a):
        if a % j == 0:
            tong += j
    if tong == a:
        return True
    
# Tim cac so hoan chinh trong khoang n
if n <= 1 or n >= 100000:
    print("N/A")
else: 
    b = []
    for i in range(1,n+1):
        shc(i)
        if shc(i) == True:
            b.append(i)
    b.sort()
    for i in range(len(b)):
        print(b[i],end=" ")
    # print(b) 


