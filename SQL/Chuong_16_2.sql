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
drop trigger if exists invoices_after_update;
delimiter //
create trigger invoices_after_update
	after update on invoices
    for each row
begin
	insert into invoices_audit 
    values (old.vendor_id, old.invoice_number, old.invoice_total, 'INSERTED', now());
end //
delimiter ;

INSERT INTO invoices VALUES
(115, 34, 'ZXA-080', '2018-02-01', 14092.59, 0, 0, 3,'2018-03-01', NULL);

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

alter event insert_test_row_event disable;