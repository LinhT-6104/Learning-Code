uses crt;
type mang = array[1..10,1..10] of longint;
var A,B,s:Mang;
	c,d,i,j,x,y:longint;

procedure Nhap;
begin
	clreol;
	write('Nhap so cot = '); readln(c);
	write('Nhap so dong = '); readln(d);
	writeln('Moi nhap ma tran A: ');
	for i:=1 to c do 
		begin
			for j:=1 to d do 
			begin
				Gotoxy(j*4,i+3);
				readln(a[i,j]);
			end;
		end;
	writeln;
end;

procedure Doi(a:Mang; i,j:longint);
begin
	for i:=1 to d do
	begin
	for j:=1 to c do
		begin
			s[i,j]:= a[i,j];
			if (s[i,j] > 5) then s[i,j]:=1 else s[i,j]:=0;
		end;
	end;
	writeln('Ma tran sau khi doi la: ');
	writeln;
end;

procedure Xuat;
begin
	for j:=1 to d do
	begin
	for i:=1 to c do 
		begin
			write(s[i,j]:3);
		end;
	writeln;x
	end;
end;

procedure Nhapxy;
begin
	repeat
		write('Moi nhap x: '); readln(x);
		write('Moi nhap y: '); readln(y);
	until (1<=x) and (x<=m) and (1<=y) and (y<=n);
end;

begin
	Nhap; 
	Doi;
	Xuat;
end.