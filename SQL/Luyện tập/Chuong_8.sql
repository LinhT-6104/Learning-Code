-- Chuong 8
-- Ex 1
SELECT
    invoice_total,
    FORMAT(invoice_total, 1) AS total_format,
    CONVERT(invoice_total, signed) AS total_convert,
    cast(invoice_total as signed) as total_cast
FROM
    invoices;

-- Ex 2 // Loi 
select 
	invoice_date, 
	cast(invoice_date as datetime), 
    cast(invoice_date as date) as Year_and_month
from invoices

