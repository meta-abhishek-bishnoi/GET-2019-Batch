package meta.hierarchy;

public class Mammels extends Animal {

	String food;
	String categoryName;
	//List<Zone> zone;
	public Mammels(String name, double age, double weight, String food, String categoryName) {
		super(name, age, weight);
		this.food = food;
		this.categoryName = categoryName;
	}
	public String getFood(){
		return this.food;
	}
	public String getCategoryName(){
		return this.categoryName;
	}

}
