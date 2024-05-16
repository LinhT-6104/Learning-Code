-- 1
select g.account_number, g.account_description, sum(i.line_item_amount) as total_line_item_amount
from invoice_line_items as i join general_ledger_accounts as g on i.account_number = g.account_number
group by g.account_number
having sum(i.line_item_amount) > (select avg(line_item_amount) from invoice_line_items);

-- 2 
drop procedure if exists proc_725105115;
delimiter //
create procedure proc_725105115(
		in	Delete_account_param	int,
        in 	Update_account_param 	int
		)
begin
	declare done int default false;
    declare continue handler for sqlexception
		set done = true;
        
	start transaction;
    
    if (select count(*) from invoice_line_items where account_number = Delete_account_param) > 0 then
		update invoice_line_items
        set account_number = Update_account_param
        where account_number =  Delete_account_param;
	end if;
    
    if (select count(*) from vendors where default_account_number = Delete_account_param) > 0 then
		update invoice_line_items
        set default_account_number = Update_account_param
        where default_account_number =  Delete_account_param;
	end if;
    
    delete from general_ledger_accounts
    where account_number = Delete_account_param;
    
    if (done) then
		rollback;
        select 'Xoá Account không thành công!' as message;
	else 
		commit;
        select 'Đã thực hiện xóa account thành công!' as message;
	end if;
end //
delimiter ;

call proc_725105115(570, 5700);
select * from invoice_line_items;

-- 3
drop procedure if exists fun_725105115;
delimiter //
create function fun_725105115(
	vendor_id_pa 	int, 
	invoice_date1	date,
	invoice_date2	date
)
returns int
deterministic
begin
	declare soHoaDon int;
	select count(*) into soHoaDon
    from vendors as v join invoices as i on i.vendor_id = v.vendor_id
    where v.vendor_id = vendor_id_pa and i.invoice_date between invoice_date1 and invoice_date2;
    
    return soHoaDon;
end //
delimiter ;

select fun_725105115(122, '2018-07-16', '2018-07-31');