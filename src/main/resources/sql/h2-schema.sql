CREATE TABLE IF NOT EXISTS category (
	id IDENTITY,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(255),
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS food (
	id IDENTITY,
	name VARCHAR(50),
	quantity INT NOT NULL,
	calories DOUBLE NOT NULL,
	category_id INT NOT NULL,
	CONSTRAINT pk_food_id PRIMARY KEY (id),
	CONSTRAINT fk_food_category_id FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS user (
	id IDENTITY,
	name VARCHAR(50),
	weight DOUBLE NOT NULL,
	height DOUBLE NOT NULL,
	age INT NOT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_food (
	user_id INT,
	food_id INT,
	CONSTRAINT pk_user_food_id PRIMARY KEY (user_id, food_id),
	CONSTRAINT fk_user_food_user_id FOREIGN KEY (user_id) REFERENCES user (id),
	CONSTRAINT fk_user_food_food_id FOREIGN KEY (food_id) REFERENCES food (id)	
);