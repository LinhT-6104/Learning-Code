drop procedure if exists update_invoices_credit_total;
delimiter //

create procedure update_invoices_credit_total
(
	invoice_id_param 	int,
    credit_total_param	decimal(9, 2)
)
begin
	declare sql_error int default false;
    
    declare continue handler for sqlexception
		set sql_error = true;
	
    start transaction;
    update invoices
    set credit_total = credit_total_param
    where invoice_id = invoice_id_param;
    
    if sql_error = false then
		commit;
	else
		rollback;
	end if;
end //

delimiter ;

call update_invoices_credit_total(56, 200);
call update_invoices_credit_total(56, 100);
call update_invoices_credit_total(100, 500);

select invoice_id, credit_total from invoices
where invoice_id = 100;

-- -----------------------------------------------------------------
-- In/out
use ap_725105115;
drop procedure if exists update_invoices_credit_total;
delimiter //

create procedure update_invoices_credit_total
(
	in invoice_id_param 	int,
    in credit_total_param	decimal(9, 2),
    out update_count		int
)
begin
	declare sql_error int default false;
    
    declare continue handler for sqlexception
		set sql_error = true;
	
    start transaction;
    update invoices
    set credit_total = credit_total_param
    where invoice_id = invoice_id_param;
    
    if sql_error = false then
		set update_count = 1;
		commit;
	else
		set update_count = 0;
		rollback;
	end if;
end //

delimiter ;

call update_invoices_credit_total(56, 200, @row_count);

call update_invoices_credit_total(24211, 0, @row_count);

select concat('row_count: ', @row_count) as update_count;
