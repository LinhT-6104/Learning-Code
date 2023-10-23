# Input
n = int(input())
n_bd = n

# Nhị phân
np = []
while n > 0:
    a = n % 2
    np.append(str(a))
    n = n // 2
np.reverse()
print(''.join(np))

# Bát phân
n = n_bd
bp = []
while n > 0:
    a = n % 8
    bp.append(str(a))
    n = n // 8
bp.reverse()
print(''.join(bp))

# Thập lục phân
n = n_bd
print(hex(n)[2:].upper())