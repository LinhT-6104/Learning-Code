

def bieuThucHauTo(s):
    result = Stack(len(s))
    for c in s:
        if c.isdigit():
            result.push(int(c))
        else:
            so1 = result.pop()
            so2 = result.pop()
            if c == '+':
                result.push(so1 + so2)
            elif c == '-':
                result.push(so1 - so2)
            elif c == '*':
                result.push(so1 * so2)
            elif c == '/':
                result.push(so1 / so2)
    return result.pop()

print(bieuThucHauTo("45+12+-3/"))