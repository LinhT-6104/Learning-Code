uses crt;
type mang = array[1..10,1..10] of longint;
var A,B,s:Mang;
	n,m,i,j,x,y,v:longint;

procedure Nhap;
begin
	clreol;
	write('Nhap so cot = '); readln(n);
	write('Nhap so dong = '); readln(m);
	writeln('Moi nhap ma tran A: ');
	for i:=1 to n do
 		begin
			for j:=1 to m do 
			begin
				Gotoxy(j*4,i+3);
				readln(a[i,j]);
			end;
		end;
	writeln;
end;

procedure Doi;
begin
	for i:=1 to m do
	begin
		for j:=1 to n do
		begin
			s[i,j]:= a[i,j];
			if (s[i,j] > 5) then s[i,j]:=1 else s[i,j]:=0;
		end;
	end;
		writeln('Ma tran sau khi doi la: ');
		writeln;
end;

procedure Xuatmatran;
begin
	for j:=1 to m do
	begin
		for i:=1 to n do 
		begin
			write(s[i,j]:4);
		end;
		writeln;
	end;
end;

procedure Xuatsoduong;
begin
	repeat
		clreol;
		write('Nhap x: '); readln(x);
		write('Nhap y: '); readln(y);	
	until (1<=x) and (x<=m) and (1<=y) and (y<=n);
	v:=0;
	for i:=1 to n do 
		begin
			for j:=1 to m do 		
			begin
				if s[i,j] = 1 then inc(v);
			end;
		end;	
	writeln('So duong di ra tu thanh pho x la: ', v); 
	write('So duong di vao thanh pho y la: ',v);
end;

begin
	Nhap; 
	Doi;
	Xuatmatran; readln;
	Xuatsoduong;
end.	