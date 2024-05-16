-- Chuong 12
-- Ex 1
create or replace view open_items as
	select v.vendor_name, i.invoice_number, i.invoice_total, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
    from vendors as v join invoices as i on v.vendor_id = i.vendor_id
	having balance_due > 0
    order by v.vendor_name;
-- Ex 2
select * from open_items
where balance_due > 1000;
-- Ex 3
create or replace view open_items_summary as
	select vendor_name, count(*) as open_item_count, sum(balance_due) as open_item_total
    from open_items
    group by vendor_name
    order by open_item_total desc;
-- Ex 4
select * from open_items_summary limit 5;
-- Ex 5
create or replace view vendor_address as
	select vendor_id, vendor_address1, vendor_address2, vendor_city, vendor_state, vendor_zip_code
	from vendors;
-- Ex 6
select * from vendors where vendor_id = 4;
update vendor_address
set vendor_address2 = 'Ste 260', vendor_address1 = '1990 Westwood Blvd'
where vendor_id = 4;