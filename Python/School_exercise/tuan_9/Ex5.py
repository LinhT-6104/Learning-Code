slcb = int(input())
sl = 0
for i in range(slcb):
    height = float(input())
    weight = float(input())
    BMI = weight / (height ** 2)
    if BMI >= 30:
        sl += 1
print(sl)
