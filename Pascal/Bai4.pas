uses crt;
type Mang1= array [1..100,1..100] of real;
	 Mang2= array [1..100] of real;
var m,n,i,j,x,s: longint;
	Max: real;
	A: Mang1;
	H,C: Mang2

{----------------------- Nhap -----------------------}

procedure Nhap;
begin
	clreol;
	write('Nhap so cot: '); readln(m);
	write('Nhap so hang: '); readln(n);
	writeln('MOI NHAP MA TRAN');
	for i:=1 to n do
	for j:=1 to m do 
		begin
			Gotoxy(j*7,i+3);
			readln(a[i,j]);
		end;
	writeln;
end;

{----------------------- Tim_max -----------------------}

procedure Tim_max;
begin
	Max:=abs(a[1,1]);
	for i:=1 to m do 
		begin
			for j:=1 to m do 
			if max<abs(a[i,j]) then max:=abs(a[i,j]);
			writeln;
		end;
end;

{---------------------- Tinh_Hang ----------------------}

function Tinh_hang(H:Mang2): real;
	var i,j,x,s:longint;
begin
	x:=0; s:=0;
	for i:=1 to m do 
	begin 
		for j:=1 to n do
		begin
		 	s:=s+a[i,j];
		end;
		inc(x);
		h[x]:=s;
		writeln;
	end;
end;

{----------------------- Tinh_Cot ----------------------}

function Tinh_cot(c:Mang2):real;
	var i,j,y,s:longint;
begin
	y:=0; s:=0;
	for j:=1 to n do 
	begin 
		for i:=1 to m do
		begin
		 	s:=s+a[j,i];
		end;
		inc(y);
		c[y]:=s;
		writeln;		
	end;
end;

{--------------------- Loa --------------------}

procedure Bo_X(var h,c:Mang2);
	var 
begin
	
end;


begin
	Nhap;
	Tim_max; write('Phan tu lon nhat Mang a la: ',max:0:2 );
end.



