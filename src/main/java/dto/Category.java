package main.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String name;
    private String description;

	/**
	 * Initialize object.
	 * 
	 * @param id          the identifier
	 * @param description the description
	 * @param name        the name
	 */
	public Category(int id, String name, String description) {
		this.name = name;
        this.description = description;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {
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

    @Override
    public String toString() {
        return this.name;
    }

    //Known values
    public static final Category COOKED = new Category("Cooked food", "Eg. chicken, beans, pasta");
    public static final Category DAIRY = new Category("Dairy", "Eg. milk, eggs, butter");
    public static final Category FRUITS = new Category("Fruit", "Eg. apple, orange, banana");
	public static final Category SWEETS = new Category("Sweet", "Eg. ice cream, cake, chocolate");
    public static final Category VEGETABLES = new Category("Vegetable", "Eg. cucumber, pepper, carrot");
}
