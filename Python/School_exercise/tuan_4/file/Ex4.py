high = float(input())
weight = int(input())

BMI = weight / (high**2)

print(BMI)

if BMI < 18.5:
    print('Loai 1')
elif BMI <= 22.9:
    print('Loai 2')
elif BMI <= 24.9:
    print('Loai 3')
elif BMI <= 30:
    print('Loai 4')
else:
    print('Loai 5')