-- Chuong 3
-- Câu 8:
select vendor_name, vendor_contact_last_name, vendor_contact_first_name
from vendors
order by vendor_contact_last_name, vendor_contact_first_name;

-- Câu 9:
select CONCAT(vendor_contact_last_name,', ', vendor_contact_first_name) as full_name, count(*)
from vendors
where left(vendor_contact_last_name, 1) in ('A', 'B', 'C', 'E')
order by vendor_contact_last_name, vendor_contact_first_name;

-- Câu 10:
SELECT
	invoice_due_date AS "Due Date",
  	invoice_total AS "Invoice Total",
  	invoice_total * 0.1 AS "10%",
  	invoice_total + (invoice_total * 0.1) AS "Plus 10%"
FROM
  	invoices
WHERE 
	invoice_total >= 500 AND invoice_total <= 1000
ORDER BY 
	invoice_due_date DESC;

-- Câu 11:
SELECT
  invoice_number,
  invoice_total,
  payment_total + credit_total AS "Sum of Payment and Credit",
  invoice_total - (payment_total + credit_total) AS "Balance Due"
FROM
  invoices
WHERE
  invoice_total - (payment_total + credit_total) > 50
ORDER BY
  invoice_total - (payment_total + credit_total) DESC
LIMIT 5;

-- Câu 12:
select invoice_number, invoice_date, (invoice_total-(payment_total+credit_total)) as balance_due, payment_date
from invoices
where payment_date is NULL;

-- Câu 13:
SELECT
  CURRENT_DATE AS "current_date",
  DATE_FORMAT(CURRENT_DATE, '%m-%d-%Y') AS "formatted_current_date";

-- Câu 14:
SELECT
  50000 AS starting_principal,
  0.065 * 50000 AS interest,
  50000 + (0.065 * 50000) AS principal_plus_interest;


-- Chuong 4:
-- 2
SELECT v.vendor_name, i.invoice_number, i.invoice_date, (i.invoice_total - (i.payment_total + i.credit_total)) AS balance_due
FROM vendors AS v
JOIN invoices AS i ON v.vendor_id = i.vendor_id
WHERE i.invoice_total - (i.payment_total + i.credit_total) <> 0
ORDER BY v.vendor_name ASC;

-- 3
select 
	v.vendor_name,
    v.default_account_number as 'default account',
    g.account_description as 'description'
from vendors as v
	join general_ledger_accounts as g on g.account_number = v.default_account_number
order by g.account_description, v.vendor_name;

-- 4
select 	
	v.vendor_name,
    i.invoice_date,
    i.invoice_number,
    ili.invoice_sequence,
    ili.line_item_amount
from vendors as v 
	join invoices as i on v.vendor_id = i.vendor_id
	join invoice_line_items as ili on ili.invoice_id = i.invoice_id
order By v.vendor_name, i.invoice_date, i.invoice_number, ili.invoice_sequence;

-- 5
select 
	v1.vendor_id, 
	v1.vendor_name, 
    CONCAT(v1.vendor_contact_first_name, ' ', v1.vendor_contact_last_name) as contact_name
from vendors as v1
join vendors as v2 on v1.vendor_contact_last_name = v2.vendor_contact_last_name
WHERE v1.vendor_id <> v2.vendor_id
order by contact_name;
	
-- 6
SELECT
 	g.account_number,
  	g.account_description
FROM general_ledger_accounts g
LEFT JOIN invoice_line_items i ON g.account_number = i.account_number
WHERE i.invoice_id IS NULL
ORDER BY g.account_number;

-- 7
SELECT
  vendor_name,
  'CA' as vendor_state
FROM vendors
WHERE vendor_state = 'California'
UNION
SELECT
  vendor_name,
  'Outside CA' as vendor_state 
FROM vendors
WHERE vendor_state != 'California'
ORDER BY vendor_name;


-- Chương 5:
-- Câu 1:
insert Into terms VALUES(6, 'Net due 120 days', 120);

-- Câu 2:
update terms set terms_description = 'Net due 125 days';
update terms set terms_due_days = 125;

-- Câu 3:
delete from terms
where terms_id = 6 and terms_description = 'Net due 120 days' and terms_due_days = 120;

-- Câu 4:
INSERT INTO invoices
VALUES (DEFAULT, 32, 'AX-014-027', '2014-08-01', 434.58, 0, 0, 2, '2014-08-31', NULL);

-- ALTER TABLE invoices AUTO_INCREMENT = 114; --

-- Câu 5: 
select last_insert_id();
-- SELECT * FROM INVOICES order by INVOICE_ID DESC;
-- SELECT * FROM invoice_line_items order by INVOICE_ID DESC;

INSERT INTO INVOICE_LINE_ITEMS
VALUES (last_insert_id(), 1, 160, 180.23, 'Hard Drive');

INSERT INTO INVOICE_LINE_ITEMS
VALUES (last_insert_id(), 2, 527, 254.35, 'Exchange Server update');

-- Câu 6:
update invoices 
set credit_total = 0.1 * invoice_total, 
    payment_total = invoice_total - (0.1 * invoice_total)
WHERE invoice_id = last_insert_id();

-- select * from invoices;

-- Câu 7:
UPDATE vendors set default_account_number = 403 WHERE vendor_id = 44;

-- Câu 8:
update invoices set terms_id = 2
WHERE vendor_id in (
 	select vendor_id
  	from vendors
  	where default_terms = 2
);

-- Câu 9:
DELETE FROM invoice_line_items
WHERE invoice_id = last_insert_id();

DELETE FROM invoices
WHERE invoice_number = last_insert_id();

-- Chuong 6
-- bai 2:
select 
	v.vendor_name, 
	sum(i.payment_total) as sum_payment_total
from vendors as v 
join invoices as i
on v.vendor_id = i.vendor_id
group by v.vendor_id, v.vendor_name
order by sum_payment_total desc;

-- Bai 3:
SELECT v.vendor_name, count(i.invoice_id) as 'count', sum(i.invoice_total) as 'sum'
from vendors as v
join invoices as i on v.vendor_id = i.vendor_id
group by v.vendor_id, v.vendor_name
order by sum(i.invoice_total) desc;

-- Bai 4:
SELECT 
	g.account_description, 
	count(i.account_number) as 'count',
    sum(i.line_item_amount) as 'sum'
from general_ledger_accounts as g 
join invoice_line_items as i on g.account_number = i.account_number
group by g.account_description
HAVING count(i.account_number) > 1
order by sum(i.line_item_amount) DESC;

-- Bai 5:
SELECT 
	g.account_description, 
	count(ili.account_number) as 'count',
    sum(ili.line_item_amount) as 'sum'
from general_ledger_accounts as g 
join invoice_line_items as ili on g.account_number = ili.account_number
join invoices as i on ili.invoice_id = i.invoice_id
WHERE i.invoice_date BETWEEN '2018-04-01' and '2018-06-30'
group by g.account_description
having count(ili.account_number) > 1
order by sum(ili.line_item_amount) DESC;

-- Bai 6:
SELECT account_number, sum(line_item_amount) as the_sum
from invoice_line_items 
group by account_number with ROLLUP;

-- Bai 7: 
select v.vendor_name, count(DISTINCT ili.account_number) as 'The count of distinct general ledger accounts'
from vendors as v
join invoices as i on v.vendor_id = i.vendor_id
join invoice_line_items as ili on ili.invoice_id = i.invoice_id
group by v.vendor_id, v.vendor_name
HAVING count(DISTINCT ili.account_number) > 1;

-- bai 8:Từ câu 8 trở xuống không biết làm
SELECT
  IF(GROUPING(terms_id) = TRUE, 'Grand Total', terms_id) AS terms_id,
  IF(GROUPING(vendor_id) = TRUE, 'Grand Total', vendor_id) AS vendor_id,
  MAX(payment_date) AS last_payment_date,
  SUM(invoice_total - payment_total - credit_total) AS total_amount_due
FROM
  invoices
GROUP BY
  terms_id, vendor_id WITH ROLLUP;

-- Bai 9:
select 
	vendor_id,
    invoice_id,
    invoice_total - payment_total - credit_total as balance_due,
    (select SUM(invoice_total - payment_total - credit_total) 
     from invoices i2 
     where i2.vendor_id = i.vendor_id and i2.invoice_id <= i.invoice_id) AS cumulative_balance_due_vendor,
    (select SUM(invoice_total - payment_total - credit_total)
	 from invoices) as total_balance_due_all_vendors
from invoices i
WHERE invoice_total - payment_total - credit_total > 0;

-- Bai 10: 
SELECT
  vendor_id,
  invoice_id,
  invoice_total - payment_total - credit_total AS balance_due,
  SUM(invoice_total - payment_total - credit_total) OVER vendor_window AS cumulative_balance_due_vendor,
  AVG(invoice_total - payment_total - credit_total) OVER vendor_window AS cumulative_average_balance_due_vendor,
  SUM(invoice_total - payment_total - credit_total) OVER () AS total_balance_due_all_vendors,
  AVG(invoice_total - payment_total - credit_total) OVER () AS total_average_balance_due_all_vendors
FROM
  invoices
WHERE
  invoice_total - payment_total - credit_total > 0
WINDOW
  vendor_window AS (PARTITION BY vendor_id ORDER BY invoice_id);

-- Bai 11:
SELECT
  DATE_FORMAT(invoice_date, '%d/%m/%y') AS invoice_month,
  SUM(invoice_total) AS total_invoice_amount,
  AVG(SUM(invoice_total)) OVER (ORDER BY DATE_FORMAT(invoice_date, '%Y-%m') ROWS BETWEEN 3 PRECEDING AND CURRENT ROW) AS moving_avg_invoice
FROM 
  invoices	
GROUP BY
  DATE_FORMAT(invoice_date, '%Y-%m')
ORDER BY
  DATE_FORMAT(invoice_date, '%Y-%m');


  

