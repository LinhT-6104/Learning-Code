a = input()
cnt = a.count(',')
if cnt == 0:
    print(a.replace('.',','))
else:
    print(a.replace('.',',').replace(',','.',cnt))

