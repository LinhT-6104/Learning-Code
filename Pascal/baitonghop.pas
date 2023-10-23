uses crt;
var A:array [1..10,1..10] of longint;
	B: Array[1..100] of longint; 
	i,j,m,n,t,Max,k,x:longint;
	vao:text;
{----------------------------------Nhap----------------------------------}

procedure Nhap;
begin
	clrscr;
	assign(vao,'bangso.txt'); reset(vao);
	readln(vao,m,n);
	for i:=1 to m do 
	for j:=1 to n do 
	read(vao,A[i,j]);
	close(vao);
end;

{----------------------------------Câu a----------------------------------}

function kt(n:longint):Boolean;
var i:longint;
begin
	kt:=true;
	if n<2 then kt:=false else
	for i:=2 to trunc(sqrt(n)) do 
	if n mod i=0 then exit(false);
end;


{----------------------------------Câu b----------------------------------}

procedure TimM;
begin 
	Max:=A[1,1];
	for i:=1 to m do 
	for j:=1 to n do 
	if max<a[i,j] then max:=A[i,j];
end;

{----------------------------------Câu c----------------------------------}
								   	
procedure Sx;
begin
	for i:=1 to m do 
	begin 
		for j:=1 to n-1 do 
		for k:=j+1 to n do 
		if A[i,j]>A[i,k] then 
			begin
				t:=A[i,j];
				A[i,j]:=A[i,k];
				A[i,k]:=t;
			end;
	end;
end;

{----------------------------------- Xuat --------------------------------}

procedure xuat;
begin
	x:=1;
	write('Cac so nguyen to la: ');
	for i:=1 to m do 
	for j:=1 to n do 
	if kt(A[i,j])=true then 
		begin
			b[x]:=a[i,j];
			inc(x);
		end;
	for i:=1 to x-1 do 
	for j:=i+1 to x do 
		if B[i] = 9 then else
		if B[i] = B[j] then B[j]:=9;
	for i:=1 to x do 
	if kt(B[i])=true then write(B[i],' ');
	writeln;
	writeln('Phan tu lon nhat: ',Max);
	for i:=1 to m do 
	begin
		for j:=1 to n do write(A[i,j],' ');
		writeln;
end;
end;


{----------------------------------- In ----------------------------------}

begin
	Nhap;
	TimM;
	Sx;
	Xuat;	
end.




