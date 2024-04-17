-- Bai 1:
select g.account_number, g.account_description, sum(i.line_item_amount)
from general_ledger_accounts as g 
join invoice_line_items as i on g.account_number = i.account_number
group by g.account_number
having sum(i.line_item_amount) > (
	select avg(line_item_amount)
    from invoice_line_items
);

-- Bai 2:
create or replace view View_Vendor_725105155 as
select 
	v.vendor_id, v.vendor_name, v.vendor_address1, 
    v.vendor_contact_last_name, v.vendor_contact_first_name,
    count(*) as total_invoice
from invoices as i join vendors as v on i.vendor_id = v.vendor_id
group by v.vendor_id
having total_invoice > 5 ;

select vendor_id, vendor_name, total_invoice
from View_Vendor_725105155;

-- Bai 3
drop procedure if exists proc_725105115;
delimiter // 
create procedure proc_725105115(
	Delete_term_param int,
    Update_term_param int
)
begin
	declare err int default false;
    
    declare continue handler for sqlexception
		set err = true;

	start transaction;
    
    delete from terms
    where terms_id = Delete_term_param;
    
    if (select count(*) from vendors
        where default_terms_id = Delete_term_param) > 0 then
        update vendors as v
		set v.default_terms_id = Update_term_param
        where v.default_terms_id = Delete_term_param;		
	end if;
    
    if (select count(*) from invoices
        where terms_id = Delete_term_param) > 0 then
        update invoices as i
		set i.terms_id = Update_term_param
        where i.terms_id = Delete_term_param;		
	end if;
    
    if err then
		rollback;
        select "Bản ghi không được xóa!";
	else
		commit;
        select "Xóa thành công!";
	end if;
end //
delimiter ;

call proc_725105115(3, 150);

select * from terms;
select * from vendors where default_terms_id = 3;
select * from invoices where terms_id = 3;