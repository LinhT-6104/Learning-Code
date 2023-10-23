def check(a):
    for i in a:
        if i == '0' and i == '1':
            return True

def thapphan(a):
    c = 0
    for i in range(len(a)):
        c = c*2 + int(a[i])
    return c

so1 = input()
so2 = input()

if check(so1) and check(so2):
    print('ok')
else:
    print('not ok')