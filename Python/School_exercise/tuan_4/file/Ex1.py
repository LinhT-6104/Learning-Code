import math
a,b,c = int(input()),int(input()),int(input())
if a>0 and b>0 and c>0 and a+b>c and b+c>a and c+a>b:
    print("a,b,c la 3 canh cua tam giac")
    s = (a+b+c)/2
    Area = math.sqrt(s*(s-a)*(s-b)*(s-c))
    print(f"{Area:.2f}")
else:
    print("a,b,c khong la 3 canh cua tam giac")
