n = int(input())
gia = []
sum = 0
for i in range(n):
    gia.append(int(input()))
    sum += gia[i]
print(max(gia))
print(min(gia))
print(sum)