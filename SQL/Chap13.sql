-- Bai 1:
use AP;

drop PROCEDURE if exists test;

DELIMITER //

CREATE PROCEDURE test()
BEGIN
    -- Khai báo biến để lưu trữ số lượng hóa đơn có số dư lớn hơn hoặc bằng $5,000
    DECLARE invoice_count INT;
    
    -- Gán số lượng hóa đơn cần tìm vào biến
    SELECT COUNT(*)
    INTO invoice_count
    FROM Invoices
    WHERE balance_due >= 5000;
    
    -- Hiển thị kết quả
    SELECT CONCAT(invoice_count, ' invoices exceed $5,000.') AS message;
END //

DELIMITER ;

CALL test();

-- Bai 2:

DELIMITER //

CREATE PROCEDURE test()
BEGIN
    -- Khai báo biến để lưu trữ số lượng hóa đơn có số dư
    DECLARE invoice_count INT;
    -- Khai báo biến để lưu trữ tổng số dư của tất cả các hóa đơn
    DECLARE total_balance_due DECIMAL(10, 2);
    
    -- Gán số lượng hóa đơn có số dư và tổng số dư vào biến tương ứng
    SELECT COUNT(*), SUM(balance_due)
    INTO invoice_count, total_balance_due
    FROM Invoices
    WHERE balance_due IS NOT NULL;
    
    -- Nếu tổng số dư lớn hơn hoặc bằng $30,000, hiển thị kết quả
    IF total_balance_due >= 30000 THEN
        SELECT invoice_count, total_balance_due;
    ELSE
        -- Nếu không, hiển thị tin nhắn thích hợp
        SELECT 'Total balance due is less than $30,000.' AS message;
    END IF;
END //

DELIMITER ;

CALL test();

-- Bai 3:
DELIMITER //

CREATE PROCEDURE test()
BEGIN
    -- Declare variables
    DECLARE num INT;
    DECLARE factorial BIGINT;
    DECLARE i INT;

    -- Initialize variables
    SET num = 10;
    SET factorial = 1;

    -- Calculate factorial
    SET i = 1;
    WHILE i <= num DO
        SET factorial = factorial * i;
        SET i = i + 1;
    END WHILE;

    -- Display the result
    SELECT CONCAT('The factorial of ', num, ' is ', factorial) AS result;
END //

DELIMITER ;

CALL test();

-- Bai 4:
DELIMITER //

CREATE PROCEDURE test()
BEGIN
    -- Declare variables
    DECLARE num INT;
    DECLARE factorial BIGINT;
    DECLARE i INT;

    -- Initialize variables
    SET num = 10;
    SET factorial = 1;

    -- Calculate factorial
    SET i = 1;
    WHILE i <= num DO
        SET factorial = factorial * i;
        SET i = i + 1;
    END WHILE;

    -- Display the result
    SELECT CONCAT('The factorial of ', num, ' is ', factorial) AS result;
END //

DELIMITER ;

CALL test();

-- Bai 5:
DELIMITER //

CREATE PROCEDURE test()
BEGIN
    -- Declare variable
    DECLARE update_count INT;

    -- Attempt to update the invoice_due_date column
    UPDATE Invoices
    SET invoice_due_date = NULL
    WHERE invoice_id = 1;

    -- Get the number of rows affected by the update
    SET update_count = ROW_COUNT();

    -- Check if the update was successful
    IF update_count > 0 THEN
        SELECT CONCAT(update_count, ' row was updated.') AS result;
    ELSE
        SELECT 'Row was not updated - column cannot be null' AS result;
    END IF;
END //

DELIMITER ;

call test();

-- Bai 6:
DELIMITER //

CREATE PROCEDURE test()
BEGIN
    -- Declare variables
    DECLARE num INT;
    DECLARE divisor INT;
    DECLARE is_prime BOOLEAN;
    DECLARE primes_string VARCHAR(1000);
    
    -- Initialize primes_string
    SET primes_string = '';
    
    -- Loop through numbers from 2 to 99
    SET num = 2;
    WHILE num < 100 DO
        SET is_prime = TRUE;
        SET divisor = 2;
        
        -- Check if num is prime
        WHILE divisor < num DO
            IF num % divisor = 0 THEN
                SET is_prime = FALSE;
                LEAVE WHILE;
            END IF;
            SET divisor = divisor + 1;
        END WHILE;
        
        -- If num is prime, add it to primes_string
        IF is_prime THEN
            SET primes_string = CONCAT(primes_string, num, ' | ');
        END IF;
        
        SET num = num + 1;
    END WHILE;
    
    -- Display the prime numbers
    SELECT primes_string AS prime_numbers;
END //

DELIMITER ;

call test();

-- Bai 7:
DELIMITER //

CREATE PROCEDURE test()
BEGIN
    -- Declare variables
    DECLARE balance_due DECIMAL(10, 2);
    DECLARE vendor_name VARCHAR(255);
    DECLARE invoice_data VARCHAR(1000);
    
    -- Declare cursor for invoices
    DECLARE cur_invoices CURSOR FOR
        SELECT balance_due, vendor_name
        FROM invoices;
        
    -- Initialize invoice_data
    SET invoice_data = '';
    
    -- Loop through each group
    -- $20,000 or More
    OPEN cur_invoices;
    FETCH cur_invoices INTO balance_due, vendor_name;
    SET invoice_data = CONCAT('$20,000 or More: ');
    WHILE balance_due >= 20000 DO
        SET invoice_data = CONCAT(invoice_data, balance_due, vendor_name, '//');
        FETCH cur_invoices INTO balance_due, vendor_name;
    END WHILE;
    CLOSE cur_invoices;
    
    -- $10,000 to $20,000
    OPEN cur_invoices;
    FETCH cur_invoices INTO balance_due, vendor_name;
    SET invoice_data = CONCAT(invoice_data, '$10,000 to $20,000: ');
    WHILE balance_due >= 10000 AND balance_due < 20000 DO
        SET invoice_data = CONCAT(invoice_data, balance_due, vendor_name, '//');
        FETCH cur_invoices INTO balance_due, vendor_name;
    END WHILE;
    CLOSE cur_invoices;
    
    -- $5,000 to $10,000
    OPEN cur_invoices;
    FETCH cur_invoices INTO balance_due, vendor_name;
    SET invoice_data = CONCAT(invoice_data, '$5,000 to $10,000: ');
    WHILE balance_due >= 5000 AND balance_due < 10000 DO
        SET invoice_data = CONCAT(invoice_data, balance_due, vendor_name, '//');
        FETCH cur_invoices INTO balance_due, vendor_name;
    END WHILE;
    CLOSE cur_invoices;
    
    -- Display the invoice data
    SELECT invoice_data AS invoice_data;
    
END //

DELIMITER ;