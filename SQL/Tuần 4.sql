-- Mã sinh viên: 725105115
-- Họ và tên: Trần Đức Linh


-- Câu 1: Đưa ra mã nhân viên, họ tên và tên phòng của các nhân viên.
SELECT msnv as "Mã nhân viên",
	   concat(hodem, " ",ten) as "Họ tên",
       tenphong AS "Tên phòng"
from NHAN_VIEN JOIN PHONG ON NHAN_VIEN.MSP = PHONG.MAPHONG

-- Câu 2: Đưa ra mã nhân viên, họ tên, ngày sinh và địa chỉ của các nhân viên làm việc cho phòng ‘Nghiên cứu’
SELECT msnv as "Mã nhân viên",
	   concat(hodem, " ",ten) as "Họ tên",
       ngaysinh as "Ngày sinh",
       diachi AS "Địa chỉ"
from NHAN_VIEN JOIN PHONG ON NHAN_VIEN.MSP = PHONG.MAPHONG
ORDER by tenphong = "Nghiên cứu"

-- Câu 3: Đưa ra mã nhân viên, tên phòng của nhân viên có họ tên là 'Trần Văn Trà'.
SELECT NHAN_VIEN.msnv as "Mã nhân viên", PHONG.tenphong as "Tên phòng"
from NHAN_VIEN 
JOIN PHONG ON NHAN_VIEN.MSP = PHONG.MAPHONG
WHERE CONCAT(NHAN_VIEN.hodem , ' ' , NHAN_VIEN.ten) = "Trần Văn Trà";

-- Câu 4: Với mọi dự án ở Ba Đình, đưa ra tên dự án, mã phòng quản lí dự án đó và họ tên, địa chỉ 
-- của trưởng phòng quản lí dự án đó.
SELECT DU_AN.ten_da as "Tên dự án", 
	   DU_AN.MAPHONGQL as "Mã phòng quản lý", 
       CONCAT(hodem, ' ', ten) as "Họ tên",
       NHAN_VIEN.diachi as "Địa chỉ"
from DU_AN
join NHAN_VIEN on NHAN_VIEN.MSP = DU_AN.MAPHONGQL
JOIN PHONG on PHONG.MAPHONG = NHAN_VIEN.MSP
WHERE PHONG.TENPHONG = "Giám đốc"

-- Câu 5: Đưa ra tên của nhân viên chưa kết hôn (chưa có phụ thuộc).
SELECT NHAN_VIEN.TEN AS "Tên"
from NHAN_VIEN
left join PHU_THUOC on NHAN_VIEN.MSNV = PHU_THUOC.MSNV
where PHU_THUOC.msnv is NULL

-- Câu 6: Đưa ra tên của các nhân viên thuộc phòng 5 tham gia dự án “Sản phẩm A” hơn 10 tiếng.
select NHAN_VIEN.TEN
from NHAN_VIEN
join CHAM_CONG on NHAN_VIEN.MSNV = CHAM_CONG.MSNV
join DU_AN on DU_AN.MaDA = CHAM_CONG.MSDA
where NHAN_VIEN.MSP = 5 and DU_AN.TenDA = "Sản phẩm A" and giocong > 10;

-- Câu 7: Đưa ra tên của các nhân viên có cùng tên với người phụ thuộc của chính nhân viên đó.
select NHAN_VIEN.TEN
from NHAN_VIEN
JOIN PHU_THUOC ON PHU_THUOC.MSNV = NHAN_VIEN.MSNV
WHERE SUBSTRING_INDEX(PHU_THUOC.TEN_PT, ' ', -1) = NHAN_VIEN.TEN

-- Câu 8: Đưa ra mã nhân viên, họ tên của các nhân viên được quản lí trực tiếp bởi nhân viên Lê
-- Mã Lương. 
select NHAN_VIEN.MSNV as "Mã số nhân viên", concat(NHAN_VIEN.HoDem, " ", NHAN_VIEN.Ten) as "Họ tên"
from NHAN_VIEN
where concat(NHAN_VIEN.HoDem, " ", NHAN_VIEN.Ten) != "Lê Mã Lương" AND NHAN_VIEN.MSP = (
  select NHAN_VIEN.MSP
  FROM NHAN_VIEN
  where concat(NHAN_VIEN.HoDem, " ", NHAN_VIEN.Ten) = "Lê Mã Lương"
);

-- Câu 9: Đưa ra mã dự án, tên dự án chưa có nhân viên tham gia.
select DU_AN.MaDA as "Mã dự án",
	   DU_AN.TenDA as "Tên dự án"
from DU_AN
	left join NHAN_VIEN on DU_AN.MaPhongQL = NHAN_VIEN.MSP 
where NHAN_VIEN.MSP is null;

-- Câu 10: Đưa ra tên các nhân viên chưa tham gia dự án nào.
SELECT NHAN_VIEN.Ten 
FROM NHAN_VIEN
left JOIN DU_AN on NHAN_VIEN.MSP = DU_AN.MaPhongQL
WHERE DU_AN.MaPhongQL is null;

-- Câu 11: Đưa ra tên các phòng chưa quản lý dự án nào.
SELECT PHONG.TenPhong
FROM PHONG
left JOIN DU_AN on PHONG.MaPhong = DU_AN.MaPhongQL
WHERE DU_AN.MaPhongQL is null;

-- Câu 12: Đưa ra tên các dự án mà nhân viên Lê Mã Lương đã tham gia.
SELECT DU_AN.TenDA
FROM DU_AN
JOIN NHAN_VIEN ON DU_AN.MaPhongQL = NHAN_VIEN.MSP
WHERE concat(NHAN_VIEN.HoDem, ' ', NHAN_VIEN.Ten) = "Lê Mã Lương" and DU_AN.MaPhongQL = NHAN_VIEN.MSP 

-- Câu 13: Đưa ra tên các nhân viên tham gia dự án ‘Tin học hóa’.
SELECT NHAN_VIEN.Ten
from NHAN_VIEN
	JOIN DU_AN on DU_AN.MaPhongQL = NHAN_VIEN.MSP
where DU_AN.TenDA = "Tin học hóa";

-- Câu 14: Đưa ra tên các các dự án do phòng nghiên cứu quản lý.
select DU_AN.TenDA
from DU_AN
	join PHONG on PHONG.MaPhong = DU_AN.MaPhongQL
where PHONG.TenPhong = "Nghiên cứu";

-- Câu 15: Đưa ra mã nhân viên, họ tên của các nhân viên phòng Nghiên cứu đã tham gia vào dự
-- án sản phẩm A
select NHAN_VIEN.MSNV as "Mã nhân viên",
	   CONCAT(NHAN_VIEN.HoDem, ' ', NHAN_VIEN.Ten) as "Họ tên"
from NHAN_VIEN
	join PHONG on PHONG.MaPhong = NHAN_VIEN.MSP;
	join DU_AN on DU_AN.MaPhongQL = PHONG.MaPhong;    
WHERE PHONG.TenPhong = "Nghiên cứu" and DU_AN.TenDA = "Sản phẩm A";









