-- Bai 1
use ap_725105115;

drop procedure if exists insert_glaccount;

delimiter //

create procedure insert_glaccount (
	account_number_param int,
    account_description_param varchar(255)
)
begin
	insert into general_ledger_accounts 
	values (account_number_param, account_description_param);
end //

delimiter ;

call insert_glaccount(6, 'NgaySinh');

-- select * from general_ledger_accounts
-- where account_number = 6;

--  delete from general_ledger_accounts
-- where account_number = 6

-- Bai 2:
use ap_725105115;
drop function if exists test_glaccounts_description;

DELIMITER //

CREATE FUNCTION test_glaccounts_description(account_desc VARCHAR(255))
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE account_count INT;
    
    -- Check if the account description exists in the General_Ledger_Accounts table
    SELECT COUNT(*) INTO account_count
    FROM general_ledger_accounts
    WHERE account_description = account_desc;
    
    -- Return 1 if the account description exists, 	0 otherwise
    RETURN IF(account_count > 0, 1, 0);
END //

DELIMITER ;

-- Call the stored function to test it
SELECT test_glaccounts_description('Accounting');

-- Bai 3:
use ap_725105115;
drop procedure if exists insert_glaccount_with_test;

-- Create the stored procedure
DELIMITER //

CREATE PROCEDURE insert_glaccount_with_test(
    IN test_description VARCHAR(255),
    IN test_number INT
)
BEGIN
    DECLARE account_exists INT default 0;

    -- Check if the account description already exists
    SET account_exists = test_glaccounts_description(test_description);

    -- If the account exists, raise an error
    IF account_exists = 1 THEN
        SIGNAL SQLSTATE '23000'
            SET MESSAGE_TEXT = 'Duplicate account description.', MYSQL_ERRNO = 1062;
    ELSE
        -- Insert the new account into the General_Ledger_Accounts table
        INSERT INTO general_ledger_accounts (account_description, account_number) 
        VALUES (test_description, test_number);
    END IF;
END//

DELIMITER ;

CALL insert_glaccount_with_test('Accounting Fees', 1001);

-- Bai 4:
use ap_725105115;
drop procedure if exists insert_terms;

-- Create the stored procedure
DELIMITER //

CREATE PROCEDURE insert_terms(
    IN test_terms_due_days INT,
    IN test_terms_description VARCHAR(255)
)
BEGIN
    -- If terms_description is NULL, generate a default description
    IF test_terms_description IS NULL THEN
        -- SET terms_description = CONCAT('Net due ', CAST(terms_due_days AS CHAR), ' days');
        set test_terms_description = concat('Net due ', test_terms_due_days, ' days');
    END IF;

    -- Insert the new terms into the Terms table
    INSERT INTO terms (terms_due_days, terms_description) 
    VALUES (test_terms_due_days, test_terms_description);
END//

DELIMITER ;

-- Call the stored procedure to insert a new set of terms (modify parameters as needed)
CALL insert_terms(301, null);
select * from terms 
where terms_description = 'Net due 301 Days';
