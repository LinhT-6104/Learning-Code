a,b,c,d,e = [int(input(f"{x} = ")) for x in ["a","b","c","d","e"]]
lst = [a,b,c,d,e]
i = 2
for i in range(1,max(lst)):
    if all(num % i == 0 for num in [a,b,c,d,e]):
        check = i
print(check)