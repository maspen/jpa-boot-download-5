DROP TABLE IF EXISTS def_down_up;
CREATE TABLE def_down_up (
	id INTEGER NOT NULL PRIMARY KEY,
	field_name VARCHAR(30),
	field_title VARCHAR(30),
	field_tab_name VARCHAR(30),
	index_start INTEGER,
	index_length INTEGER,
	data_type VARCHAR(10),
	record_code VARCHAR(1) /* 1=down, 2=up ... */
);