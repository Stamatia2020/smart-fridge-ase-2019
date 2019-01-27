CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

-- Insert known values
INSERT INTO category VALUES(1, 'Fruit', 'Eg. apple, orange, banana');
INSERT INTO category VALUES(2, 'Vegetable', 'Eg. cucumber, pepper, carrot');
INSERT INTO category VALUES(3, 'Dairy', 'Eg. milk, eggs, butter');
INSERT INTO category VALUES(4, 'Sweet', 'Eg. ice cream, cake, chocolate');
INSERT INTO category VALUES(5, 'Cooked food', 'Eg. chicken, beans, pasta');