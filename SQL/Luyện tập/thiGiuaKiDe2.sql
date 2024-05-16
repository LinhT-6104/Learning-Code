-- 1
select invoice_id, invoice_sequence
from invoice_line_items
where invoice_sequence = (select max(invoice_sequence) from invoice_line_items);

-- 2
create or replace view View_Vendor_725105115 as
	select v.vendor_id, v.vendor_name, v.vendor_address1, v.vendor_contact_last_name, v.vendor_contact_first_name, count(*) as tongSoHoaDon
    from vendors as v join invoices as i on i.vendor_id = v.vendor_id
    group by v.vendor_id;
select vendor_id, vendor_name, tongSoHoaDon from View_Vendor_725105115
where tongSoHoaDon > 5;

-- 3 
DROP PROCEDURE IF EXISTS proc_725105115;
DELIMITER //

CREATE PROCEDURE proc_725105115 (
    IN Account_number_pa INT,
    OUT Total_vendor_pa INT,
    OUT Total_LineItemAmount_pa DECIMAL(9,2)
)
BEGIN
    -- Tính tổng số vendor cho account_number được truyền vào
    SELECT COUNT(*) INTO Total_vendor_pa
    FROM vendors
    WHERE default_account_number = Account_number_pa;

    -- Tính tổng số tiền chi tiết đơn hàng của từng account
    SELECT SUM(line_item_amount) INTO Total_LineItemAmount_pa
    FROM invoice_line_items
    WHERE invoice_line_items.account_number = Account_number_pa;
END //

DELIMITER ;

CALL proc_725105115(570, @Total_vendor, @Total_LineItemAmount);
SELECT @Total_vendor, @Total_LineItemAmount;
