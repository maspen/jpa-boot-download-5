/*  Duplicate of src/test/resources/test-HOT-data.sql   */

/*
 * NOTE: added 'entity_type' so we can easily tell if its header, order line ...
 *                                entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code 
INSERT INTO def_down_up VALUES (1, 'sku production H', 'SKU', 'header', 1, 5, 'integer', '1');
*/
/* Header */
/*INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (1, 1, 'rectype', '1', 'LITERAL(0-1)', 0, 1, 'char', '1');*/
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (2, 1, 'ITEMDWN', 'comment_1', 'eporder', 1, 7, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (3, 1, 'ADD', 'comment_2', 'eporder', 8, 3, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (4, 1, 'WAAVE_ID', 'dl_batch', 'eporder', 11, 9, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (5, 1, 'c oder nbr', 'c_order_nbr', 'eporder', 20, 9, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (6, 1, 'l item nbr', 'misc_field_1', 'eporder', 29, 5, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (7, 1, 'PICK', 'comment_3', 'eporder', 34, 3, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (8, 1, 'location', 'comment_4', 'eporder', 37, 10, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (9, 1, 'SKU', 'comment_5', 'eporder', 47, 7, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (10, 1, 'SKU DESC', 'comment_6', 'eporder', 54, 5, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (11, 1, 'prefix', 'comment_8', 'eporder', 66, 7, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (12, 1, 'order nbr', 'order_nbr', 'eporder', 66, 7, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (13, 1, 'carton nbr', 'carton_id', 'eporder', 73, 7, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (14, 1, 'ORDERED', 'misc_int1', 'eporder', 80, 7, 'int', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (15, 1, 'future1', 'misc_field_2', 'eporder', 87, 8, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (16, 1, 'Future2', 'misc_field_3', 'eporder', 95, 7, 'char', '1');
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (17, 1, 'wave id', 'comment_9', 'eporder', 102, 8, 'char', '1');
/* Order Line Item */
/*INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (18, 2, 'rectype', '2', 'LITERAL(0-1)', 0, 1, 'char', 1);*/
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (19, 2, 'l item nbr', 'misc_field_1', 'orderh', 1, 19, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (20, 2, 'Location', 'slot_name', 'orderh', 20, 9, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (21, 2, 'SKU', 'sku_code', 'orderh', 29, 5, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (22, 2, 'SKU DESC', 'sku_description', 'orderl', 34, 14, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (23, 2, 'SKU DESC2', 'cust_sku_desc', 'orderl', 48, 7, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (24, 2, 'PREFIX', 'cust_sku_upc', 'orderl', 55, 5, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (25, 2, 'ordered', 'q_ordered', 'orderl', 60, 7, 'integer', 1); /* field table name was 'ordered - orderl' */
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (26, 2, 'Future1', 'misc_Field_2', 'orderl', 67, 8, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (27, 2, 'Future2', 'misc_field_3', 'orderl', 75, 9, 'char', 1);
INSERT INTO def_down_up (id, entity_type, field_name, field_title, field_tab_name, index_start, index_length, data_type, record_code) VALUES (28, 2, 'Future3', 'misc_field_4', 'orderl', 84, 10, 'char', 1);