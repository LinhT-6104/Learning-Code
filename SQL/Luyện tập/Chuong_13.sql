-- Chuong 13
-- Ex 1
drop procedure if exists test;
delimiter //
create procedure test() 
begin
	declare count_var int;
    
    select count(*) into count_var
    from invoices
    where (invoice_total - payment_total - credit_total) >= 5000;
    
    select concat(count_var, ' invoices exceed $5,000.');
end //
delimiter ;
call test();
-- Ex2
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare count_balance_due	int;
	declare total_balance_due		decimal(9,2);
    
    select count(*), sum(invoice_total - payment_total - credit_total) 
    into count_balance_due, total_balance_due
    from invoices 
    where invoice_total - payment_total - credit_total > 0;
    
    if total_balance_due >= 30000 then
		select count_balance_due as count, total_balance_due as total;
	else
		select 'Total balance due is less than $30,000.' as message;
	end if;
end //
delimiter ;
call test();
-- Ex 3
drop procedure if exists test;
delimiter //
create procedure test()
begin
	declare factorial int default 1;
    declare i int default 10;
    
    while i > 1 do
		set factorial = factorial * i;
        set i = i -1;
    end while;
    
    select concat('The factorial of 10 is: ', factorial) as message;
end //
delimiter ;
call test();
-- Ex 4
drop procedure if exists test;
delimiter //
create procedure test()
begin	
	declare result varchar(255) default '';
	declare vendor_name_param varchar(50);
	declare invoice_number_param varchar(50);
    declare balance_due_param decimal(9,2);
	
    declare done int default false;
    
	declare cur cursor for 
		select v.vendor_name, i.invoice_number, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
        from invoices as i join vendors as v on v.vendor_id = i.vendor_id
        group by i.invoice_id
        having balance_due >= 5000
        order by balance_due desc;
	
    declare continue handler for not found
		set done = true;
    
	open cur;
		read_loop: loop
			fetch cur into vendor_name_param, invoice_number_param, balance_due_param;
            if done then
				leave read_loop;
			end if;
            set result = concat(result, balance_due_param, '|', invoice_number_param, '|', vendor_name_param,'//');
        end loop;
    close cur;
    
    select result as message;
end //
delimiter ;
call test();
-- Ex 5
-- drop procedure if exists test;
-- delimiter //
-- create procedure test()
-- begin
-- 	update 
-- end //
-- delimiter ;