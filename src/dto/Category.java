package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String name;

	/**
	 * Initialize object.
	 * 
	 * @param id          the identifier
	 * @param description the description
	 * @param name        the name
	 */
	public Category(int id, String description, String name) {
		this.id = id;
		this.description = description;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Known values
	public static final Category FRUITS = new Category(1, "Fruit", "Eg. apple, orange, banana");
	public static final Category VEGETABLES = new Category(2, "Vegetable", "Eg. cucumber, pepper, carrot");
	public static final Category DAIRY = new Category(3, "Dairy", "Eg. milk, eggs, butter");
	public static final Category SWEETS = new Category(4, "Sweet", "Eg. ice cream, cake, chocolate");
	public static final Category COOKED = new Category(5, "Cooked food", "Eg. chicken, beans, pasta");

}
