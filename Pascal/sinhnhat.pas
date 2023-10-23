program HoangXuanDieu;
uses
crt;
var
captcha, inputcaptcha, i, n, giay: Integer;
begin
clrscr;
Randomize();
captcha := Random(8999) + 1000;
begin
textBackground(white);
textColor(blue)
gotoXY(20, 0);
writeln(captcha);
end;
writeln();
textBackground(black);
textColor(white);
Write('Xác minh bạn không phải là người máy: ');
Read(inputcaptcha);
textColor(red);
if inputcaptcha <> captcha then
writeln('Nhập sai, chạy lại chương trình đi chú dô bốt!')
else
begin
textcolor(LightCyan);
clrscr;
writeln('Đang chuyển hướng.');
delay(500);
clrscr;
writeln('Đang chuyển hướng..');
delay(500);
clrscr;
writeln('Đang chuyển hướng...');
delay(500);
clrscr;
writeln('Đang chuyển hướng..');
delay(500);
clrscr;
writeln('Đang chuyển hướng...');
delay(500);
begin
clrscr;
n := 5;
giay := 6;
for i := 0 to n do
begin
clrscr;
giay := giay - 1;
textColor(green);
writeln('Nội dung sẽ hiển thị sau ', giay, ' giây nữa!');
delay(1000);
end;
begin
clrscr();
gotoXY(20, 10);
textColor(red);
write('I LOVE Diệu ♡');
end;
end;
end;
readln;
end.