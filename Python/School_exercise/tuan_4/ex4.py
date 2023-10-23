x1,y1,w1,h1 = [int(input()) for x in ['x1','y1','w1','h1']]
x2,y2,w2,h2 = [int(input()) for x in ['x2','y2','w2','h2']]
if x1+w1<x2 or x2+w2<x1 or y1+h1<y2 or y2+h2<y1:
    print('KHONGGIAONHAU')
else:
    print('GIAONHAU')
