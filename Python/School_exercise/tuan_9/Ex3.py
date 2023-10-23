# Input 
n = int(input())
lst = []
# Ham
def tongDiem(i):
    tongDiem = 0
    mon1,mon2,mon3 = int(input().split())
    tongDiem = mon1 + mon2 + mon3
    lst.append(tongDiem)

# 
for i in range(n):
    tongDiem(i)
print(lst)

