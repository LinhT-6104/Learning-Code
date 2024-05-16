-- 1
select i.account_number, g.account_description, sum(i.line_item_amount) as sum_line_item_amount
from invoice_line_items as i join general_ledger_accounts as g on i.account_number = g.account_number
group by i.account_number
having sum_line_item_amount > (select avg(line_item_amount)
								from invoice_line_items);                         
							
-- 2
create or replace view View_Vendor_725105115 as 
						select v.vendor_id, v.vendor_name, v.vendor_address1, v.vendor_contact_last_name, v.vendor_contact_first_name, count(*) as tong_so_hoa_don
                        from vendors as v join invoices as i on i.vendor_id = v.vendor_id
                        group by v.vendor_id;
select vendor_id, vendor_name, tong_so_hoa_don
from View_Vendor_725105115
where tong_so_hoa_don > 5;		

-- 3
drop procedure if exists proc_725105115;	
delimiter //
create procedure proc_725105115(
	in Delete_term_param	int,
    in Update_term_param	int
    ) 
begin
	declare done int default false;
    
    declare continue handler for sqlexception
		set done = true;
	
    start transaction;
    if (select count(*) from invoices where terms_id = Delete_term_param) > 0 then
		update invoices
        set terms_id = Update_term_param
        where terms_id = Delete_term_param;
	end if;
    
    if (select count(*) from vendors where default_terms_id = Delete_term_param) > 0 then
		update vendors
        set default_terms_id = Update_term_param
        where default_terms_id = Delete_term_param;
	end if;
    
    delete from terms
    where terms_id = Delete_term_param;
    
    if done then
		rollback;
        select 'Bản ghi không được xóa!' as error_message;
	else
		commit;
        select 'Xóa thành công!' as success_message;
	end if;
end //
delimiter ;

call proc_725105115(3, 5);

select * from terms where terms_id = 3;
select * from invoices where terms_id = 5;
select * from vendors where default_terms_id = 5;