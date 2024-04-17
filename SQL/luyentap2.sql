use ap_725105115;
-- 12.1
create or replace view open_items as
select v.vendor_name, i.invoice_number, i.invoice_total, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
from vendors as v join invoices as i on i.vendor_id = v.vendor_id
where (i.invoice_total - i.payment_total - i.credit_total) > 0
order by v.vendor_name;
	
select * from open_items;

-- 12.2
select * from open_items
where balance_due >= 1000;

-- 12.3
create or replace view open_items_summary as
select vendor_name, count(*) as open_item_count, sum(balance_due) as open_item_total
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
set vendor_address2 = "Ste260",
	vendor_address1 = "1990 Westwood Blvd"
where vendor_id = 4;

select vendor_address1,vendor_address2 from vendors where vendor_id = 4;

-- 13.1
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare count_row int;
    
    select count(*) into count_row
    from invoices as i
    where (i.invoice_total - i.payment_total - i.credit_total) >= 5000;
    
    select concat(count_row, ' invoices exceed $5,000.');
end //
delimiter ;

call test();

-- 13.2
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare balance_due_count int;
    declare balance_due_sum decimal(9,2);
    
    select count(*), sum(i.invoice_total - i.payment_total - i.credit_total)
    into balance_due_count, balance_due_sum
    from invoices as i;
    
    if balance_due_sum >= 30000 then
		select balance_due_count, balance_due_sum;
	else
		select concat('Total balance due is less than $30,000.');
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
    declare i int default 1;
    
    while i <= 10 do
		set factorial = factorial * i;
        set i = i + 1;
    end while;
    
    select concat('The factorial of 10 is: ', factorial, '.');
end //
delimiter ;

call test();

-- 13.4
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare done int default false;
    declare result varchar(255) default '';
	declare vendor_name_param varchar(50);
    declare invoice_number_param varchar(50);
    declare balance_due_param decimal(9,2);
	
	declare cur Cursor for
		select v.vendor_name, i.invoice_number, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
		from invoices as i join vendors as v on i.vendor_id = v.vendor_id
        where (i.invoice_total - i.payment_total - i.credit_total) >= 5000
        order by (i.invoice_total - i.payment_total - i.credit_total) desc;
	
    declare continue handler for not found
		set done = true;
    
    open cur;
		read_loop : loop
			fetch cur into vendor_name_param, invoice_number_param, balance_due_param;
            if done then
				leave read_loop;
			end if;
			set result = concat(result, balance_due_param, '|', invoice_number_param, '|', vendor_name_param, '//');
        end loop read_loop;
    close cur;
    
    select result as message;
end //
delimiter ;

call test();

-- 13.5
drop procedure if exists test;
delimiter //
create procedure test()
begin
    declare count_up int default 0;
    declare success boolean default true;
    
    declare continue handler for sqlexception
        set success = false;
    
    update invoices
    set invoice_due_date = null
    where invoice_id = 1;
    
    set count_up = row_count();
    
    if count_up > 0 and success then
        select concat(count_up, ' row was updated.') as message;
    else
        select 'Row was not updated - column cannot be null' as message;
    end if;
end //    
delimiter ;

call test();

-- 13.6
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare result varchar(255) default '';
    declare i int default 2;
    declare is_prime int;
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
			set result = concat(result, i, ' | ');
		end if;
        set i = i + 1;
    end while check_while;
	select result;
end //
delimiter ;

call test();

-- 13.7:
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare done int default false;
	declare vendor_name_param varchar(50);
    declare invoice_number_param varchar(50);
    declare balance_due_param decimal(9,2);
    
    declare heading20_More varchar(255) default '$20,000 or More: ';
    declare heading10_20 varchar(255) default '$10,000 to $20,000: ';
    declare heading5_10 varchar(255) default '$5,000 to $10,000: ';
    declare result varchar(255) default '';
	
	declare cur Cursor for
		select v.vendor_name, i.invoice_number, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
		from invoices as i join vendors as v on i.vendor_id = v.vendor_id
        where (i.invoice_total - i.payment_total - i.credit_total) >= 5000
        order by (i.invoice_total - i.payment_total - i.credit_total) desc;
	
    declare continue handler for not found
		set done = true;
    
    open cur;
		read_loop : loop
			fetch cur into vendor_name_param, invoice_number_param, balance_due_param;
            if done then
				leave read_loop;
			end if;
            if balance_due_param >= 20000 then
				set heading20_More = concat(heading20_More, balance_due_param, '|', invoice_number_param, '|', vendor_name_param, '//');
			elseif balance_due_param between 10000 and 20000 then
				set heading10_20 = concat(heading10_20, balance_due_param, '|', invoice_number_param, '|', vendor_name_param, '//');
			elseif balance_due_param between 5000 and 10000 then
				set heading5_10 = concat(heading5_10, balance_due_param, '|', invoice_number_param, '|', vendor_name_param, '//');
			end if;
        end loop read_loop;
		set result = concat(heading20_More, heading10_20, heading5_10);
		select result;
    close cur;
    select result as message;
end //
delimiter ;

call test();

-- 14.1: