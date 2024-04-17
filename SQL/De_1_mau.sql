use ap_725105115;

-- 1 
-- Cach 1: 
drop function if exists max_invoice_count;
delimiter //
create function max_invoice_count() 
returns int
deterministic 
begin
	declare max_count int;
    
    select count(*) into max_count
    from invoices
    group by vendor_id
    order by count(*) desc
    limit 1;
    
    return max_count;
end //
delimiter ;

select v.vendor_id, v.vendor_name, count(*) as tong_hoa_don
from invoices i join vendors v on i.vendor_id = v.vendor_id
group by v.vendor_id
having count(*) = max_invoice_count();

-- Cach 2:
select v.vendor_id, v.vendor_name, count(*) as tong_hoa_don
from invoices i join vendors v on i.vendor_id = v.vendor_id
group by v.vendor_id
having count(*) = (
	select count(*) from invoices
    group by vendor_id
    order by vendor_id desc
    limit 1
);

-- Cach 3:
drop procedure if exists max_invoice;
delimiter //
create procedure max_invoice()
begin
    declare max_value decimal(9,2);
    
    SELECT MAX(invoice_count) INTO max_value
    FROM (
        SELECT COUNT(*) AS invoice_count
        FROM invoices
        GROUP BY vendor_id
    ) AS max_invoice_count;
    
    SELECT i.vendor_id, v.vendor_name, count(*) as invoice_count
    FROM invoices as i 
    JOIN vendors as v ON i.vendor_id = v.vendor_id
    GROUP BY i.vendor_id
    HAVING count(*) = max_value;
end //
delimiter ;

call max_invoice();

-- Bai 2:
create or replace view View_Account_725105115 as
select i.account_number, g.account_description, sum(i.line_item_amount) as total_item
from general_ledger_accounts as g join invoice_line_items as i on g.account_number = i.account_number
group by i.account_number
having total_item <= 5000;

select * from View_Account_725105115;

-- Bai 3:
drop procedure if exists proc_725105115;
delimiter //
create procedure proc_725105115 (
	Delete_account_param int,
    Update_account_param int
)
begin
	declare can_delete int default true;
    
    declare continue handler for sqlexception
		set can_delete = false;
    start transaction;
    
    update invoice_line_items
	set account_number = Update_account_param
	where account_number = Delete_account_param;
	
	update vendors
	set default_account_number = Update_account_param
	where default_account_number = Delete_account_param;
    
	delete from general_ledger_accounts
    where account_number = Delete_account_param;
    
    if not can_delete then
		rollback;
        select "Xóa Account không thành công!" as message;
	else 
		commit;
        select "Đã thực hiện xóa account thành công!" as message;
    end if;
end //	
delimiter ;

call proc_725105115(522, 700);

select * from general_ledger_accounts where account_number = 522;
select * from vendors where default_account_number = 522;
select * from invoice_line_items where account_number = 521;