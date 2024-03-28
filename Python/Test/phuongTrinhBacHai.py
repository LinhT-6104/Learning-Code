import math

def solve_quadratic(a, b, c):
    # Tính delta
    delta = b**2 - 4*a*c

    # Nếu delta < 0, phương trình không có nghiệm thực
    if delta < 0:
        return "Phương trình không có nghiệm thực."

    # Nếu delta = 0, phương trình có nghiệm kép
    elif delta == 0:
        x = -b / (2*a)
        return f"Phương trình có nghiệm kép: x = {x}"

    # Nếu delta > 0, phương trình có 2 nghiệm phân biệt
    else:
        x1 = (-b + math.sqrt(delta)) / (2*a)
        x2 = (-b - math.sqrt(delta)) / (2*a)
        return f"Phương trình có 2 nghiệm phân biệt: x1 = {x1}, x2 = {x2}"

# Nhập các hệ số từ bàn phím
a = float(input())
b = float(input())
c = float(input())

# Gọi hàm giải phương trình
print(solve_quadratic(a, b, c))

