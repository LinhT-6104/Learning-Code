-- Chương 7:
-- Bai 1:
select DISTINCT vendor_name
from vendors v
WHERE v.vendor_id in (select vendor_id
                      from invoices)
ORDER by vendor_name;

-- Bai 2:
select i.invoice_number, i.invoice_total
from invoices i
WHERE i.payment_total > (select avg(i1.payment_total)
                         from invoices i1
                         WHERE i1.payment_total > 0)
order by i.invoice_total desc;

-- Bai 3:
select gla.account_number, gla.account_description
from general_ledger_accounts gla
WHERE not exists (select 1
                  from invoice_line_items ili
                  where ili.account_number = gla.account_number)
ORDER by gla.account_number;

-- Bai 4:
SELECT v.vendor_name, ili.invoice_id, ili.invoice_sequence, ili.line_item_amount
from vendors v
join invoices i on v.vendor_id = i.vendor_id
join invoice_line_items ili on i.invoice_id = ili.invoice_id
WHERE i.invoice_id in (select DISTINCT invoice_id
                       from invoice_line_items   
                       WHERE invoice_sequence > 1)
order by v.vendor_name, ili.invoice_id, ili.invoice_sequence;

-- Bai 5:
select SUM(largest_unpaid_invoices)
from (SELECT vendor_id, max(invoice_total - payment_total - credit_total) as largest_unpaid_invoices
      from invoices 
      WHERE payment_total + credit_total < invoice_total or payment_total is NULL
      group by vendor_id) as subQuery;

-- Bai 6:
select vendor_name, vendor_city, vendor_state
from vendors v1
WHERE not EXISTS (select 1
                  from vendors v2
                  where v1.vendor_id <> v2.vendor_id and v1.vendor_city = v2.vendor_city and v1.vendor_state = v2.vendor_state)
order by vendor_state, vendor_city;

-- Bai 7:
SELECT v.vendor_name, i.invoice_number, i.invoice_date, i.invoice_total
from vendors v
join invoices i on i.vendor_id = v.vendor_id
WHERE i.invoice_date = (select min(invoice_date)
                        from invoices
                        where vendor_id = v.vendor_id)
order by v.vendor_name;

-- Bai 8:
SELECT v.vendor_name, i.invoice_number, i.invoice_date, i.invoice_total
from vendors v
join (SELECT vendor_id, min(invoice_date) as min_invoice_date
      from invoices
      group by vendor_id) min_invoice_dates on v.vendor_id = min_invoice_dates.vendor_id
join invoices i on i.vendor_id = min_invoice_dates.vendor_id
order by v.vendor_name;

-- Bai 9:
WITH Largest_Unpaid_Invoices_CTE AS (
    SELECT vendor_id, MAX(invoice_total - payment_total - credit_total) AS largest_unpaid_invoices
    FROM invoices
    WHERE payment_total < invoice_total OR payment_total IS NULL
    GROUP BY vendor_id
)
SELECT SUM(largest_unpaid_invoices) AS unpaid_invoices
FROM Largest_Unpaid_Invoices_CTE;