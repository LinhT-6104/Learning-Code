n = int(input())
s = 0
a = 1
for i in range(1,n+1):
    a *= i
    s += 1/a
print(f"{s:.5f}")