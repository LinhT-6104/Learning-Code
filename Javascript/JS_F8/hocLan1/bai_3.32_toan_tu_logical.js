/**
 * Toán tử logical
 *  1. && - and
 *  2. || - or
 *  3. ! - not
 */

// Ex1

var a = 1;
var b = 2;
var c = 3;

if(a > 0 && b > 1){
    console.log("Hello");
}

// Ex2
var a = true;
var b = false;
var c = a || b;
var d = b && c;

console.log(c, d); // Output: ?

// -> Output(true, false)

// Ex3
var a = 1;
if (!(a = 1)) {
    console.log('chuan');
}
