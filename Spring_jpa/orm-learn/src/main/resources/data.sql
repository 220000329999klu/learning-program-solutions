CREATE DATABASE orm_learn;
USE orm_learn;

CREATE TABLE country (
  code VARCHAR(2) PRIMARY KEY,
  name VARCHAR(100)
);

INSERT INTO country VALUES ('IN', 'India'), ('US', 'United States'), ('CN', 'China');