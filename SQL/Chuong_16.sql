-- Bai 1:
drop trigger if exists invoices_before_update;

delimiter //
create trigger invoices_before_update
	before update on invoices
    for each row
begin
	declare sum_line_item_amount	decimal(9,2);
    
    select sum(line_item_amount)
    into sum_line_item_amount
    from invoice_line_items
    where invoice_id = new.invoice_id;
    
    if sum_line_item_amount != new.invoice_total then
		signal sqlstate 'HY000'
			set message_text = 'Line item total must match invoice total.';
	elseif new.payment_total + new.credit_total > new.invoice_total then
		signal sqlstate 'HY000'
			set message_text = 'Payment total + credit total can not be greater then the invoice total';
	end if;
end //
delimiter ;

UPDATE invoices
SET payment_total = 10000, credit_total = 1000
WHERE invoice_id = 112;

-- Bai 2:
use ap_725105115;

DROP TRIGGER IF EXISTS invoices_after_update;

DELIMITER //
CREATE TRIGGER invoices_after_update
AFTER UPDATE ON invoices
FOR EACH ROW
BEGIN
    INSERT INTO invoices_audit (vendor_id, invoice_number, invoice_total, action_type, action_date)
    VALUES (OLD.vendor_id, OLD.invoice_number, OLD.invoice_total, 'UPDATED', NOW());
END //

DELIMITER ;

UPDATE Invoices
SET payment_total = 500
WHERE invoice_id = 110;

SELECT * FROM invoices_audit;
SELECT * FROM invoices;

-- Bai 3:
show variables like 'event_scheduler';
set global event_scheduler = on;

delimiter //
create event insert_test_row_event
on schedule every 1 minute
do begin
	insert into invoices_audit
    values(1, 'TEST', 100.00, 'TEST', NOW());
end //
delimiter ;

show events;
select * from invoices_audit;
DROP EVENT insert_test_row_event;


drop table if exists invoices_audit;
