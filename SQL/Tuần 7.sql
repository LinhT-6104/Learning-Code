-- Họ tên: Nguyễn Hồng Anh
-- Mã SV: 725105008

-- Câu 1: Cho biết tổng số nhân viên của phòng Nghiên cứu
select count(msnv) as "Tổng số nhân viên phòng nghiên cứu"
From NHAN_VIEN as N
	JOIN PHONG AS P ON P.MaPhong = N.MSP
WHERE P.TenPhong = "Nghiên cứu";

-- Câu 2: Cho biết lương lớn nhất, lương nhỏ nhất và trung bình lương của các nhân viên trong phòng Nghiên cứu.
select 
	Max(N.Luong) as "Lương lớn nhất",
	MIn(N.Luong) as "Lương nhỏ nhất",
    AVG(N.Luong) AS "Lương trung bình"
From NHAN_VIEN as N
	JOIN PHONG AS P ON P.MaPhong = N.MSP
WHERE P.TenPhong = "Nghiên cứu";

-- Câu 3: Với mỗi phòng, cho biết mã phòng, tổng số nhân viên và trung bình lương.
SELECT 
	N.MSP as "Mã phòng",
	COUNT(*) as "Tổng số nhân viên",
    AVG(N.Luong) as "Trung bình lương"
FROM NHAN_VIEN as N
GROUP by N.MSP;
	
-- Câu 4: Với mỗi dự án, cho biết mã dự án, tên dự án, tổng số nhân viên tham gia dự án và tổng số giờ công.
SELECT 
	D.MaDA as "Mã dự án",
	D.TenDA as "Tên dự án",
    COUNT(C.MSNV) as "Tổng số nhân viên tham gia",
    sum(C.GioCong) as "Tổng số giờ công"
FROM DU_AN as D
	join CHAM_CONG as C on D.MaDA = C.MSDA
GROUP by C.MSDA
ORder by D.MaDA;

-- Câu 5: Với mỗi dự án có hơn hai nhân viên tham gia, cho biết mã dự án, tên dự án và số nhân viên viên tham gia dự án.
SELECT 
	D.MaDA as "Mã dự án",
	D.TenDA as "Tên dự án",
    COUNT(C.MSNV) as "Tổng số nhân viên tham gia"
FROM DU_AN as D
	join CHAM_CONG as C on D.MaDA = C.MSDA
GROUP by C.MSDA
HAVING COUNT(C.MSNV) > 2;

-- Câu 6: Cho biết tên phòng, tổng số nhân viên của phòng có trung bình lương của nhân viên lớn hơn 3 triệu
SELECT	
	P.TenPhong as "Tên phòng",
    COUNT(*) as "Tổng số nhân viên"
FROM NHAN_VIEN as N
	join PHONG as P On N.MSP = P.MaPhong
GROUP by P.TenPhong
HAVING AVG(N.Luong) > 30000;

-- Câu 7: Với mỗi nhân viên, cho biết mã số nhân viên, họ tên và tổng số người phụ thuộc của nhân viên đó.
SELECT
	N.MSNV as "Mã số nhân viên",
    CONCAT(N.HoDem, " ", N.Ten) as "Họ tên",
    count(P.TenPT) as "Tổng số người phụ thuộc"
from NHAN_VIEN as N
	join PHU_THUOC as P on P.MSNV = N.MSNV
GROUP by N.MSNV

-- Câu 8: Với mỗi nhân viên tham gia hơn 2 dự án, cho biết mã số nhân viên, họ tên, tổng số dự án tham gia, trung bình số 
-- giờ công của dự án của nhân viên đó.
SELECT 
	C.MSNV as "Mã số nhân viên",
    CONCAT(N.HoDem, " ", N.Ten) as "Họ tên",
    COUNT(C.MSDA) as "Tổng số dự án",
    AVG(C.GioCong) as "Trung bình giờ công"
FROM NHAN_VIEN as N
	join CHAM_CONG as C on C.MSNV = N.MSNV
GROUP by C.MSNV
HAVING COUNT(C.MSDA) > 2


