a,b,c,d = [int(input()) for x in ['a','b','c','d']]
bc = 1
while ( bc % a != 0 ) or ( bc % b != 0 ) or ( bc % c != 0 ) or ( bc % d!= 0 ):
    bc += 1
print(bc)