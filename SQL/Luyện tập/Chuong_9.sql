-- Chuong 9
-- Ex 1
select 
	invoice_total, 
    round(invoice_total, 1),
    round(invoice_total, 0),
    truncate(invoice_total, 0)
from invoices;
-- Ex 2

-- Ex 3
select 
	vendor_name, 
    upper(vendor_name) as capital_letters,
    vendor_phone,
    right(vendor_phone, 4) as last_four_digit,
    concat(substring(2, 3), '.',
		   substring(7, 3), '.',
           substring(11, 3)) as vendor_phone_format,
	if (char_length(vendor_name) - char_length(replace(vendor_name, ' ', '')) > 0,
		substring_index(substring_index(vendor_name, ' ', 2), ' ', -1),
        '') as second_word
from vendors;

-- Ex 4
select 
	invoice_number,
    invoice_date,
    date_add(invoice_date, interval 30 day),
    payment_date,
    datediff(payment_date, invoice_date) as days_to_pay,
    month(invoice_date)  as month,
    year(invoice_date) as year
from invoices
where month(invoice_date) = 5;