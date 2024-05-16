-- Bai 1
SELECT invoice_id, COUNT(*) AS so_dong_don_hang
FROM invoice_line_items
GROUP BY invoice_id
HAVING so_dong_don_hang = (
    SELECT COUNT(*) AS max_so_dong_don_hang
    FROM invoice_line_items
    GROUP BY invoice_id
    ORDER BY max_so_dong_don_hang DESC
    LIMIT 1
);

-- Bai 2
create or replace view View_Vendor_725105115 as
select 
 v.vendor_id, v.vendor_name, v.vendor_address1, 
    v.vendor_contact_last_name, v.vendor_contact_first_name,
    count(*) as num_invoice
from invoices as i join vendors as v on i.vendor_id = v.vendor_id
group by v.vendor_id;

select vendor_id, vendor_name, num_invoice
from View_Vendor_725105115
having num_invoice > 5;

-- Bai 3
-- Xóa thủ tục nếu tồn tại
DROP PROCEDURE IF EXISTS proc_725105115;

-- Đặt Delimiter
DELIMITER //

-- Tạo thủ tục proc_725105115
CREATE PROCEDURE proc_725105115 (
    IN Account_number_pa INT,
    OUT Total_vendor_pa INT,
    OUT Total_LineItemAmount_pa DECIMAL(10, 2)
)
BEGIN
    -- Biến tạm thời để lưu tổng số vendor và tổng số tiền chi tiết đơn hàng
    DECLARE total_vendor INT;
    DECLARE total_line_item_amount DECIMAL(10, 2);
    
    -- Tính tổng số vendor cho account_number
    SELECT COUNT(*) INTO total_vendor
    FROM vendors
    WHERE default_account_number = Account_number_pa;
    
    -- Tính tổng số tiền chi tiết đơn hàng cho account_number
    SELECT SUM(line_item_amount) INTO total_line_item_amount
    FROM invoice_line_items
    WHERE account_number = Account_number_pa;
    
    -- Gán giá trị của các biến tạm thời vào các biến đầu ra
    SET Total_vendor_pa = total_vendor;
    SET Total_LineItemAmount_pa = total_line_item_amount;
END //

-- Kết thúc Delimiter
DELIMITER ;

-- Gọi thủ tục và in ra giá trị của hai biến đầu ra
CALL proc_725105115(591, @Total_vendor, @Total_LineItemAmount);

-- In ra giá trị của hai biến đầu ra
SELECT @Total_vendor AS Total_vendor, @Total_LineItemAmount AS Total_LineItemAmount;

select * from general_ledger_accounts;
select * from vendors where default_account_number = 591;