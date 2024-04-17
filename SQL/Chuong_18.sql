-- Bai 1

-- Bai 2:
create user ray@localhost identified by 'temp'
password expire interval 90 day;

grant select, insert, update
on ap_725105115.vendors
to ray@localhost
with grant option;

grant select, insert, update
on ap_725105115.invoices
to ray@localhost
with grant option;

grant select, insert
on ap_725105115.invoice_line_items
to ray@localhost
with grant option;

-- Bai 3:
show grants for ray@localhost;

-- Bai 4:

-- Bai 5:
SELECT vendor_id FROM ap_725105115.vendors;

-- Bai 6:
delete from ap_725105115.vendors where <codition>;

-- Bai 7:

-- Bai 8:
grant udpate
on ap_725105115.invoice_line_items
to 	ray@localhost
with grant option;

-- Bai 9:
create user 'dorothy'@'localhost' identified by 'sesame';

create role if not exists ap_user;
grant select, insert, update
on ap_725105115.*
to ap_user;

revoke delete on ap_725105115.* from ap_user;

grant ap_user to 'dorothy'@'localhost';

-- Bai 10:
show grants for 'dorothy'@'localhost';

-- Bai 11:

-- Bai 12:
select current_role();

-- Bai 13:

-- Bai 14:
alter user 'dorothy'@'localhost' default role ap_user;
set default role ap_user to 'dorothy'@'localhost';
 