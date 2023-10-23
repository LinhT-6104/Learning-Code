// Hàm cơ bản

const logger = log => {
    console.log("Hello");
}
logger("message");

// Ngắn gọn hơn

const sum = (a, b) => a + b; //Không được thêm dấu {} đằng sau "=>", nếu có sẽ phải thêm "return"
                             //Đằng sau "=>" máy sẽ tự động hiểu là return 
console.log(sum(2, 2));

// Áp dụng vào object & return luôn

const a_va_b = (a, b) => ({ a: a, b: b})
console.log(a_va_b(4, 5));

// Áp dụng vào đối số và có duy nhất 1 đối số

const logger = log => console.log(log);

logger("Message...");

// Sử dụng hàm function thông thường

const course = {
    name: "Tran Duc Linh";
    getName: function{
        return this.name;//this là context
    }
} 
console.log(course.getName());

// Không thể sử dụng Arrow function làm constructor

const course = function(name, price){            // Có thể thực hiện
// const course = function(name, price) => {     // không thể thực hiện 
    this.name = name;
    this.price = price;
}

const jsCourse = new course("Tra sua", 25000);

console.log(jsCourse);
