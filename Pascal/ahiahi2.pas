uses crt;
type Mang=Array[1..10,1..10] of longint;
var A:Mang; vao:text; B: Array[1..100] of longint;
i,j,m,n,t,Max,k,x:longint;
function kt(n:longint):boolean;
var i:longint;
begin
    kt:=true;
    if n<2 then kt:=false else
    for i:=2 to trunc(sqrt(n)) do
    if n mod i=0 then exit(false);
end;
procedure Nhap;
begin
  clrscr;
  assign(vao,'Bangso.txt'); reset(vao);
  readln(vao,m,n);
  for i:=1 to m do
  for j:=1 to n do
    read(vao,A[i,j]);
end;
procedure TimM;
begin Max:=A[1,1];
    for i:=1 to m do
    for j:=1 to n do
    if Max<A[i,j] then Max:=A[i,j];
end;
procedure Sx;
begin
    for i:=1 to m do begin
    for j:=1 to n-1 do
    for k:=j+1 to n do
    if A[i,j]>A[i,k] then
      begin
        t:=A[i,j];
        A[i,j]:=A[i,k];
        A[i,k]:=t;
      end; end;
end;
procedure Xuat;
begin x:=1;
      write('Cac so nguyen to la: ');
      {Đoạn này nhét các số nguyên tố tìm đc trong ma trận A vào mảng B}
      for i:=1 to m do
      for j:=1 to n do
     if kt(A[i,j])=true then begin B[x]:=A[i,j]; inc(x); end;
 {Đoạn này giúp bỏ các số nguyên tố bị trùng lặp
khi tìm trong ma trận, vì dụ 3 3 2 5 5 thì chỉ in ra 3 2 5 thôi }
     for i:=1 to x-1 do
     for j:=i+1 to x do
       if B[i]=9 then else
       if B[i]=B[j] then B[j]:=9;
 {Đoạn này in mảng B chứa các số nguyên tố đã tìm đc, khác nhau}
     for i:=1 to x do if kt(B[i])=true then write(B[i],' ');
      writeln;writeln('Phan tu lon nhat la: ',Max);
     {Đoạn này in mảng đã sắp xếp}
	for i:=1 to m do begin
    for j:=1 to n do write(A[i,j],' ');
    writeln; end; readln;
end;
begin
    Nhap; TimM;
    Sx; Xuat;
end.
