m,n = map(float, input('Nhập m x n: ').split())

s = m * n
 
tong = 1 * ((1 - (2**s)) / (1 - 2))

print("Số hạt lúa mì trên bàn cờ",int(m),"x",int(n),"là:",int(tong))