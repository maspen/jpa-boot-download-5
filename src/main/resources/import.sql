/* Header - 16 values */
/*INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'rectype', '1', 'LITERAL(0-1)', 0, 1, 'char', '1');*/
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'ITEMDWN', 'comment_1', 'eporder', 1, 7, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'ADD', 'comment_2', 'eporder', 8, 3, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'WAAVE_ID', 'dl_batch', 'eporder', 11, 9, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'c oder nbr', 'c_order_nbr', 'eporder', 20, 9, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'l item nbr', 'misc_field_1', 'eporder', 29, 5, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'PICK', 'comment_3', 'eporder', 34, 3, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'location', 'comment_4', 'eporder', 37, 10, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'SKU', 'comment_5', 'eporder', 47, 7, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'SKU DESC', 'comment_6', 'eporder', 54, 5, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'prefix', 'comment_8', 'eporder', 66, 7, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'order nbr', 'order_nbr', 'eporder', 66, 7, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'carton nbr', 'carton_id', 'eporder', 73, 7, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'ORDERED', 'misc_int1', 'eporder', 80, 7, 'int', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'future1', 'misc_field_2', 'eporder', 87, 8, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'Future2', 'misc_field_3', 'eporder', 95, 7, 'char', '1');
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 'wave id', 'comment_9', 'eporder', 102, 8, 'char', '1');
/* Order Line Item - 10 values*/
/*INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'rectype', '2', 'LITERAL(0-1)', 0, 1, 'char', 1);*/
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'l item nbr', 'misc_field_1', 'orderh', 1, 19, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'Location', 'slot_name', 'orderh', 20, 9, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'SKU', 'sku_code', 'orderh', 29, 5, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'SKU DESC', 'sku_description', 'orderl', 34, 14, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'SKU DESC2', 'cust_sku_desc', 'orderl', 48, 7, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'PREFIX', 'cust_sku_upc', 'orderl', 55, 5, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'ordered', 'q_ordered', 'orderl', 60, 7, 'integer', 1); /* field table name was 'ordered - orderl' */
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'Future1', 'misc_Field_2', 'orderl', 67, 8, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'Future2', 'misc_field_3', 'orderl', 75, 9, 'char', 1);
INSERT INTO mappers (entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 'Future3', 'misc_field_4', 'orderl', 84, 10, 'char', 1);