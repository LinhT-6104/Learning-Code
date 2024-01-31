/*
Kiểu dữ liệu trong Javascript

1. Dữ liệu nguyên thủy - Primitive Data
    - Number
    - String
    - Boolean
    - Undefined
    - Null
    - Symbol

2. Dữ liệu phức tạp - Complex Data
    - Function
    - Object
*/  


// Number
var a = 1;
var b = 2.5;

// String
var fullName = 'Duc Linh';
var fullName2 = 'Duc \'Linh\''; // Hiện dấu nháy đơn
/* or */ var fullName3 = 'Duc \"Linh';// Hiệu dấu nháy kép

// Boolean type
var isSuccess = true;

// Undefined type
var age;

// Null
var isNull = null; // Nothing

// Symbol
var id = Symbol('id'); //unique
var id2 = Symbol('id'); //unique

// Function
var myFunction = function() {
    console.log('Hello'); 
}
myFunction();

// Object type

var myObject = {  // Có thể có " " hoặc không " "
    ten = 'Duc Linh',
    "age" = 19,
    myFunction = function () {
    }
};                             
console.log('myObject', myObject)

var myArray = [
    'Python',
    'Javascript',
    'C++'
];


// Kiểm tra type 
var a = 'H'; // String
var b = true; // Boolean
var c = 3; // Number
var d; // Undefined
var e = null; //Object????
var f = symbol('id'); // Symbol
var g = function() {
}
var h = {
    ten : 'Duc Linh',
    tuoi : 18,
    que_quan : 'Ha Noi',
    hFunction : function () {

    }
};
var i = [
    'duc linh',
    18
]
