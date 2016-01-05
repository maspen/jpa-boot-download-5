DROP TABLE IF EXISTS mappers;
CREATE TABLE mappers (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  entity_type INTEGER,
  field_name VARCHAR(30),
  field_title VARCHAR(30),
  field_tab_name VARCHAR(30),
  index_start INTEGER,
  index_length INTEGER,
  data_type VARCHAR(10),
  record_code VARCHAR(1) /* 1=down, 2=up ... */
);