-- Ex 1
select *
from vendors as v join invoices as i on v.vendor_id = i.vendor_id;
-- Ex 2
select v.vendor_name, i.invoice_number, i.invoice_date, (i.invoice_total - i.payment_total - i.credit_total) as balance_due
from vendors as v join invoices as i on v.vendor_id = i.vendor_id
having balance_due != 0
order by v.vendor_name;
-- Ex 3
select v.vendor_name, v.default_account_number, g.account_description as 'description'
from vendors as v join general_ledger_accounts as g on g.account_number = v.default_account_number
group by v.vendor_id, v.vendor_name
order by g.account_description, v.vendor_name;
-- Ex 4
select v.vendor_name, i.invoice_date, i.invoice_number, il.invoice_sequence as li_sequence, il.line_item_amount as li_amount
from vendors as v join invoices as i on v.vendor_id = i.vendor_id
join invoice_line_items as il on il.invoice_id = i.invoice_id
order by v.vendor_name, i.invoice_date, i.invoice_number, il.invoice_sequence;
-- Ex 5
select v1.vendor_id, v1.vendor_name, concat(v1.vendor_contact_first_name, ' ', v1.vendor_contact_last_name) as concat_name
from vendors as v join vendors as v1 on v.vendor_contact_last_name = v1.vendor_contact_last_name
where v.vendor_id <> v1.vendor_id
order by v1.vendor_contact_last_name;
-- Ex 6
select g.account_number, g.account_description
from general_ledger_accounts as g left join invoice_line_items as i on g.account_number = i.account_number
where i.invoice_id is null
order by g.account_number;
-- Ex 7
select vendor_name, 'CA' as vendor_state
from vendors
where vendor_state = 'California'
union
select vendor_name, 'Outsize CA.' as vendor_state
from vendors
where vendor_state !=  'California'
order by vendor_name;