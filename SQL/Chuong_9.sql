-- Bai 1:
select 
	invoice_total,
    ROUND(invoice_total, 1) as round_invoice_total_1,
    ROUND(invoice_total, 0) as round_invoice_total_0,
    TRUNCATE(invoice_total, 0) as truncate_invoice_total
from invoices;

-- Bai 2:

-- Bai 3:
SELECT
  v.vendor_name,
  UPPER(v.vendor_name) AS capital_vendor_name,
  v.vendor_phone, 
  RIGHT(v.vendor_phone, 4) AS last_four_digits,
  CONCAT(SUBSTRING(v.vendor_phone, 2, 3), '.',
         SUBSTRING(v.vendor_phone, 7, 3), '.',
         SUBSTRING(v.vendor_phone, 11, 4)) AS formatted_vendor_phone,
  IF(CHAR_LENGTH(v.vendor_name) - CHAR_LENGTH(REPLACE(v.vendor_name, ' ', '')) > 0,	
     SUBSTRING_INDEX(SUBSTRING_INDEX(v.vendor_name, ' ', 2), ' ', -1), 
     '') AS second_word_vendor_name
FROM vendors v;

-- Bai 4:
select 
	i.invoice_number, 
    i.invoice_date, 
    DATE_ADD(i.invoice_date, INTERVAL 30 DAY) as day_plus_30_days, 
    i.payment_date,
    DATEDIFF(i.payment_date, i.invoice_date) as days_to_pay,
    MONTH(i.invoice_date) as 'Month',
    YEAR(i.invoice_date) as 'Year'
from invoices i
WHERE MONTH(i.invoice_date) = 5;

-- Bai 5:

-- Bai 6:

