n = int(input())
dtt = float(input())

lst = []
for i in range(n):
    lst.append(int(input()))
for i in lst:
    if i >= dtt:
        print(f"{i:.2f}",end =" ")
