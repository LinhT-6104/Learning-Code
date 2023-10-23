n = int(input())
tienhb = 0
for i in range(n):
    dhb = float(input())
    if 7 <= dhb < 8:
        tienhb += 1200000
    elif 8 <= dhb < 9:
        tienhb += 1400000
    elif 9 <= dhb <= 10:
        tienhb += 1800000
print(tienhb)