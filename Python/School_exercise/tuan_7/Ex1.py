toan,van,anh = [float(input()) for x in ['toan','van','anh']]
dtb = (toan + van + anh) / 3
if dtb < 4:
    print('Yeu')
elif dtb < 6:
    print('Trung binh')
elif dtb < 8:
    print('Kha')
elif dtb <= 10:
    print('Gioi')
else:
    print("Loi nhap diem")