/* header */
/*                               field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code */
INSERT INTO def_down_up VALUES (1, 'sku production H', 'SKU', 'header', 1, 5, 'integer', '1');
INSERT INTO def_down_up VALUES (2, 'ship_date', 'Ship Date', 'header', 6, 10, 'date', '1');
INSERT INTO def_down_up VALUES (3, 'desc', 'Description', 'header', 16, 6, 'string', '1');

/* order */
INSERT INTO def_down_up VALUES (4, 'sku production O', 'SKU', 'order', 1, 9, 'string', '1');
INSERT INTO def_down_up VALUES (5, 'description', 'DESC', 'order', 10, 8, 'string', '1');
INSERT INTO def_down_up VALUES (6, 'quantity', 'QTY', 'order', 18,3, 'integer', '1');

/* carton */
INSERT INTO def_down_up VALUES (7, 'carton_id production C', 'ID', 'carton', 1, 4, 'string', '1');
INSERT INTO def_down_up VALUES (8, 'is_full', 'IS_FULL', 'carton', 5, 1, 'boolean', '1');
INSERT INTO def_down_up VALUES (9, 'unit_price', 'UNIT_PRICE', 'carton', 6, 6, 'float', '1');