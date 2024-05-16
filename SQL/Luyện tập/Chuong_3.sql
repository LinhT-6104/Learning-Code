-- Ex 8
select vendor_name, vendor_contact_last_name, vendor_contact_first_name
from vendors
order by vendor_contact_last_name, vendor_contact_first_name;
-- Ex 9 
select concat(vendor_contact_last_name, ', ', vendor_contact_first_name) as full_name
from vendors
where left(vendor_contact_last_name, 1) in ('A', 'B', 'C', 'E')
order by vendor_contact_last_name, vendor_contact_first_name;
-- Ex 10
select invoice_due_date as 'Due Date', invoice_total as 'Invoice Total', (0.1 * invoice_total) as '10%', (invoice_total + 0.1 * invoice_total) as 'Plus 10%'
from invoices
where invoice_total >= 500 and invoice_total <= 1000
order by invoice_due_date desc;
-- Ex 11
select invoice_number, invoice_total, sum(payment_total + credit_total) as payment_credit_total, (invoice_total - payment_total - credit_total) as balance_due
from invoices 
group by invoice_id
having balance_due > 50
order by balance_due desc
limit 5;
-- Ex 12
select invoice_number, invoice_date, (invoice_total - payment_total - credit_total) as balance_due, payment_date
from invoices
where payment_date = null;
-- Ex 13
select current_date() as 'current_date', date_format(current_date(), '%m-%d-%Y') as 'timedate' ;
-- Ex 14
select 
	50000 as starting_principal, 
    0.065 * 50000 as interest, 
    50000 + 0.065 * 50000 as principal_plus_interest;