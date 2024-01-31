/*
var a = 0, b = 2, c = 3;
if (a > 0 || b < 9 && c > 9) {
    console.log("true");
}
else {
    console.log("false");
}

var myFunction = function() {
    alert('Xin chao');
}
myFunction();

var a = 1;
var b = 2;
console.log(a == b);


var A = 1;
var B = '1';

var result = 'A' && 'B' && 'C';
console.log('result: ', result); 
*/

/*
function writeLog() {
    var myString = '';
    for (var param of arguments) {
        myString += `${param} - `;
    }
    console.log(myString);
}
*/

/*
writeLog('Log1', 'Log2', 'Log3');

var isConfirm = confirm('Message?');

console.log(isConfirm);
*/

function cong(a, b) {
    return a.toString() + b.toString();
}

function cong(a, b) {
    return a + b;
}

var result = cong(2, 8);

console.log(result);