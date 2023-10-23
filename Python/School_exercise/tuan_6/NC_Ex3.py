n = int(input())
m = int(input())
if n <= 100 or m >= 100000:
    print('N/A')
else:
    count = 0
    for i in range(n,m+1):
        if str(i) == str(i)[::-1]:
            count += 1
    print(count)