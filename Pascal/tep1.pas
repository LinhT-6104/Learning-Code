Uses Crt;
Const Max = 10;
Type Mang = Array[1..Max,1..Max] of Integer;
	 Luu = Array[1..Max*Max] of Integer;
Var A,B : Mang;
	D,C : Luu;
	N,M : Integer;

Procedure Nhap;
Var i,j : Integer;
Begin
	Writeln('Ma tran A(M,N) (M,N<',Max,') ');
	Repeat
		ClrEol;
		Write('Nhap so dong M = ');
		Readln(M);
	Until (IoResult=0) and (M>0) and (M<Max);
	Repeat
		ClrEol;
		Write('Nhap so cot N = ');
		Readln(N);
	Until (IoResult=0) and (N>0) and (N<Max);
	Writeln('Nhap ma tran A ');
	For i:=1 to M do
		Begin
			For j:=1 to N do
				Begin
					Gotoxy(j*4,i+4);	
					Readln(A[i,j]);
				End;
			Writeln;
		End;
	Writeln;
End;

Procedure Hien(X : Mang;cot,dong : Integer);
Var i,j : Integer;
Begin
	For i:=1 to M do
	For j:=1 to N do
		Begin
			Gotoxy(j*4+cot,i+dong);
			Write(X[i,j]:4);
		End;
End;

Procedure Tim;
Var i,j,k,Ma,Min,Ld,Lc : Integer;
Begin
	Ma := -MaxInt;
	For i:=1 to M do
	For j:=1 to N do
		If Abs(A[i,j]) > Ma then Ma := A[i,j]; {Lưu tất cả các số Max bằng nhau }

	k := 0;
	For i:=1 to M do
	For j:=1 to N do
		If Abs(A[i,j]) = Ma then
			Begin
				Inc(k);
				d[k] := i;
				c[k] := j;
			End;
	Writeln;
	Min := MaxInt;
	For i:=1 to k do
		If d[i]+c[i]<Min then
			Begin
				Min:= d[i]+c[i];
				Ld := i;
				Lc := j;
			End;
	For i:=1 to k do Write('(',d[i],',',c[i],') ');
	Writeln;
	Write('(',Ld,',',Lc,')');
End;

BEGIN
	Clrscr;
	Nhap;
	Clrscr;
	Hien(A,1,4);
	Tim;
	Readln;
end.