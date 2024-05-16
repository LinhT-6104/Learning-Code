-- Bai 1: chị	
    use ap_725105115;
    drop procedure if exists test;
    delimiter //
    create procedure test()
    begin
		declare sql_error int default false;
        declare continue handler for sqlexception
			set sql_error = True;
            
		start transaction;
		update invoices
		set vendor_id = 123
		where vendor_id = 122;
        delete from vendors
        where vendor_id = 122;
		update vendors
		set vendor_name = 'FedUP'
		where vendor_id = 123;
        
		if sql_error = false then
			commit;
			select 'The transaction was commited';
		else
			rollback;
			select 'The transaction was rolled back.';
		end if;
	end //
	delimiter ;


-- --------------------------------------------------------------------------------------

-- Bai 2:
USE ap_725105115;
DROP PROCEDURE IF EXISTS test;

DELIMITER //

CREATE PROCEDURE test()
BEGIN
    DECLARE exit_handler BOOLEAN DEFAULT FALSE;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION 
		SET exit_handler = TRUE;
    
    START TRANSACTION;
    
    -- Delete invoice line items for the given invoice ID
    DELETE FROM invoice_line_items WHERE invoice_id = 114;
    
    -- Delete the invoice from the Invoices table
    DELETE FROM invoices WHERE invoice_id = 114;
    
    IF NOT exit_handler THEN
        COMMIT;
        SELECT 'Changes committed successfully.' AS Result;
    ELSE
        ROLLBACK;
        SELECT 'Error occurred. Changes rolled back.' AS Result;
    END IF;
    
END //

DELIMITER ;

-- --------------------------------------------------------------------------------------

-- Bài 2: chị
use ap_725105115;
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare sql_error int default false;
	declare continue handler for sqlexception
		set sql_error = True;
		
	start transaction;
	delete from invoice_line_items
	where invoice_id = 114;
	delete from invoices
	where vendor_id = 114;
	
	if sql_error = false then
		commit;
		select 'The transaction was commited';
	else
		rollback;
		select 'The transaction was rolled back.';
	end if;
end //
delimiter ;
call test();