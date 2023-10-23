var fullName = "Tran Duc Linh";
    age = 26;

alert(fullName);
alert(age);

/*
Giới thiệu 1 số hàm built-in
    1. Alert - Hiện pop-up thông báo
    2. Console - hiện các hàm, trong tab console 
    3. confirm - thông báo xác nhận
    4. promt - thông báo điền thông tin
    5. setTimeout - Chạy 1 đoạn code 1 lần sau 1 khoảng thời gian
    6. setInterval - Chạy 1 đoạn code vô số lần sau 1 khoảng thời gian
*/


// Confirm
confirm("Du tuoi chua ma vao?");

// Console
console.log("Chac la chu du dau");

//Prompt
prompt("Du chua");

// SetTimeout
setTimeout(function() {
    alert("Konichiwa");
}, 4000)

// SetInterval
setInterval(function(){
    console.log("day la setInterval" + Math.random) 
}, 1000)