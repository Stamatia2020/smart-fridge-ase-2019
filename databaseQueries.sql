CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(255),
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

-- Insert known values
INSERT INTO category VALUES(1, 'Fruit', 'Eg. apple, orange, banana');
INSERT INTO category VALUES(2, 'Vegetable', 'Eg. cucumber, pepper, carrot');
INSERT INTO category VALUES(3, 'Dairy', 'Eg. milk, eggs, butter');
INSERT INTO category VALUES(4, 'Sweet', 'Eg. ice cream, cake, chocolate');
INSERT INTO category VALUES(5, 'Cooked food', 'Eg. chicken, beans, pasta');

CREATE TABLE food (
	id IDENTITY,
	name VARCHAR(50),
	quantity INT NOT NULL,
	calories DOUBLE NOT NULL,
	category_id INT NOT NULL,
	CONSTRAINT pk_food_id PRIMARY KEY (id),
	CONSTRAINT fk_food_category_id FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE user (
	id IDENTITY,
	name VARCHAR(50),
	weight DOUBLE NOT NULL,
	height DOUBLE NOT NULL,
	age INT NOT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY (id)
);

CREATE TABLE user_food (
	user_id INT,
	food_id INT,
	CONSTRAINT pk_user_food_id PRIMARY KEY (user_id, food_id),
	CONSTRAINT fk_user_food_user_id FOREIGN KEY (user_id) REFERENCES user (id),
	CONSTRAINT fk_user_food_food_id FOREIGN KEY (food_id) REFERENCES food (id)	
);