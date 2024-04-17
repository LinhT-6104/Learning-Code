-- Bai 1:
use ap_725105115;
DROP PROCEDURE IF EXISTS test;
DELIMITER //
	
CREATE PROCEDURE test()
BEGIN
	DECLARE invoice_count INT;
    
    SELECT COUNT(*)
    INTO invoice_count
    FROM invoices
    WHERE (invoice_total - payment_total - credit_total) >= 5000;
    
    SELECT CONCAT(invoice_count + ' invoices exceed $5,000') as message;
END //
    
DELIMITER ;

CALL test();

-- Bai 2:
use ap_725105115;
DROP PROCEDURE IF EXISTS test;
DELIMITER //

CREATE PROCEDURE test()
BEGIN
	DECLARE balance_due_count INT;
    DECLARE balance_due_sum decimal(9,2);
    
    SELECT COUNT(*), SUM(invoice_total - payment_total - credit_total)
    INTO balance_due_count, balance_due_sum
    FROM invoices i;
    
    IF balance_due_sum >= 30000 THEN
		SELECT balance_due_count, balance_due_sum;
	ELSE
		SELECT 'Total balance due is less than $30,000.' AS message;
	END IF;
END //
	
DELIMITER ;

-- Bai 3:
use ap_725105115;
DROP PROCEDURE IF EXISTS test;

DELIMITER //

CREATE PROCEDURE test()
BEGIN
	DECLARE factorial INT ;
    DECLARE num INT DEFAULT 10;
    DECLARE i INT;
    
    SET factorial = 1;
    SET i = 10;
    
    WHILE i > 0 DO
		SET factorial = factorial * i;
        SET i = i - 1;
	END WHILE;
    
    SELECT CONCAT("The factorial of ", num, " is: ", factorial) as Result;
END //

DELIMITER ;
call test();
-- Bai 4:
use ap_725105115;
DROP PROCEDURE IF EXISTS test;

DELIMITER //

CREATE PROCEDURE test()
BEGIN
	DECLARE done INT DEFAULT FALSE;
    DECLARE vendor_name VARCHAR(255);
    DECLARE invoice_num VARCHAR(255);
    DECLARE balance_due DECIMAL(10, 2);
    DECLARE result VARCHAR(255) DEFAULT '';
    

	DECLARE CUR CURSOR FOR	
		SELECT v.vendor_name, i.invoice_number, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
        FROM vendors v
        JOIN invoices i ON i.vendor_id = v.vendor_id
        WHERE (invoice_total - payment_total - credit_total) >= 5000
        ORDER BY (invoice_total - payment_total - credit_total) DESC;
        
	DECLARE CONTINUE HANDLER FOR NOT FOUND 
		SET done = TRUE;
    
    OPEN CUR;
    
    read_loop : LOOP
		FETCH CUR INTO vendor_name, invoice_num, balance_due;
        IF done THEN
			LEAVE read_loop;
		END IF;
        SET RESULT = concat(result, balance_due, '|', invoice_num, '|', vendor_name, '//');
	END LOOP;
    
    close cur;    
	select RESULT AS MASSAGE;
END //

DELIMITER ;

CALL test();	

-- Bai 5:
use ap_725105115;
DROP PROCEDURE IF EXISTS test;

-- Create the stored procedure
delimiter //
	create procedure test()
    begin
        DECLARE update_count INT DEFAULT 0;
        DECLARE can_update INT DEFAULT TRUE;
		
        DECLARE continue handler for sqlexception
			set can_update = FALSE;
        
        update invoices
        set invoice_due_date = null
        where invoice_id = 1;
        
        set update_count = row_count();
        
        if update_count > 0 and can_update then
			select concat(update_count, ' row was updated,');
		else
			select 'Row was not updated - column cannot be null' as messsage;
		end if;
    end //
delimiter ;

call test();

-- Bai 6:
use ap_725105115;
DROP PROCEDURE IF EXISTS test;

-- Create the stored procedure
	DELIMITER //

	CREATE PROCEDURE test()
	BEGIN
		DECLARE num INT DEFAULT 2;
		DECLARE is_prime BOOLEAN;
		DECLARE prime_numbers VARCHAR(255) DEFAULT '';
		DECLARE divisor INT;
		
		-- Loop through numbers from 2 to 99
		prime_loop: WHILE num < 100 DO
			SET is_prime := TRUE;
			
			-- Check if the number is prime
			SET divisor := 2;
			WHILE divisor <= SQRT(num) DO
				IF num % divisor = 0 THEN
					SET is_prime := FALSE;
				END IF;
				SET divisor := divisor + 1;
			END WHILE;
			
			-- If the number is prime, add it to the prime_numbers string
			IF is_prime THEN
				SET prime_numbers := CONCAT(prime_numbers, num, ', ');
			END IF;
			
			SET num := num + 1;
		END WHILE;
		
		-- Remove the trailing comma and space
		SET prime_numbers := SUBSTRING(prime_numbers, 1, LENGTH(prime_numbers));
		
		-- Display the prime numbers
		SELECT prime_numbers AS Prime_Numbers;
		
	END //

	DELIMITER ;

-- Call the stored procedure
CALL test();

-- Bai 7: 
drop procedure if exists test;

delimiter //
create procedure test()
begin
	declare done INT default false;
    declare vendor_name VARCHAR(255);
    declare invoice_number varchar(255);
    declare balance_due DECIMAL(9,2);
    
    declare result20 varchar(255) default '$20,000 or More: ';
    declare result10 varchar(255) default '$10,000 to $20,000: ';
    declare result5 varchar(255) default '$5,000 to $10,000: ';
	
    declare cur CURSOR for 
		select v.vendor_name, i.invoice_number, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
        from invoices i 
        join vendors v on i.vendor_id = v.vendor_id
        where (i.invoice_total - i.payment_total - i.credit_total) >= 5000
        order by (i.invoice_total - i.payment_total - i.credit_total) desc ;
	
     declare continue handler for not found
		set done = true;
    
    open cur;
		a_loop : loop
			fetch cur into vendor_name, invoice_number, balance_due;
            
			if done then
				leave a_loop;
			end if;
            
			if balance_due >= 20000 then
				set result20 = concat(result20, balance_due, '|', invoice_number, '|', vendor_name, '//');
			elseif balance_due between 10000 and 20000 then
				set result10 = concat(result10, balance_due, '|', invoice_number, '|', vendor_name, '//');
			elseif balnce_due between 5000 and 10000 then
				set result5 = concat(result5, balance_due, '|', invoice_number, '|', vendor_name, '//');
			end if;
		end loop a_loop;
    close cur;
    select concat(result20, result10, result5);
end //
delimiter ;

call test();