n = int(input())
lst = []

def shc(a):
    sum = 0
    for i in range(1,a):
        if a % i == 0:
            sum += i
    if sum == a:
        return True

if n<=1 or n >=100000:
    print("N/A")
else:
    for i in range(1,n+1):
        shc(i)
        if shc(i) == True:
            lst.append(i)
    lst.sort()
    for i in range (len(lst)):
        print(lst[i],end = " ")
