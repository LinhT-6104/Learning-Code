n = int(input())

# Hinh 1
for i in range(0, n):
    print(' ' * (n-i) + '*' * (2*i+1) )
print()

# Hinh 2
for i in range(n):
    print('*' * 5)
print()

# Hinh 3
for i in range(n):
    print('*' * (2*i + 1))
for i in range(n-1, 0, -1):
    print('*' * (2*i +1)