m = [[1,3,5], [2,4,6], [1,4,7]]
v = m[0][0]
for row in range(0, len(m)):
    for column in range(0, len(m[row])):
        if v < m[row][column]:
            v = m[row][column]
print(v)\
