uses crt;
type Mang = array[1..100,1..100] of longint;
var m,n,i,j,v: longint;
	A: Mang;
procedure Nhap;
begin
	Fillchar(a,sizeof(A),0);
	writeln('------------NHAP MA TRAN------------');
	write('Nhap so dong: '); readln(m);
	write('Nhap so cot: '); readln(n);
	writeln('Nhap i. Het danh sach thi nhap i = 0');
	repeat
		write('Nhap i: '); readln(i);		
		if i<>0 then
			begin
				Writeln('Tu ',i,' toi j. Nhap j = 0 la het ');
				repeat
	 				begin
		 				write('j = '); 
		 				readln(j);
		 				A[i,j]:=1;
					end; 
				until j=0;
			end;
	until i=0;
	writeln;
end;

procedure Hien(x:Mang;cot,dong:longint);
	var i,j:longint;
begin
	for j:=1 to n do 
	for i:=1 to m do 
		begin
			gotoxy(j*4+cot,i+dong);
			write(x[i,j]:4);
		end;
end;

begin 
	clrscr;
	Nhap;
	Hien(A,40,5);
	readln;
end.