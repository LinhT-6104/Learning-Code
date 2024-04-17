-- Chapter 11:
-- Bai 1:
CREATE INDEX idx_zip_code ON Vendors (zip_code);

-- Bai 2:
-- Drop tables if they exist
DROP TABLE IF EXISTS members_committees;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS committees;
-- Create Members table
CREATE TABLE members (
    member_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    phone VARCHAR(20)
);
-- Create Committees table
CREATE TABLE committees (
    committee_id INT PRIMARY KEY,
    committee_name VARCHAR(100)
);
-- Create Members_Committees table
CREATE TABLE members_committees (
    member_id INT,
    committee_id INT,
    FOREIGN KEY (member_id) REFERENCES members(member_id),
    FOREIGN KEY (committee_id) REFERENCES committees(committee_id),
    PRIMARY KEY (member_id, committee_id)
);

-- Bai 3:
-- INSERT statements
INSERT INTO members (member_id, first_name, last_name, address, city, state, phone)
VALUES
    (1, 'John', 'Doe', '123 Main St', 'Anytown', 'NY', '555-123-4567'),
    (2, 'Jane', 'Smith', '456 Elm St', 'Othertown', 'CA', '555-987-6543');
INSERT INTO committees (committee_id, committee_name)
VALUES
    (1, 'Finance Committee'),
    (2, 'Membership Committee');
INSERT INTO members_committees (member_id, committee_id)
VALUES
    (1, 2),
    (2, 1),
    (2, 2);
-- SELECT statement
select c.committee_name, m.last_name, m.first_name
from members m 
join members_committees mc on m.member_id = mc.member_id
join committees c on mc.committee_id = c.committee_id
order by c.committee_name, m.last_name, m.first_name;

-- Bai 4:
ALTER TABLE members
add COLUMN annual_dues DECIMAL(5, 2) default 52.50, 
add column payment_date DATE;

-- Bai 5:
ALTER table committees
add UNIQUE(committee_name);

INSERT INTO committees 
values (1, 'Finance Committee');

-- Chapter 12:
-- Bai 1:
CREATE VIEW open_items AS
SELECT
    V.vendor_name,
    I.invoice_number,
    I.invoice_total,
    (I.invoice_total - I.payment_total - I.credit_total) AS balance_due
FROM Vendors V JOIN Invoices I ON V.vendor_id = I.vendor_id
WHERE (I.invoice_total - I.payment_total - I.credit_total) > 0
ORDER BY V.vendor_name;

-- Bai 2:
SELECT * 
from open_items
WHERE balance_due >= 1000;

-- Bai 3:
create view open_items_summary as
	select 
    	vendor_name,
        COUNT(*) as open_item_count,
        SUM(balance_due) as open_item_total
    from open_items
    group by vendor_name
    order by open_item_total DESC;

-- Bai 4:
select * from open_items_summary
limit 5;

-- Bai 5:
CREATE view vendor_address AS
	SELECT vendor_id, vendor_address1, vendor_address2
    from vendors;
    
-- Bai 6:
update vendor_address 
set vendor_address2 = 'Ste 260', vendor_address1 = NULL
WHERE vendor_id = 4;

-- view, transaction, procedure, function