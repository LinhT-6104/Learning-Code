n = int(input())

# tinh sa
sa = 0
for i in range(1,n+1):
    sa += i**2
print(f'{sa:.3f}')

# tinh sb
sb = 1 
for i in range(1,n+1):
    sb += 1 / (i*(i+1))
print(f'{sb:.3f}')