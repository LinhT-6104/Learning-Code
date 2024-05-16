-- Chuong 6
-- Ex 1
select vendor_id, sum(invoice_total) as sum_invoice_total
from invoices
group by vendor_id;
-- Ex 2
select v.vendor_name, sum(i.payment_total) as sum_payment_total
from vendors as v join invoices as i on v.vendor_id = i.vendor_id
group by v.vendor_id, v.vendor_name
order by sum_payment_total desc;
-- Ex 3
select v.vendor_name, count(*) as count_invoice, sum(i.invoice_total) as sum_invoice_total
from vendors as v join invoices as i on v.vendor_id = i.vendor_id
group by v.vendor_id, v.vendor_name
order by count_invoice desc;
-- Ex 4
select g.account_description, count(*) as count_items, sum(i.line_item_amount) as sum_line_item_amount
from general_ledger_accounts as g join invoice_line_items as i 
on g.account_number = i.account_number
group by g.account_description
having count_items > 1
order by sum_line_item_amount desc;
-- Ex 5
select g.account_description, count(*) as count_items, sum(i.line_item_amount) as sum_line_item_amount
from general_ledger_accounts as g 
join invoice_line_items as i on g.account_number = i.account_number
join invoices as i_ on i.invoice_id = i_.invoice_id
where i_.invoice_date between '2018-4-1' and '2018-6-30'
group by g.account_description
having count_items > 1
order by sum_line_item_amount desc;
-- Ex 6
select account_number, sum(line_item_amount)
from invoice_line_items
group by account_number with rollup;
-- Ex 7
select v.vendor_name, count(distinct il.account_number) as count_distinct_general_ledger_accounts
from vendors as v
join invoices as i on v.vendor_id = i.vendor_id
join invoice_line_items as il on il.invoice_id = i.invoice_id
group by v.vendor_id, v.vendor_name
having count_distinct_general_ledger_accounts > 1;













