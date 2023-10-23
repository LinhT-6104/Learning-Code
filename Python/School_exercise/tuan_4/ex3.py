# nhap so phut goi
m = int(input())

# Tinh tien
tien = 150000
if m <= 50:
    tien += 600*m
elif m <= 200:
    tien += 600*50 + 400*(m-50)
else:
    tien += 600*50 + 400*150 + 200*(m - 200)
print(tien)