CREATE TABLE shop_item
(shop_id CHAR(4) NOT NULL,
shop_name VARCHAR2(200) NOT NULL,
 item_id CHAR(4) NOT NULL,
 quantity NUMBER NOT NULL,
PRIMARY KEY (shop_id, item_id));

INSERT INTO shop_item (shop_id, shop_name, item_id, quantity) VALUES ('000A', '東京', '0001', 30);
INSERT INTO shop_item (shop_id, shop_name, item_id, quantity) VALUES ('000A', '東京', '0002', 50);
INSERT INTO shop_item (shop_id, shop_name, item_id, quantity) VALUES ('000B', '仙台', '0002', 30);
INSERT INTO shop_item (shop_id, shop_name, item_id, quantity) VALUES ('000B', '仙台', '0006', 10);
INSERT INTO shop_item (shop_id, shop_name, item_id, quantity) VALUES ('000C', '大阪', '0003', 20);
INSERT INTO shop_item (shop_id, shop_name, item_id, quantity) VALUES ('000C', '大阪', '0007', 70);
INSERT INTO shop_item (shop_id, shop_name, item_id, quantity) VALUES ('000D', '福岡', '0001', 50);

COMMIT;


CREATE TABLE stock_item
(house_id CHAR(4) NOT NULL,
item_id CHAR(4) NOT NULL,
stock NUMBER NOT NULL,
PRIMARY KEY(house_id, item_id)
);


INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0001', 0);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0002',120);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0003',200);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0004',3);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0005',0);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0006',99);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0007',999);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S001', '0008',200);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0001',10);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0002',25);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0003',34);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0004',19);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0005',99);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0006',0);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0007',0);
INSERT INTO stock_item (house_id, item_id, stock) VALUES('S002', '0008',18);

COMMIT;


SELECT si.shop_id, si.shop_name, si.item_id, i.item_name, i.sel_price,
si.quantity, sti.stock
FROM shop_item si INNER JOIN item i ON si.item_id = i.item_id
INNER JOIN stock_item sti ON si.item_id = sti.item_id 
WHERE sti.house_id = 'S001';

SELECT
si.shop_id,
si.shop_name,
si.item_id,
i.item_name,
i.sel_price,
si.quantity
FROM item I LEFT OUTER JOIN shop_item si
ON i.item_id = si.item_id;

