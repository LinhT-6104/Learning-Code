-- Chuong 7
-- Ex 1
select distinct v.vendor_name
from vendors as v
where vendor_id in (select vendor_id 
					from invoices as i
                    where v.vendor_id = i.vendor_id)
order by v.vendor_name;
-- Ex 2
select invoice_number, invoice_total
from invoices
where payment_total > (select avg(payment_total)
					   from invoices
                       where payment_total > 0)
group by invoice_id
order by invoice_total desc;
-- Ex 3
select account_number, account_description
from general_ledger_accounts as g
where not exists (select 1
				  from invoice_line_items as i
                  where g.account_number = i.account_number)
order by account_number;
-- Ex 4
select v.vendor_name, i.invoice_id, il.invoice_sequence, il.line_item_amount
from invoice_line_items as il
join invoices as i on il.invoice_id = i.invoice_id
join vendors as v on v.vendor_id = i.vendor_id
where i.invoice_id in (select distinct invoice_id 
						from invoice_line_items
						where invoice_sequence > 1)
order by v.vendor_name, i.invoice_id, il.invoice_sequence;
-- Ex 5
select sum(largest_unpaid_invoice)
from (select vendor_id, max(invoice_total - credit_total - payment_total) as largest_unpaid_invoice
from invoices
where invoice_total > payment_total + credit_total or payment_total is null
group by vendor_id) as max_unpaid;
-- Ex 6 
select v1.vendor_name, v1.vendor_city, v1.vendor_state
from vendors as v1
where not exists (select 1
				  from vendors as v2
                  where v1.vendor_id <> v2.vendor_id and v1.vendor_city = v2.vendor_city and v1.vendor_state = v2.vendor_state)
order by v1.vendor_state, v1.vendor_city;
-- Ex 7
select v.vendor_name, i.invoice_number, i.invoice_date, i.invoice_total
from vendors as v join invoices as i on v.vendor_id = i.vendor_id
where i.invoice_date = (select min(invoice_date)
						from invoices
                        where vendor_id = v.vendor_id)
order by v.vendor_name;


