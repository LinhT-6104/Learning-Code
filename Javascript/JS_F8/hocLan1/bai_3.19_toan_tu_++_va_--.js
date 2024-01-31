/* Toán tử ++
- Toán tử ++ giúp tăng giá trị của một biến mang giá trị số lên 1. 
    Có 2 cách để sử dụng toán tử ++ là:
    Dùng làm hậu tố: variable++ (toán tử nằm sau biến)
    Dùng làm tiền tố: ++variable (toán tử nằm trước biến)

# variable++ (thường dùng)
    + Sau mỗi khi sử dụng toán tử ++, giá trị của biến number được tăng lên 1.
    + Tuy nhiên:
        var number = 1;

        console.log(number++); // 1
        console.log(number); // 2

        console.log(number++); // 2
        console.log(number); // 3

    👉 Toán tử ++ khi dùng là hậu tố sẽ tăng giá trị của biến lên 1 và trả về giá trị trước khi
    tăng.

# ++variable
    var number = 1;

    ++number; // dùng làm tiền tố, ++ ở phía trước biến
    console.log(number); // 2

    console.log(++number); // 3
    console.log(number); // 3

    👉 Toán tử ++ khi dùng là tiền tố sẽ tăng giá trị của biến lên 1 và trả về giá trị sau khi 
    tăng.

/*    Toán tử --
    👉 Hoạt động tương tự toán tử ++, điểm khác biệt là thay vì cộng thêm 1, thì toán tử -- sẽ 
    trừ đi 1

                                            TỔNG KẾT
                    x++ tăng giá trị biến lên 1 và trả về giá trị trước khi tăng
                    ++x tăng giá trị biến lên 1 và trả về giá trị sau khi tăng
                    x-- giảm giá trị biến xuống 1 và trả về giá trị trước khi giảm
                    --x giảm giá trị biến xuống 1 và trả về giá trị sau khi giảm

*/