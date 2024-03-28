def deQuy(n):
    if n == 0:
        return 1
    else:
        return (2*n+1) * deQuy(n-1)

n = 2
print(deQuy(2))s