'''x,y,z = [float(input()) for x in ['x','y','z']]

# Tinh f(x,y)
f = x**2 + x*y + y**2 - 2*x -y
print("{:.2f}".format(round(f,2)))

# Tinh f(x,y,z)
try:
    f = x*y*z + x / (y**z)
    print(f"{f:.2f}")
except ZeroDivisionError:
    print("N/A")'''

x = float(input())
y = float(input())
z = float(input())
def f1(x,y):
    s = x**2 + x*y + y**2 - 2*x -y
    print(f'{s:.2f}')
def f2(x,y,z):
    if y == 0:
        print("N/A")
    else:
        s = x*y*z + x/(y**z)
        print(f'{s:.2f}')
f1(x,y)
f2(x,y,z)