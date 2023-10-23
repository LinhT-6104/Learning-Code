s = 0 
x = float(input())
n = int(input())
for i in range(1,n+1):
    s += x**i
print(f"{s:.3f}")