use ap_725105115;

-- --------------------------------12--------------------------------
-- 12.1
drop view if exists open_items;

create view open_items as
select 
	v.vendor_name,
    i.invoice_number,
    i.invoice_total,
    (i.invoice_total - i.payment_total - i.credit_total) as balance_due
from invoices i
join vendors v on i.vendor_id = v.vendor_id
where (i.invoice_total - i.payment_total - i.credit_total) > 0
order by v.vendor_name;

select * from open_items;

select * 
from invoices;

-- 12.2
select * from open_items
where balance_due >= 1000;

-- 12.3
drop view if exists open_items_summary;
create or replace view open_items_summary as
select 
	vendor_name, 
    count(*) as open_item_count,
    sum(balance_due) as open_item_total
from open_items
group by vendor_name
order by open_item_total desc;

select * from open_items_summary;

-- 12.4
select * from open_items_summary
limit 5;

-- 12.5
create or replace view vendor_address as
select vendor_id, vendor_address1, vendor_address2, vendor_city, vendor_state, vendor_zip_code
from vendors;

select * from vendor_address;

-- 12.6
update vendor_address
set vendor_address1 = '1990 Westwood Blvd', vendor_address2 = 'Ste 260'
where vendor_id = 4;

select * from vendors
where vendor_id = 4;


-- --------------------------------13--------------------------------
-- 13.1:
use ap_725105115;
delimiter //
create procedure test()
begin
	declare balance_due_count int;
    
    select count(*) into balance_due_count
    from invoices
    where (invoice_total - payment_total - credit_total) >= 5000;
    
    select concat(balance_due_count, ' invoices exceed $5,000.') as messsage;
end //
delimiter ;

call test();

-- 13.2:
drop procedure if exists test;

delimiter //
create procedure test()
begin
	declare balance_due_count int;
    declare balance_due_sum decimal(9,2);
    
    select count(*), sum(invoice_total - payment_total - credit_total)
    into balance_due_count, balance_due_sum
    from invoices;
    
    if balance_due_sum >= 30000 then
		select balance_due_count, balance_due_sum;
	else
		select concat('Total balance is less than $30,000.') as massage;
	end if;
end //
delimiter ;

call test();

-- 13.3
drop procedure if exists test;

delimiter //
create procedure test()
begin
	declare factorial int default 1;
    declare ten int default 10;
    
    while ten > 0 do
		set factorial = factorial * ten;
        set ten = ten - 1;
	end while;
    
    select concat('The factorial of 10 is: ', factorial);
end //
delimiter ;

call test();

-- 13.4:
drop procedure if exists test;

delimiter //
create procedure test()
begin
	declare done INT default false;
    declare vendor_name VARCHAR(255);
    declare invoice_number varchar(255);
    declare balance_due DECIMAL(9,2);
	
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
			select concat(balance_due, '|', invoice_number, '|', vendor_name, '//');
		end loop;
    close cur;
end //
delimiter ;

call test();

-- 13.5:
use ap_725105115;
drop procedure if exists test;

delimiter //
create procedure test()
begin
	declare update_count int default 0;
	declare can_update int default true;
	
	declare continue handler for sqlexception
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

-- 13.6
drop procedure if exists test;

delimiter //
create procedure test()
begin
	declare prime_numbers varchar(255)  default '';
	declare num int default 2;
    declare is_prime boolean;
    declare i int default 1;
    declare divisor int;
    
    check_while : while i < 100 do
		set is_prime = true;
		set divisor = 2;
		check_while_trong : while divisor <= sqrt(i) do
			if i % divisor = 0 then
				set is_prime = false;
				leave check_while_trong;
			end if;
            set divisor = divisor + 1;
		end while;
        if is_prime then
			set prime_numbers = concat(prime_numbers, i, ' | ');
		end if;
        set i = i + 1;
    end while check_while;
    
    select prime_numbers as message;
end //
delimiter ;

call test();

-- 13.7
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

-- --------------------------------14--------------------------------
-- 14.1
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare sql_err int default false;
    
    declare continue handler for sqlexception
		set sql_err = true;
        
	start transaction;
    update invoices
    set vendor_id = 123
    where vendor_id = 122;
    
    delete from vendors
    where vendor_id = 122;
    
    update vendors
    set vendor_name = 'FedUP'
    where vendor_id = 123;
    
    if sql_err = false then
		commit;
        select 'The transaction was commited';
	else 
		rollback;
        select 'The transaction was rolled back';
	end if;
end //
delimiter ;

call test();

select * from vendors where vendor_name = 'FedUP';


-- 14.2
drop procedure if exists test;

delimiter //
create procedure test()
begin
	declare sql_error int default false;
    
    declare continue handler for sqlexception
		set sql_error = true;
	
    start transaction;
    delete from invoice_line_items
    where invoice_id = 114;
    
    delete from invoices
    where invoice_id = 114;
    
    if sql_error = false then
		commit;
        select 'The transaction was commited' as heading;
	else
		rollback;
        select 'The transaction was rolled back' as heading;
	end if;
end //
delimiter ;

call test();
select * from invoice_line_items where invoice_id = 114;


-- --------------------------------15--------------------------------
-- 15.1
drop procedure if exists insert_glaccount;

delimiter //
create procedure insert_glaccount (
	account_number_param 		int,
    account_description_param 	varchar(50)
)
begin	
    insert into general_ledger_accounts
    value (account_number_param, account_description_param);
end //
delimiter ;

call insert_glaccount(6, 'NgaySinh');

select * from general_ledger_accounts where account_number = 6;


-- 15.2
use ap_725105115;
drop function if exists test_glaccounts_description;
delimiter //
create function test_glaccounts_description ( 
	account_description_param varchar(50)
)
returns int
deterministic reads sql data
begin
	declare account_descrip_var varchar(50);
    
	select account_description into account_descrip_var
    from general_ledger_accounts
    where account_description = account_description_param;
    if account_descrip_var is not null then
		return 1;
	else return 0;
    end if;
end //
delimiter ;

select test_glaccounts_description('Accountings');

select * from general_ledger_accounts;

-- 15.3
use ap_725105115;
drop procedure if exists insert_glaccount_with_test;

delimiter //
create procedure insert_glaccount_with_test (
	account_number_param 		int,
    account_description_param 	varchar(50)
)
begin
	if test_glaccounts_description(account_description_param) = 0 then
		insert into general_ledger_accounts
		value (account_number_param, account_description_param);
    else 
		signal sqlstate '23000'
			set message_text = 'Duplicate account description', mysql_errno = '1062';
    end if;
end //
delimiter ;

CALL insert_glaccount_with_test(1001, 'Accounting Fees');

select * from general_ledger_accounts where account_number = 1001;

-- 15.4
drop procedure if exists insert_terms;
delimiter //
create procedure insert_terms(
	terms_due_days_param		int,
    terms_description_param		varchar(50)
)
begin
	if terms_description_param is null then
		set terms_description_param = concat('Net due ', terms_due_days_param, ' days');
	end if;
    insert into terms (terms_due_days, terms_description)
    values (terms_due_days_param, terms_description_param);
end //
delimiter ;

call insert_terms(40, null);

select * from terms