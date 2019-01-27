CREATE TABLE category (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
	
);