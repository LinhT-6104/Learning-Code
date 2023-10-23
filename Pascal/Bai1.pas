uses crt;
Const Max = 10;
Type  Mang= Array[1..Max,1..Max] of longint;
Var A,B:Mang;
    n: longint;
Procedure Nhap;
	var i,j:integer;
	Begin
	    Repeat
	       	Clreol; {xoa dong hien tai, bat dau tu vi tri con tro, den cuoi cua so. con tro khong di chuyen}
           	Write('Ma tran vuong A(N) (N<',') N=');
            Readln(N);
        Until (n>0) and (n<Max);
    			Writeln('Nhap ma tran A');
        		For i:=1 to n do
       			for j:=1 to n do 
            	Begin
                	Gotoxy(j*4,i+2);
                	Readln(A[i,j]);
            	End;
        Writeln;
    end;  	
Procedure Chuyenvi;
	Var i,j,tam: integer;
	Begin
		writeln('Ma tran B la: ');
	   	For i:=1 to N do
		For j:=1 to N do
		    B[i,j]:=A[j,i];	
		for j:=1 to n do 
			begin
				for i:=1 to n do 				
					write(b[i,j]:4);
				writeln;
			end;
	End;
Begin
	clrscr;
	nhap;
	Chuyenvi;
End.


