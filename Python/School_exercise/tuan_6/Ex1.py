x = float(input())

# Tinh fx
import math
if -1 <= x <= 1:
    fx = -2*(x-3)
elif x > 1:
    fx = math.sqrt(x**2 - 1)

# Tinh gx
if x > 2:
    gx = x**2 + 1
elif -2 <= x <= 2:
    gx = 2*x - 1
else:
    gx = 6 - 5*x
    
# In kq
print(f"{fx:.2f}")
print(f"{gx:.2f}")