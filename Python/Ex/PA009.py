a = int(input("Nhập a:"))
b = int(input("Nhập b:"))
c = int(input("Nhập c:"))

p = (a + b + c)/2

s = (p * (p - a) * (p - b) * (p - c))**(1/2) 

print("Diện tích tam giác là:", s)
