
/** TRUTHY - to bool is true

    Bất cứ giá trị nào trong Javascript khi chuyển đổi sang kiểu dữ liệu boolean mà có giá
    trị true thì ta gọi giá trị đó là Truthy.

*/
ex1:
console.log(Boolean(1)) // true
console.log(Boolean(['BMW'])) // true
console.log(Boolean({ name: 'Miu' })) // true
console.log(!!'hi') // true

/*

'!!' là gì ?
- Hiểu đơn giản là phủ định của phủ định = khẳng định 
- '!!' >< '!'
=> tip chuyển dữ liệu sang dạng boolean 

*/
ex2:
console.log(!!1) // true
console.log(!!'f8') // true
console.log(!!['Mercedes']) // true

/** Falsy - to bool is false

    Bất cứ giá trị nào trong Javascript khi chuyển đổi sang kiểu dữ liệu boolean mà có giá
    trị false thì ta gọi giá trị đó là Falsy.

 */

/* Có 6 giá trị được gọi là Falsy

/**
 * 1. False
 * 2. 0 ( Số không )
 * 3. '' or "" ( Chuỗi rỗng )
 * 4. null
 * 5. undefined
 * 6. NaN
 */
ex3:
console.log(!! false); // False
console.log(!! ''); // False
console.log(!! 0); // False
console.log(!! NaN); // False

/** NOTE

 * '0' (một chuỗi chứa số không)
 * ' ' (một chuỗi chứa dấu cách)
 * 'false' (một chuỗi chứa từ khóa false)
 * [] (một array trống)
 * {} (một object trống)
 * function(){} (một hàm "trống") 
=> Truthy

 */

/** Ngoại lệ? - document.all

 *  document.all là một ngoại lệ chính thức duy nhất theo đặc tả ECMA (phiên bản 5). Đặc tả
    này mô tả toàn bộ các object khi chuyển sang boolean sẽ là true. Tuy nhiên, document.all
    là một ngoại lệ
 *  Cụ thể như sau:
    - document.all chuyển sang boolean sẽ là false
    - document.all khi là toán hạng của toán tử so sánh == hoặc != sẽ là undefined
    - Khi typeof document.all sẽ trả về "undefined"

 */

