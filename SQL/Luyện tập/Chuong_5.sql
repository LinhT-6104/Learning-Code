-- Chuong 5
-- Ex 1
insert into terms
values(6, 'Net due 120 days', 120);
-- Ex 2
update terms
set terms_description = 'Net due 125 days', terms_due_days = 125
where terms_id = 6;
-- Ex 3
delete from terms
where terms_id = 6;
-- Ex 4
insert into invoices
values(default, 32, 'AX-014-027', '2018-8-1', 434.58, 0, 0, 2, '2018-8-31', null);
-- Ex 5
insert into invoice_line_items
values (last_insert_id(), 1, 160, 180.23, 'Hard drive');
insert into invoice_line_items
values (last_insert_id(), 2, 527, 254.35, 'Exchange Sever update');
-- Ex 6
update invoices
set credit_total = 0.1 * invoice_total, payment_total = invoice_total*0.9
where invoice_id = last_insert_id();
-- Ex 7
update vendors
set default_account_number = 403
where vendor_id = 44;
-- Ex 8
update invoices
set terms_id = 2 
where vendor_id in (select vendor_id from vendors where default_terms_id = 2);
-- Ex 9
delete from invoice_line_items
where invoice_id = last_insert_id();
delete from invoices
where invoice_id = last_insert_id();