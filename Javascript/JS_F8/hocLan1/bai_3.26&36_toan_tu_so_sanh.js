/*  Toán tử so sánh

Toán tử 
==          -->     Bằng ( Value )
===         -->     Bằng tuyệt đối ( value & data type)
!=          -->     Không bằng ( Value )
!==         -->     Không bằng ( value & data type)
>           -->     Lớn hơn
<           -->     Nhỏ hơn
>=          -->     Lớn hơn hoặc bằng
<=          -->     Nhỏ hơn hoặc bằng

*/

// Ví dụ 1:

var a = "Tran duc Linh";
var b = "Tran Duc Linh";

if (a == b){
    console.log("Dieu kien dung");
} else {
    console.log("Dieu kien sai");
}

// Ví dụ 2:

var a = 1;
var b = '1';
console.log(a != b); // False
console.log(a !== b ); // True

