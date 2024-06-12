'''
    s(n) = n/2 * (u1 + un)
    s(n) = n/2 * (2*u1 + (n-1) * d)
    u1 = s/n - (n-1) * d/2
'''
def check(s, n, d):
    result = s/n - (n-1) * d/2
    if (result * 10) % 10 == 0:
        print(result)
    else:
        print(-1)

check(8, 2, 1)
    