Program Ma_Tran_Chuyen_Vi;
Uses Crt;
Type MT = array[1..20,1..20] of integer; 
Var a,b:MT;
	n,m:integer;
Procedure Input(Var a:MT; n,m:integer); 
	Var i, j:integer;
	Begin
		For i:=1 to n do
		For j:=1 to m do
			Begin
				Write('a',i,j,'='); Readln(a[i,j]);
			End;
	End;
Procedure Output(a:MT;n,m:integer); Var i,j:integer;
	Begin
		For i:=1 to n do
			Begin
				For j:=1 to m do
					write(a[i,j],' ');
			End;
			writeln;
	End;
Procedure Chuyenvi(a:MT;n,m:integer; var b:MT); Var i,j:integer;
	Begin
		For j:=1 to m do
		For i:=1 to n do
			b[j,i]:=a[i,j];
	End;
Begin
Clrscr;
Writeln('TIM MA TRAN CHUYEN VI');
Write('Nhap vao so dong n = ');readln(n); 
Write('Nhap vao so cot m = ');readln(m); Input(a,n,m);
Writeln('Ma tran a la: '); Output(a,n,m); Chuyenvi(a,n,m,b);
Writeln('Ma tran chuyen vi b la: '); Output(b,m,n);
Readln;
End.