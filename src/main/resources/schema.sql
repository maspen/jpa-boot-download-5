/* contains the mappings that are used to parse the input strings */
DROP TABLE IF EXISTS def_down_up;
CREATE TABLE def_down_up (
	/*id INTEGER NOT NULL PRIMARY KEY,*/
	/*id INTEGER NOT NULL,*/
	/*id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,*/
	/*id INTEGER NOT NULL PRIMARY KEY,*/
	/*id INT IDENTITY,*/
	/*id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),*/
	/*id INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,*/
	id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	entity_type INTEGER,
	field_name VARCHAR(30),
	field_title VARCHAR(30),
	field_tab_name VARCHAR(30),
	index_start INTEGER,
	index_length INTEGER,
	data_type VARCHAR(10),
	record_code VARCHAR(1), /* 1=down, 2=up ... */
	PRIMARY KEY (id)
);
/* small subset of the eporder table */
DROP TABLE IF EXISTS eporder;
CREATE TABLE eporder (
	/*id INTEGER NOT NULL PRIMARY KEY,*/
	/*id INTEGER NOT NULL,*/
	/*id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,*/
	/*id INTEGER NOT NULL PRIMARY KEY,*/
	/*id INT IDENTITY,*/
	/*id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),*/
	/*id INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,*/
	id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	sequence_number INTEGER, /* created in the header & 'associates' w/ order lines */
	comment_1 VARCHAR(30),
	comment_2 VARCHAR(30),
	dl_batch VARCHAR(30),
	c_order_nbr VARCHAR(30),
	misc_field_1 VARCHAR(30),
	comment_3 VARCHAR(30),
	comment_4 VARCHAR(30),
	comment_5 VARCHAR(30),
	comment_6 VARCHAR(30),
	comment_8 VARCHAR(30),
	order_nbr VARCHAR(30),
	carton_id VARCHAR(30),
	misc_int1 INTEGER,
	misc_field_2 VARCHAR(30),
	misc_field_3 VARCHAR(30),
	comment_9 VARCHAR(30),
	PRIMARY KEY (id)
);

/* small subset of the orderh table */
DROP TABLE IF EXISTS orderh;

/* small subset of the orderl table */
DROP TABLE IF EXISTS orderl;